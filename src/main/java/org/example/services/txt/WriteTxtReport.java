package org.example.services.txt;

import org.example.enums.TextLinks;
import org.example.services.createPathFile.CreatePathFile;
import org.example.services.createPathFile.Date;

public class WriteTxtReport {

    public WriteTxtReport(String data) {
        String downloadsPath = new CreatePathFile().createPathFile(
                TextLinks.FILE_NAME_SAVE.getString(),
                TextLinks.TXT.getString());

        String time = new Date().currentDate();

        new WriteTxtReportFile(downloadsPath, time, data);
    }
}
