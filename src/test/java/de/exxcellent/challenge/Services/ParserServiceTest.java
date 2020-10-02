package de.exxcellent.challenge.Services;

import de.exxcellent.challenge.Models.FileData;
import de.exxcellent.challenge.Models.FileWrapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserServiceTest {
    @BeforeAll
    public static void setupCSV() {
        try (FileWriter fileWriter = new FileWriter("test.csv");){
            String data = "A,B,C\nB,1,2\nC,2,3" ;
            fileWriter.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testParseCSVFile(){


        RepositoryService repositoryService = new RepositoryService();
        FileWrapper rawData = null;
        try {
            rawData = repositoryService.get("test.csv");
        } catch (Exception e) {
            e.printStackTrace();
        }


        ParserService parserService = new ParserService();
        FileData fileData = parserService.parse(rawData);

        List<List<String>> testData = new ArrayList<>();
        testData.add(Arrays.asList("A", "B", "C"));
        testData.add(Arrays.asList("B", "1", "2"));
        testData.add(Arrays.asList("C", "2", "3"));

        assertEquals(testData, fileData.getContent());

    }
}
