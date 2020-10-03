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
     * Service to parse data from a List of Strings
     * depending on the type of data
     * @param rawData
     * @return
     * @throws InvalidFileContentException
     */
    public FileData parse(FileWrapper rawData) throws InvalidFileContentException {

        List<String> contentRaw = rawData.getFileData();
        List<List<String>> contentParsed;

        if(contentRaw.size() == 0 ) {
            throw new InvalidFileContentException("File seems to be empty");
        }

        // Get parser depending on filetype
        ParserFactory parserFactory = new ParserFactory();
        IParser parser = parserFactory.getParser(rawData.getFileType());

        // Parse file content
        contentParsed = parser.parse(contentRaw);

        FileData fileData = new FileData();
        fileData.setContent(contentParsed);

        logger.info("Parsed file.");
        return fileData;
    }
}
