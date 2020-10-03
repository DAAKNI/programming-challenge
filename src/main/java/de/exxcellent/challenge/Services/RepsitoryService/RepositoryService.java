package de.exxcellent.challenge.Services.RepsitoryService;

import de.exxcellent.challenge.Config.FileType;
import de.exxcellent.challenge.Models.FileWrapper;
import de.exxcellent.challenge.exceptions.FileNotSupportedException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RepositoryService {

    private static final Logger logger = LogManager.getLogger(RepositoryService.class);

    /**
     * Gets/Opens the content of a resource
     * @param resource Takes in a Path/URI to a file
     * @return Content of the file
     * @throws FileNotSupportedException
     */
    public FileWrapper get(String resource) throws FileNotSupportedException {

        logger.info("Reading file.");
        String fileName = getFileName(resource);
        String fileExtension = getFileExtension(resource);
        List<String> content = new ArrayList<>();
        FileWrapper fileWrapper = new FileWrapper();



        // Check if Filetyp is supported
        try {
            fileWrapper.setFileType(FileType.valueOf(fileExtension.toUpperCase()));
        } catch (IllegalArgumentException e) {
            throw new FileNotSupportedException("Filetype of " + fileName + " not supported", e);
        }


        ReaderFactory readerFactory = new ReaderFactory();
        IResourceReader reader = readerFactory.getReader(resource);
        content = reader.read(resource);

        fileWrapper.setFileData(content);
        fileWrapper.setFileName(fileName);


        return fileWrapper ;
    }

    /**
     * Extracts the filename from a resource
     * @param resource Path to a file
     * @return Name of the file
     */
    public String getFileName(String resource) {
        String fileName;
        if (resource.contains("/")) {
            fileName = resource.substring(resource.lastIndexOf("/")+1);
        } else {
            fileName = resource;
        }
        return fileName;
    }

    /**
     * Extracts the file extension of a resource
     * @param resource Path to a file
     * @return Extension of a file
     */
    public String getFileExtension(String resource) {
        return resource.substring(resource.lastIndexOf(".")+1);
    }


}
