package org.example.services.csvRead.csv;

import org.example.enums.TextLinks;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class CsvRead {

    public List<String[]> readCSV2(String fileName) {

        List<String[]> rows = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(fileName), Charset.forName(TextLinks.ENCODING.getString())))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] divideStr = line.split(";");
                for (int i = 0; i < divideStr.length; i++) {
                    divideStr[i] = deleteQuotes(divideStr[i]);
                }
                rows.add(divideStr);
            }
        } catch (Exception e) {
            System.err.println("File not found");
        }
        return rows;
    }


    // delete double quotes if it's presents in the starts end in the end
    private String deleteQuotes(String str) {
        return str.replace("\"\"", "\"");
    }
}
