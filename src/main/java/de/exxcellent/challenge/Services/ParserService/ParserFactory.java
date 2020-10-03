package de.exxcellent.challenge.Services.ParserService;

import de.exxcellent.challenge.Config.FileType;
import de.exxcellent.challenge.Models.FileWrapper;

public class ParserFactory {
    public IParser getParser(FileType type) {

        if (type== FileType.CSV){
            return new CSVParser();
        }

        if (type == FileType.JSON) {
            return new JSONParser();
        }
        return null;
    }
}