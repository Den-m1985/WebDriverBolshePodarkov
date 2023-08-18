package org.example.txt.writeTxt;

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
            throw new RuntimeException(e);
        }
    }

}
