package org.example.txt;

import org.example.txt.WriteTxt;

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
           new WriteTxt(filePath);
            csvString.append("Название=" + "A" + "_"
                    + "Артикул=" + "B" + "_"
                    + "Цена=" + "C" + "_"
                    + "Количество=" + "D");
            return "=;=;=" + System.lineSeparator() + csvString;
        }
        return csvString.toString();
    }

}
