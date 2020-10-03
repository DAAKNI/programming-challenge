package de.exxcellent.challenge.Services.ParserService;

import de.exxcellent.challenge.Models.FileData;
import de.exxcellent.challenge.Models.FileWrapper;
import de.exxcellent.challenge.exceptions.InvalidCSVException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParserService {
    private static final Logger logger = LogManager.getLogger(ParserService.class);



    /**
     * Takes a List of CSV-strings separate them into a nested list / 2D Arraylist
     * @param rawData
     * @return
     * @throws InvalidCSVException
     */
    public FileData parse(FileWrapper rawData) throws InvalidCSVException {

        List<String> contentRaw = rawData.getFileData();

        if(contentRaw.size() == 0 ) {
            throw new InvalidCSVException("CSV seems to be empty");
        }

        List<List<String>> contentParsed = new ArrayList<>();

        // Split strings into arraylists using the delimter ","
        contentParsed = contentRaw.stream().map((line) -> Arrays.asList(line.split(","))).collect(Collectors.toList());

        // Check if all rows have the same length
        for (List<String> row : contentParsed ) {
            if(row.size() != contentParsed.get(0).size()) {
                throw new InvalidCSVException("Structure of CSV Invalid");
            }
        }

        FileData fileData = new FileData();
        fileData.setContent(contentParsed);

        logger.info("Parsed file.");
        return fileData;
    }
}
