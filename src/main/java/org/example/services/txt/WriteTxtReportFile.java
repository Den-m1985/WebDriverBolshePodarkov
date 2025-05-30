package org.example.services.txt;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteTxtReportFile {

    public WriteTxtReportFile(String downloadsPath, String time, String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(downloadsPath))) {
            writer.write(data);
            writer.write("*******************" + time + "*************************");
            writer.write(data);
        } catch (IOException e) {
            System.out.println("Ошибка при записи данных в файл.");
            System.out.println(e.getMessage());
        }
    }
}
