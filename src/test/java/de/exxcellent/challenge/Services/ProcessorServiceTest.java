package de.exxcellent.challenge.Services;

import de.exxcellent.challenge.Models.FileData;
import de.exxcellent.challenge.Models.FileWrapper;
import de.exxcellent.challenge.Services.ParserService.ParserService;
import de.exxcellent.challenge.Services.RepsitoryService.RepositoryService;
import de.exxcellent.challenge.exceptions.InvalidCSVException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProcessorServiceTest {
    @Test
    public void testGetSmallestTemperatureSpread() throws InvalidCSVException {
        RepositoryService repositoryService = new RepositoryService();

        ParserService parserService = new ParserService();
        ProcesorService procesorService = new ProcesorService();
        FileWrapper rawData = new FileWrapper();
        try {
            rawData = repositoryService.get("src/main/resources/de/exxcellent/challenge/weather.csv");
        } catch (Exception e) {
            e.printStackTrace();
        }
        FileData fileData = parserService.parse(rawData);
        String result = procesorService.calculateMinSpread(fileData, "MxT", "MnT");

        assertEquals("14", result);
    }

    @Test
    public void testGetSmallestGoalSpread() throws InvalidCSVException {

        RepositoryService repositoryService = new RepositoryService();
        ParserService parserService = new ParserService();
        ProcesorService procesorService = new ProcesorService();
        FileWrapper rawData = new FileWrapper();
        try {
            rawData = repositoryService.get("src/main/resources/de/exxcellent/challenge/football.csv");
        } catch (Exception e) {
            e.printStackTrace();
        }
        FileData fileData = parserService.parse(rawData);
        String result = procesorService.calculateMinSpread(fileData, "Goals", "Goals Allowed");

        assertEquals("Aston_Villa", result);
    }
}
