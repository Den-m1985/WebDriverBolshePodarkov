package org.example.txt;

import org.example.TextLinks;
import org.example.txt.writeTxt.ReadTxtFile;

import java.io.File;
import java.util.LinkedHashMap;

public class GetNameFieldCSV {

    public LinkedHashMap<String, Integer> getNameFieldCSV() {
        String linksLoginFile = TextLinks.AUTHORIZATION.getString();
        String filePath = System.getProperty("user.home") + File.separator + linksLoginFile;
        String str = new ReadTxtFile().readTxtFile(filePath);
        String[] div = str.split(System.lineSeparator());
        String[] divStr = div[1].split("_");
        LinkedHashMap<String, Integer> cellCSV = new LinkedHashMap<>();
        for (String topic : divStr) {
            String[] divTopic = topic.split("=");
            switch (divTopic[1]) {
                case "A" -> cellCSV.put(divTopic[0], 0);
                case "B" -> cellCSV.put(divTopic[0], 1);
                case "C" -> cellCSV.put(divTopic[0], 2);
                case "D" -> cellCSV.put(divTopic[0], 3);
            }
        }
        return cellCSV;
    }

}
