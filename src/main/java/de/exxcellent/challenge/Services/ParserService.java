package de.exxcellent.challenge.Services;

import de.exxcellent.challenge.Models.FileData;
import de.exxcellent.challenge.Models.FileWrapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParserService {
    private static final Logger logger = LogManager.getLogger(ParserService.class);

    // Takes the the List of CSV rows and seperated them into a nested list
    public FileData parse(FileWrapper rawData) {

        List<String> contentRaw = rawData.getFileData();
        List<List<String>> contentParsed = new ArrayList<>();

        contentParsed = contentRaw.stream().map((line) -> Arrays.asList(line.split(","))).collect(Collectors.toList());

        FileData fileData = new FileData();
        fileData.setContent(contentParsed);

        logger.info("Parsed file.");
        return fileData;
    }
}
