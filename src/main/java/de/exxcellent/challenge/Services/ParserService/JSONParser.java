package de.exxcellent.challenge.Services.ParserService;

import de.exxcellent.challenge.exceptions.InvalidFileContentException;

import java.util.List;

public class JSONParser implements IParser {

    /**
     * Takes a JSON file seperated into list of string  and turns them into a nested list / 2D Arraylist
     * @param rawData
     * @return
     * @throws InvalidFileContentException
     */
    @Override
    public List<List<String>> parse(List<String> rawData) throws InvalidFileContentException {
        // #todo Daakni: Implement JSON parse functionality
        return null;
    }
}
