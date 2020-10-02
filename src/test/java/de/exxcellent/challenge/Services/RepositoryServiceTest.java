package de.exxcellent.challenge.Services;

import de.exxcellent.challenge.Models.FileWrapper;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RepositoryServiceTest {

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
    public void testReadCSVFile(){
        RepositoryService repositoryService = new RepositoryService();
        FileWrapper rawData = new FileWrapper();
        try {
            rawData = repositoryService.get("test.csv");
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<String> testData = new ArrayList<>(Arrays.asList("A,B,C", "B,1,2","C,2,3"));
        assertEquals(testData, rawData.getFileData());
    }

    @AfterAll
    public static void deleteCSV() {
        File file = new File("test.csv");
        file.delete();
    }
}
