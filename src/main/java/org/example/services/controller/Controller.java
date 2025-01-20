package org.example.services.controller;

import org.example.DTO.DtoError;
import org.example.services.browser.chrome.DriverChrome;
import org.example.services.browser.LoginPage;
import org.example.services.browser.OpenWebSite;
import org.example.services.csvRead.CsvFilter;
import org.example.services.csvRead.csv.StructureCSV;
import org.example.services.newExel.CreateReportExel;
import org.example.services.searchAndAdd.addToBasket.Basket;
import org.example.services.searchAndAdd.ServiceAddToBasket;

import java.util.List;

public class Controller {

    public Controller(String pathCSV) throws Exception {
        CsvFilter csvFilter = new CsvFilter();
        List<StructureCSV> data = csvFilter.csvFilter(pathCSV);
        List<DtoError> reportList = csvFilter.getError();

        new OpenWebSite();

        new LoginPage();

        new Basket();

        ServiceAddToBasket searchAndAdd = new ServiceAddToBasket(data);
        reportList.addAll(searchAndAdd.getErrorSearch());

        printText(reportList.size());

        if (reportList.size() != 0)
            new CreateReportExel(reportList);

        /*
       Используем метод `quit()` вместо `close()`,
       чтобы гарантировать полное закрытие драйвера и освобождение всех связанных с ним ресурсов
         */
        DriverChrome.getChromeDriver().quit();
    }

    private void printText(int size){
        System.out.println();
        System.out.println("Размер отчета: " + size);
    }
}
