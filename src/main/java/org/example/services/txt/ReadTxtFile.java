package org.example.services.txt;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReadTxtFile {

    public String readTxtFile(String filePath) {
        StringBuilder csvString = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                csvString.append(line).append(System.lineSeparator());
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
           new WriteTxt(filePath);
            return "=;=;=" + System.lineSeparator() + csvString;
        }
        return csvString.toString();
    }
}
