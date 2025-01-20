package org.example.services;

import org.example.enums.TextLinks;
import org.example.services.controller.Controller;
import org.example.services.createPathFile.GetPathFile;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartCommand implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        GetPathFile getPathFile = new GetPathFile();
        String pathFile = getPathFile.getPathFile(TextLinks.CSV.getString());
        if (pathFile != null) {
            printText(pathFile);
        } else {
            System.err.println(TextLinks.TEXT_FILE_OPEN_ERROR.getString());
            return;
        }
        startController(pathFile);
    }


    private void startController(String pathFile){
        try {
            long start = System.nanoTime();
            new Controller(pathFile);
            long end = System.nanoTime();
            long time = (end - start) / 1000000000;
            finish(time);
        } catch (Exception ex) {
            System.out.println();
            System.out.println("_________О Ш И Б К А________");
            System.err.println(ex.getMessage());
        }
    }

    private void finish(long time) {
        System.out.println();
        System.out.println("_________У С П Е Ш Н О________");
        System.out.println();
        System.out.println("Время выполнения: " + time / 60 + "мин " + time % 60 + "сек");
        System.out.println();
        System.out.println("_________Оля молодец_________");
        System.out.println();
        System.out.println("_________Попей чайку_________");
        System.out.println();
    }

    private void printText(String pathCSV) {
        System.out.println();
        System.out.println(TextLinks.TEXT_FILE_OPEN.getString());
        System.out.println(pathCSV);
    }
}
