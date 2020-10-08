package de.exxcellent.challenge.Services.ParserService;

import de.exxcellent.challenge.Models.FileData;
import de.exxcellent.challenge.Models.FileWrapper;
import de.exxcellent.challenge.exceptions.InvalidFileContentException;

import java.io.BufferedReader;
import java.util.List;

/**
 * Generic interface for a parser
 */
public interface IParser  {
    public List<List<String>> parse(List<String> rawData) throws InvalidFileContentException;
}
