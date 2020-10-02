package de.exxcellent.challenge.Services;

import de.exxcellent.challenge.Config.FileType;
import de.exxcellent.challenge.Models.FileData;
import de.exxcellent.challenge.Models.FileWrapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProcessorServiceTest {
    @Test
    public void GetSmallestTemperatureSpread() {
        RepositoryService repositoryService = new RepositoryService();

        ParserService parserService = new ParserService();
        ProccesorService proccesorService = new ProcessorService();
        FileWrapper rawData = new FileWrapper();
        try {
            rawData = repositoryService.get("src/main/resources/de/exxcellent/challenge/weather.csv");
        } catch (Exception e) {
            e.printStackTrace();
        }
        FileData fileData = parserService.parse(rawData);
        String result = proccesorService.calculateMinSpread(fileData);

        assertEquals("14", result);
    }
}
