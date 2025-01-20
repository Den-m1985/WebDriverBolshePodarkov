package org.example.services.searchAndAdd.checkGood;

import org.example.DTO.DtoError;
import org.example.services.csvRead.csv.StructureCSV;

public class CheckPrice {
    int percent;

    public boolean checkPrice(int csvPrice, String webPrice) {
        int intWebPrice = floatToInt(webPrice);
        percent = (intWebPrice * 100) / csvPrice;
        return percent < 101;
    }

    public DtoError getErrorPrice(StructureCSV product) {
        return new DtoError(product.getName(), product.getArticular(), "Цена на сайте больше на " + percent + "%");
    }

    private int floatToInt(String str) {
        if (str.contains(",")) {
            String str2 = str.replace(",", ".");
            return (int) Float.parseFloat(str2);
        }
        return (int) Float.parseFloat(str);
    }
}
