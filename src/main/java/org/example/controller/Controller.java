package org.example.controller;

import org.example.browser.chrome.DriverChrome;
import org.example.browser.LoginPage;
import org.example.browser.OpenWebSite;
import org.example.csvRead.CsvFilter;
import org.example.csvRead.csv.StructureCSV;
import org.example.oldExel.WrightOldExelArticular;
import org.example.searchAndAdd.Basket;
import org.example.searchAndAdd.SearchAndAdd;
import org.example.searchAndAdd.search.NameCity;

import java.util.ArrayList;
import java.util.List;

public class Controller {


    public Controller(String pathCSV) throws Exception {
        long start = System.nanoTime();

        List<String[]> reportList = new ArrayList<>();

        // Read csv
        CsvFilter csvFilter = new CsvFilter();
        List<StructureCSV> data = csvFilter.csvFilter(pathCSV);
        if (csvFilter.getError() != null)
            reportList.addAll(csvFilter.getError());

        new OpenWebSite();

        new LoginPage();

        new NameCity();

        new Basket();

        SearchAndAdd searchAndAdd = new SearchAndAdd(data);
        if (searchAndAdd.getErrorSearch() != null)
            reportList.addAll(searchAndAdd.getErrorSearch());

        System.out.println();
        System.out.println("Размер отчета: " + reportList.size());

        if (reportList.size() != 0)
            new WrightOldExelArticular(reportList);

        long end = System.nanoTime();
        long time = (end - start) / 1000000000;

        finish(time);

        DriverChrome.getChromeDriver().close();

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

}
