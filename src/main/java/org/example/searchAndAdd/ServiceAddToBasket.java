package org.example.searchAndAdd;

import org.example.DTO.DtoError;
import org.example.csvRead.csv.StructureCSV;
import org.example.searchAndAdd.addToBasket.AddGood;
import org.example.searchAndAdd.checkGood.CheckAvailability;
import org.example.searchAndAdd.checkGood.CheckPrice;
import org.example.searchAndAdd.checkGood.CountProduct;
import org.example.searchAndAdd.checkGood.GetPrice;
import org.example.searchAndAdd.search.SearchGoods;

import java.util.ArrayList;
import java.util.List;

public class ServiceAddToBasket {
    private final List<String[]> errorSearch;
    private List<DtoError> errorMessages;


    public ServiceAddToBasket(List<StructureCSV> data) {
        errorSearch = new ArrayList<>();
        errorMessages = new ArrayList<>();
        for (StructureCSV product : data) {

            new SearchGoods(product.getArtucul());

            int countProduct = new CountProduct().countProduct();
            switch (countProduct) {
                case 0 -> errorMessages.add(new DtoError("Неправильный артикул или имя", product));
                case 1 -> executeToBuy(product);
                default -> {
                    if (countProduct > 2) {
                        errorMessages.add(new DtoError("Товаров больше чем 1", product));
                    }
                }
            }

            //executeWebProcess(product);
        }
    }


    private void executeToBuy(StructureCSV product) {
        int csvPrice = product.getPrice();
        int csvItem = product.getItem();
        boolean isButtonToBuyPresent = new CheckAvailability().isPresentButtonToCart();
        if (isButtonToBuyPresent) {
            String priceFromWeb = new GetPrice().getPriceFromWeb();
            CheckPrice check = new CheckPrice();
            boolean boolPrice = check.checkPrice(csvPrice, priceFromWeb);
            if (boolPrice) {
                // If all is well, then add the product to the cart
                new AddGood(String.valueOf(csvItem));
            } else {
                errorMessages.add(check.getErrorPrice(product));
            }
        } else {
            errorMessages.add(new DtoError("Товара нет в наличии", product));
        }
    }


    private void executeWebProcess(StructureCSV goods) {
        String csvName = goods.getName();
        String csvArticular = goods.getArtucul();
        int csvPrice = goods.getPrice();
        int csvItem = goods.getItem();

        try {
            // Если товара нет в наличии
            boolean availability = new CheckAvailability().checkGoodsPresent();
            boolean subscribe = false;
            if (availability) {
                subscribe = new CheckAvailability().isPresentButtonToCart();
            }
            if (availability && subscribe) {
                String getPrice = new GetPrice().getPriceFromWeb();
                // проверяем минимальное кол-во для заказа
                //boolean checkMinItem = new MinToOrder().checkMinItem(csvItem);
                boolean checkMinItem = true;
                if (checkMinItem) {
                    CheckPrice check = new CheckPrice();
                    // check the price between web and csv
                    boolean boolPrice = check.checkPrice(csvPrice, getPrice);
//                    if (boolPrice) {
//                        // If all is well, then add the product to the cart
//                        new AddGood(String.valueOf(csvItem));
//                    } else errorSearch.add(check.getErrorPrice(csvName, csvArticular));
                } else {
                    String[] noAdd = {csvName, csvArticular, "Меньше чем минимальное кол-во на сайте"};
                    errorSearch.add(noAdd);
                }
            } else {
                String[] noAdd = {csvName, csvArticular, "Товара нет в наличии"};
                errorSearch.add(noAdd);
            }
        } catch (Exception e) {
            String[] noAdd = {csvName, csvArticular, "Общая ошибка"};
            errorSearch.add(noAdd);
        }
    }


    public List<String[]> getErrorSearch() {
        return errorSearch;
    }

}
