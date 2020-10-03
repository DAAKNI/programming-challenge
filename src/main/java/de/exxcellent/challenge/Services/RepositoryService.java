package de.exxcellent.challenge.Services;

import de.exxcellent.challenge.App;
import de.exxcellent.challenge.Config.FileType;
import de.exxcellent.challenge.Models.FileWrapper;
import de.exxcellent.challenge.exceptions.FileNotSupportedException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class RepositoryService {

    private static final Logger logger = LogManager.getLogger(RepositoryService.class);

    public FileWrapper get(String resource) throws FileNotSupportedException {


        logger.info("Reading file.");
        String fileName;
        String fileExtension;
        File file = new File(resource);
        FileWrapper fileWrapper = new FileWrapper();
        List<String> content = new ArrayList<>();

        // Extract filename and ending
        if (resource.contains("/")) {
            fileName = resource.substring(resource.lastIndexOf("/")+1);
            fileExtension = fileName.substring(fileName.indexOf(".")+1);
        } else {
            fileName = resource;
            fileExtension = fileName.substring(fileName.indexOf(".")+1);
        }

//        if(FileType.valueOf(fileExtension.toUpperCase()))
        try {
            fileWrapper.setFileType(FileType.valueOf(fileExtension.toUpperCase()));
        } catch (IllegalArgumentException e) {
            throw new FileNotSupportedException("Filetype of " + fileName + " not supported", e);
        }

        // Open local resource
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("Error Reading file");
        }


        fileWrapper.setFileData(content);
        fileWrapper.setFileName(fileName);


        return fileWrapper ;
    }


}
