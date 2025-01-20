package org.example.services.txt;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteTxt {

    // создаем файл с данными по умолчанию
    public WriteTxt(String path) {
        String result = "=;=;=";
        fileWriter(path, result);
    }


    // перезапысываем файл данными авторизации
    public WriteTxt(String path, String login, String password, String secretKey) {
        String str = new ReadTxtFile().readTxtFile(path);
        String[] div = str.split(System.lineSeparator());
        String data = login + ";" + password + ";" + secretKey;
        String result = data + System.lineSeparator() + div[1];
        fileWriter(path, result);
    }


    private void fileWriter(String filePath, String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
