package org.example.command;

import org.example.browser.chrome.LoginPage;
import org.example.browser.OpenWebSite;
import org.example.csvRead.CsvFilter;
import org.example.csvRead.csv.StructureCSV;
import org.example.searchAndAdd.SearchAndAdd;
import org.example.searchAndAdd.search.NameCity;

import java.util.ArrayList;
import java.util.List;

public class Command {


    public void startProgram(String pathCSV) throws Exception {

        long start = System.nanoTime();

        List<String[]> reportList = new ArrayList<>();

        // Read csv
        int cellPrice = 2;  // Cell with price to order
        int cellItem = 3;   // Cell with item to order
        CsvFilter csvFilter = new CsvFilter(pathCSV);
        List<StructureCSV> data = csvFilter.csvFilter(cellPrice, cellItem);
        if (csvFilter.getError() != null)
            reportList.addAll(csvFilter.getError());

        new OpenWebSite();

        new LoginPage();

        new NameCity();

        SearchAndAdd searchAndAdd = new SearchAndAdd(data);
        if (searchAndAdd.getErrorSearch() != null)
            reportList.addAll(searchAndAdd.getErrorSearch());

        System.out.println(reportList.size() + "   Размер отчета");

        //new WrightOldExelArticul(reportList);

        long end = System.nanoTime();
        long a = end - start;
        long time = a / 1000000000;

        finish(time);
    }


    static void finish(long time) {
        System.out.println();
        System.out.println("_________У С П Е Ш Н О________");
        System.out.println();
        System.out.println("Время выполнения: " + time / 60 + "мин " + time % 60 + "сек");
        System.out.println("_________Оля молодец_________");
        System.out.println();
        System.out.println("_________Попей чайку_________");
        System.out.println();
    }


}
