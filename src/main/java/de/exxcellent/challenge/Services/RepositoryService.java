package de.exxcellent.challenge.Services;

import de.exxcellent.challenge.Config.FileType;
import de.exxcellent.challenge.Models.FileWrapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class RepositoryService {

    public FileWrapper get(String resource) {
        String fileName;
        String fileExtension;
        File file = new File(resource);
        FileWrapper fileWrapper = new FileWrapper();
        List<String> content = new ArrayList<>();

        // Extract filename and ending
        if (resource.contains("/")) {
            fileName = resource.substring(resource.lastIndexOf("/"));
            fileExtension = fileName.substring(fileName.indexOf("."));
        } else {
            fileName = resource;
            fileExtension = fileName.substring(fileName.indexOf(".")+1);
        }

        // Open local resource
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        fileWrapper.setFileData(content);
        fileWrapper.setFileType(FileType.valueOf(fileExtension.toUpperCase()));
        fileWrapper.setFileName(fileName);


        return fileWrapper ;
    }


}
