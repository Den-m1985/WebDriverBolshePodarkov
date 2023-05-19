package org.example.searchAndAdd;

import org.example.browser.chrome.DriverChromeSingleton;
import org.example.csvRead.csv.StructureCSV;
import org.example.searchAndAdd.addGood.AddGood;
import org.example.searchAndAdd.checkGood.CheckPrice;
import org.example.searchAndAdd.checkGood.GetPrice;
import org.example.searchAndAdd.search.ClickInSearch;
import org.example.searchAndAdd.search.SearchGoods;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class SearchAndAdd {
    private List<String[]> errorSearch;


    public SearchAndAdd(List<StructureCSV> data) {
        WebDriver driver = DriverChromeSingleton.getChromeDriver();
        errorSearch = new ArrayList<>();

        for (StructureCSV goods : data) {
            String goodsName = goods.getName();
            String goodsSize = goods.getArtucul();
            int intGoodsPrice = goods.getPrice();
            String goodsItem = String.valueOf(goods.getItem());

            System.out.println("goodsItem--" + goodsItem);

            try {

                new SearchGoods(goodsSize);

                // Если товара нет в наличии
//                boolean availability = new CheckAvailability().CheckSubScribe();
//                System.out.println(availability);
//                if (availability) {
//                    String[] noAdd = {goodsName, "Товара нет в наличии"};
//                    errorSearch.add(noAdd);
//                    break;
//                }

                //new ClickInSearch();

                String getPrice = new GetPrice().getPrice();
                System.out.println("Цена в прайсе--" + intGoodsPrice + "--Цена на сайте" + getPrice);

                CheckPrice check = new CheckPrice();
                boolean bool = check.checkPrice(intGoodsPrice, getPrice);
                if (bool) {
                    new AddGood(goodsItem);
                } else errorSearch.add(check.getErrorPrice(goodsName));




            } catch (Exception e) {
                String[] noAdd = {goodsName, "Какая-то общая ошибка"};
                errorSearch.add(noAdd);
            }
        }

    }


    public List<String[]> getErrorSearch() {
        return errorSearch;
    }
}
