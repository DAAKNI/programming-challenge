package de.exxcellent.challenge.Services;

import de.exxcellent.challenge.Models.FileData;
import de.exxcellent.challenge.Services.ParserService.ParserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ProcesorService {

    private static final Logger logger = LogManager.getLogger(ParserService.class);

    /**
     * Takes in the parsed data can calcualte the differnce between two columns
     * @param fileData Takes in nested ArrayList representing a table
     * @param col1 Name of the first column that should be computed with
     * @param col2 Name of the second column that should be computed with
     * @return The row that contains the minimum spread of two columns
     */
    public String calculateMinSpread(FileData fileData, String col1, String col2) {
        if(fileData.getContent().isEmpty()) {
            logger.error("Not able to calc spread. Data is empty");
            return "";
        }

        List<String> header = fileData.getContent().get(0);
        List<String> rowNames = getRowNames(fileData.getContent());

        List<Integer> column1 = getColumnWithoutHeader(fileData.getContent(), header.indexOf(col1));
        List<Integer> column2 = getColumnWithoutHeader(fileData.getContent(), header.indexOf(col2));

        List<Integer> difference = subtractColumns(column1, column2);


        int minIndex = difference.indexOf(Collections.min(difference));
        logger.info("Calculated minimum of two columns");
        return rowNames.get(minIndex);
    }

    /**
     * Returns a specified column from a table
     * @param table Nested ArrayList representing a table
     * @param col Name of the column
     * @return Content of the column with out the name of the column
     */
    public List<Integer> getColumnWithoutHeader(List<List<String>> table, int col) {
        List<Integer> column = new ArrayList<>();
        for (int i =1; i < table.size(); i++ ) {
            column.add(Integer.parseInt(table.get(i).get(col)));
        }
        return column;
    }

    /**
     * Returns the first column/rownames
     * @param table Nested ArrayList representing a table
     * @return A list with the column names
     */
    public List<String> getRowNames(List<List<String>> table) {
        List<String> column = new ArrayList<>();
        for (int i =1; i < table.size(); i++ ) {
            column.add(table.get(i).get(0));
        }
        return column;
    }

    /**
     * Elementwise subtraction of to Integer Lists
     * @param column1 Name of the first column that should be computed with
     * @param column2 Name of the second column that should be computed with
     * @return Minimum spread of two lists
     */
    public List<Integer> subtractColumns(List<Integer> column1, List<Integer> column2) {
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < column1.size(); i++) {
            if(column1.get(i) > column2.get(i)) {
                result.add(column1.get(i) - column2.get(i));
            } else {
                result.add(column2.get(i) - column1.get(i));
            }
        }
        return result;

    }
}
