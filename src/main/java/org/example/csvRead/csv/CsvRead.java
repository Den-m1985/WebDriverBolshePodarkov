package org.example.csvRead.csv;

import java.io.*;
import java.nio.charset.Charset;
import java.util.*;


public class CsvRead {


//    public List<String[]> readCSV(String fileName) throws IOException, CsvException {
//        Reader reader = new InputStreamReader(new FileInputStream(fileName), "windows-1251");
//        CSVParser parser = new CSVParserBuilder().withSeparator(';').build(); // separator with ;
//        CSVReader csvReader = new CSVReaderBuilder(reader).withCSVParser(parser).build();
//        List<String[]> rows = csvReader.readAll(); // read all rows in the file
//        reader.close();
//        return rows;
//    }


    public List<String[]> readCSV2(String fileName, String encoding) {

        List<String[]> rows = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(fileName), Charset.forName(encoding)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] divideStr = line.split(";");
                for (int i = 0; i < divideStr.length; i++) {
                    divideStr[i] = deleteQuotes(divideStr[i]);
                }
                rows.add(divideStr);
            }
        } catch (Exception e) {
            System.out.println("File not found");
        }
        return rows;
    }


    // delete double quotes if it's presents in the starts end in the end
    private String deleteQuotes(String str) {
//        if (str.startsWith("\"") && str.endsWith("\"")) {
//            str = str.substring(1, str.length() - 1);
//        }
//        return str;
        return str.replace("\"\"", "\"");
    }

}
