package org.example.txt;

import org.example.TextLinks;
import org.example.createPathFile.CreatePathFile;
import org.example.createPathFile.Date;


public class WriteTxtReport {

    public WriteTxtReport(String data) {

        // создаем имя файла
        CreatePathFile createPathFile = new CreatePathFile();
        String fileName = TextLinks.FILENAMESAVE.getString();
        String downloadsPath = createPathFile.createPathFile(fileName, "txt");

        Date date = new Date();
        String time = date.currentDate();

        new WriteTxtReportFile(downloadsPath, time, data);
    }

}
