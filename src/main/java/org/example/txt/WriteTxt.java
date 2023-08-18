package org.example.txt;

import org.example.txt.writeTxt.ReadTxtFile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteTxt {


    // перезаписываем файл с данными о полях
    public WriteTxt(String path, String name, String articular, String price, String item) {
        String str = new ReadTxtFile().readTxtFile(path);
        String[] div = str.split(System.lineSeparator());
        String data = "Название=" + name + "_"
                + "Артикул=" + articular + "_"
                + "Цена=" + price + "_"
                + "Количество=" + item;
        String result = div[0] + System.lineSeparator() + data;
        fileWriter(path, result);
    }


    // создаем файл с данными по умолчанию
    public WriteTxt(String path) {
        String data = "Название=" + "A" + "_"
                + "Артикул=" + "B" + "_"
                + "Цена=" + "C" + "_"
                + "Количество=" + "D";
        String result = "=;=;=" + System.lineSeparator() + data;
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
