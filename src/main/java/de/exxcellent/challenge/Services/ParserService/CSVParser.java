package de.exxcellent.challenge.Services.ParserService;

import de.exxcellent.challenge.Models.FileData;
import de.exxcellent.challenge.Models.FileWrapper;
import de.exxcellent.challenge.exceptions.InvalidCSVException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CSVParser implements IParser {
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

        return contentParsed;
    }
}
