package de.exxcellent.challenge.Services;

import de.exxcellent.challenge.Models.FileWrapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class RepositoryService {

    public FileWrapper get(String resource) {

        File file = new File(resource);

        FileWrapper fileWrapper = new FileWrapper();

        List<String> content = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        fileWrapper.setFileData(content);


        return fileWrapper ;
    }


}
