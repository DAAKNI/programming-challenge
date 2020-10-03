package de.exxcellent.challenge.Services.ParserService;

import de.exxcellent.challenge.Models.FileData;
import de.exxcellent.challenge.Models.FileWrapper;
import de.exxcellent.challenge.Services.RepsitoryService.FileResourceReader;
import de.exxcellent.challenge.exceptions.InvalidCSVException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CSVParser implements IParser {
    private static final Logger logger = LogManager.getLogger(CSVParser.class);

    /**
     * Takes a List of CSV-strings separate them into a nested list / 2D Arraylist
     * @param rawData Takes in a ArrayList of strings each string representing a row in CSV
     * @return A nested ArrayList with the String representing single values of CSV
     * @throws InvalidCSVException
     */
    @Override
    public List<List<String>> parse(List<String> rawData) throws InvalidCSVException {
        List<List<String>> contentParsed = new ArrayList<>();

        // Split strings into arraylists using the delimter ","
        contentParsed = rawData.stream().map((line) -> Arrays.asList(line.split(","))).collect(Collectors.toList());

        // Check if all rows have the same length
        for (List<String> row : contentParsed ) {
            if(row.size() != contentParsed.get(0).size()) {
                throw new InvalidCSVException("Structure of CSV Invalid");
            }
        }
        logger.info("Parsed CSV file");
        return contentParsed;
    }
}
