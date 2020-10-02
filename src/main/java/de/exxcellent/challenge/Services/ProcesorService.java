package de.exxcellent.challenge.Services;

import de.exxcellent.challenge.Models.FileData;

import javax.naming.StringRefAddr;
import java.io.File;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class ProcesorService {
    public String calculateMinSpread(FileData fileData, String col1, String col2) {

        List<String> header = fileData.getContent().get(0);
        List<String> rowNames = getRowNames(fileData.getContent());

        List<Integer> column1 = getColumnWithoutHeader(fileData.getContent(), header.indexOf(col1));
        List<Integer> column2 = getColumnWithoutHeader(fileData.getContent(), header.indexOf(col2));

        List<Integer> difference = subtractColumns(column1, column2);


        int minIndex = difference.indexOf(Collections.min(difference));
        return rowNames.get(minIndex);
    }

    /**
     * Returns a specified column from a table
     * @param table
     * @param col
     * @return
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
     * @param table
     * @return
     */
    public List<String> getRowNames(List<List<String>> table) {
        List<String> column = new ArrayList<>();
        for (int i =1; i < table.size(); i++ ) {
            column.add(table.get(i).get(0));
        }
        return column;
    }

    /**
     * Elementwise subtraction of to Interger Lists
     * @param column1
     * @param column2
     * @return
     */
    public List<Integer> subtractColumns(List<Integer> column1, List<Integer> column2) {
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < column1.size(); i++) {
            result.add(column1.get(i) - column2.get(i));
        }
        return result;

    }
}
