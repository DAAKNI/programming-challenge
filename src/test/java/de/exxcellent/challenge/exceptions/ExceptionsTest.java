package de.exxcellent.challenge.exceptions;

import de.exxcellent.challenge.Config.FileType;
import de.exxcellent.challenge.Models.FileData;
import de.exxcellent.challenge.Models.FileWrapper;
import de.exxcellent.challenge.Services.ParserService;
import de.exxcellent.challenge.Services.RepositoryService;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExceptionsTest {

    @Test
    public void testFileNotSupportedException() {
        RepositoryService rs = new RepositoryService();
        Exception exception = assertThrows(FileNotSupportedException.class, () -> {
                    rs.get("file.xyz");
                });


        String expectedMessage = "File not supported";
        String actualMessage = exception.getMessage();
        assertEquals("expectedMessage", exception.getMessage());
    }

    @Test
    public void testInvalidCSVException() {
        ParserService ps = new ParserService();
        FileWrapper invalidCSVFile = new FileWrapper();
        invalidCSVFile.setFileName("test.csv");
        invalidCSVFile.setFileType(FileType.CSV);

        List<String> invalidCSV = new ArrayList<>(Arrays.asList("A,B,C", "B,1","C,2,3,4"));
        invalidCSVFile.setFileData(invalidCSV);

        Exception exception = assertThrows(InvalidCSVException.class, () -> {
            ps.parse(invalidCSVFile);
        });


        String expectedMessage = "Invalid CSV";
        String actualMessage = exception.getMessage();
        assertEquals("expectedMessage", exception.getMessage());
    }

}

