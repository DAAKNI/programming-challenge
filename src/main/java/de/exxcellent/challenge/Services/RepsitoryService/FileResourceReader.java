package de.exxcellent.challenge.Services.RepsitoryService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileResourceReader implements IResourceReader{
    private static final Logger logger = LogManager.getLogger(FileResourceReader.class);

    /**
     * Method for reading local files
     * @param resource Path to a local file
     * @return Content of a file
     */
    @Override
    public List<String> read(String resource) {

        File file = new File(resource);
        List<String> content = new ArrayList<>();

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
        return content;
    }
}
