package org.example.searchAndAdd;

import org.example.csvRead.csv.StructureCSV;
import org.example.searchAndAdd.addGood.AddGood;
import org.example.searchAndAdd.checkGood.CheckAvailability;
import org.example.searchAndAdd.checkGood.CheckPrice;
import org.example.searchAndAdd.checkGood.GetPrice;
import org.example.searchAndAdd.checkGood.MinToOrder;
import org.example.searchAndAdd.search.SearchGoods;

import java.util.ArrayList;
import java.util.List;

public class SearchAndAdd {
    private final List<String[]> errorSearch;


    public SearchAndAdd(List<StructureCSV> data) {
        errorSearch = new ArrayList<>();
        for (StructureCSV product : data) {
            new SearchGoods(product.getArtucul());
            executeWebProcess(product);
        }
    }


    private void executeWebProcess(StructureCSV goods) {
        String csvName = goods.getName();
        String csvArticular = goods.getArtucul();
        int csvPrice = goods.getPrice();
        int csvItem = goods.getItem();

        try {
            //new SearchGoods(csvArticular);

            // Если товара нет в наличии
            boolean availability = new CheckAvailability().checkGoodsPresent();
            boolean subscribe = false;
            if (availability){
                //subscribe = new MinToOrder().checkMinItemPresent();
                subscribe = new CheckAvailability().isPresentButtonToCart();
            }

            if (availability && subscribe) {
                String getPrice = new GetPrice().getPrice();
                // проверяем минимальное кол-во для заказа
                boolean checkMinItem = new MinToOrder().checkMinItem(csvItem);
                if (checkMinItem) {
                    CheckPrice check = new CheckPrice();
                    // check the price between web and csv
                    boolean boolPrice = check.checkPrice(csvPrice, getPrice);
                    if (boolPrice) {
                        // If all is well, then add the product to the cart
                        new AddGood(String.valueOf(csvItem));
                    } else errorSearch.add(check.getErrorPrice(csvName, csvArticular));
                } else {
                    String[] noAdd = {csvName, csvArticular, "Меньше чем минимальное кол-во на сайте"};
                    errorSearch.add(noAdd);
                }
            } else {
                String[] noAdd = {csvName,csvArticular, "Товара нет в наличии"};
                errorSearch.add(noAdd);
            }
        } catch (Exception e) {
            String[] noAdd = {csvName,csvArticular, "Общая ошибка"};
            errorSearch.add(noAdd);
        }
    }


    public List<String[]> getErrorSearch() {
        return errorSearch;
    }

}
