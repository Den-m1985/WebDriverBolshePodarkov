package org.example.searchAndAdd;

import org.example.browser.chrome.DriverChromeSingleton;
import org.example.csvRead.csv.StructureCSV;
import org.example.searchAndAdd.search.SearchGoods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
            int goodsItem = goods.getItem();

            try {

                new SearchGoods(goodsName);


                // находим несколько имен в поисковике
                //List<WebElement> products = driver.findElements(By.className("products"));

                // проверяем на наличие товара
                //List<WebElement> product = driver.findElements(By.className("product"));

                // проверяем на ниличие выбора размера
                //List<WebElement> size = driver.findElements(By.className("b1c_option"));


//        if (products.size() > 0) {
//
//                CheckPrice check = new CheckPrice(driver, intGoodsPrice);
//                if (check.checkPrice()) {
//                    addGoods.addGoods(goodsItem, driver);  // товар найден, добавляем в корзину
//                    new ClowdWindow(driver);
//                } else reportList.add(check.getErrorPrice(goodsName));
//            }
//         else {
//            String[] noFind = {goodsName, "товар НЕ найден"};
//            reportList.add(noFind);
//        }




            } catch (Exception e) {
                //System.out.println("Произошла ошибка: " + e.getMessage());
                String[] noAdd = {goodsName, "Какая-то общая ошибка"};
                errorSearch.add(noAdd);
            }
        }

    }


    public List<String[]> getErrorSearch() {
        return errorSearch;
    }
}
