package de.exxcellent.challenge.Services.ParserService;

import de.exxcellent.challenge.Models.FileData;
import de.exxcellent.challenge.Models.FileWrapper;

import java.io.BufferedReader;

public interface IParser {
    public FileData parse(FileWrapper rawData);
}
