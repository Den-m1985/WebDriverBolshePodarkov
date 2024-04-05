package org.example.controller;

import org.example.DTO.DtoError;
import org.example.browser.chrome.DriverChrome;
import org.example.browser.LoginPage;
import org.example.browser.OpenWebSite;
import org.example.csvRead.CsvFilter;
import org.example.csvRead.csv.StructureCSV;
import org.example.newExel.CreateReportExel;
import org.example.searchAndAdd.addToBasket.Basket;
import org.example.searchAndAdd.ServiceAddToBasket;

import java.util.ArrayList;
import java.util.List;

public class Controller {


    public Controller(String pathCSV) throws Exception {
        long start = System.nanoTime();

        CsvFilter csvFilter = new CsvFilter();
        List<StructureCSV> data = csvFilter.csvFilter(pathCSV);
        List<DtoError> reportList = new ArrayList<>(csvFilter.getError());

        new OpenWebSite();

        new LoginPage();

        new Basket();

        ServiceAddToBasket searchAndAdd = new ServiceAddToBasket(data);
        reportList.addAll(searchAndAdd.getErrorSearch());

        System.out.println();
        System.out.println("Размер отчета: " + reportList.size());

        if (reportList.size() != 0)
            new CreateReportExel(reportList);

        long end = System.nanoTime();
        long time = (end - start) / 1000000000;

        finish(time);

        /*
       Используем метод `quit()` вместо `close()`,
       чтобы гарантировать полное закрытие драйвера и освобождение всех связанных с ним ресурсов
         */
        DriverChrome.getChromeDriver().quit();
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
