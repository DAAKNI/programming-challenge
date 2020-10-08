package de.exxcellent.challenge.Services.ParserService;

import de.exxcellent.challenge.exceptions.InvalidFileContentException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class JSONParser implements IParser {
    private static final Logger logger = LogManager.getLogger(JSONParser.class);

    /**
     * Takes a JSON file seperated into list of string  and turns them into a nested list / 2D Arraylist
     * @param rawData Takes in a ArrayList of strings each string representing a row in a JSON file
     * @return A nested ArrayList with the String representing single value of a JSON
     * @throws InvalidFileContentException
     */
    @Override
    public List<List<String>> parse(List<String> rawData) throws InvalidFileContentException {
        // #todo Daakni: Implement JSON parse functionality
        return null;
    }
}
