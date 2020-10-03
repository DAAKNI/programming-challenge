package de.exxcellent.challenge.Services.ParserService;

import de.exxcellent.challenge.Models.FileData;
import de.exxcellent.challenge.Models.FileWrapper;
import de.exxcellent.challenge.exceptions.InvalidCSVException;
import de.exxcellent.challenge.exceptions.InvalidFileContentException;
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
    public FileData parse(FileWrapper rawData) throws InvalidFileContentException {

        List<String> contentRaw = rawData.getFileData();
        List<List<String>> contentParsed;

        if(contentRaw.size() == 0 ) {
            throw new InvalidFileContentException("File seems to be empty");
        }


        IParser parser = new CSVParser();
        contentParsed = parser.parse(contentRaw);

        FileData fileData = new FileData();
        fileData.setContent(contentParsed);

        logger.info("Parsed file.");
        return fileData;
    }
}
