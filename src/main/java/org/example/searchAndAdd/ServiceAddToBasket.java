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
    private List<DtoError> errorMessages;


    public ServiceAddToBasket(List<StructureCSV> data) {
        errorMessages = new ArrayList<>();
        for (StructureCSV product : data) {

            try {
                new SearchGoods(product.getArtucul());

                int countProduct = new CountProduct().countProduct();
                switch (countProduct) {
                    case 0 ->
                            errorMessages.add(new DtoError(product.getName(), product.getArtucul(),
                                    "Неправильный артикул или имя"));
                    case 1 -> executeToBuy(product);
                    default -> {
                        if (countProduct > 2) {
                            errorMessages.add(new DtoError(product.getName(), product.getArtucul(),
                                    "Товаров больше чем 1"));
                        }
                    }
                }
            } catch (Exception e) {
                errorMessages.add(new DtoError(product.getName(), product.getArtucul(),
                        "Общая ошибка"));
            }
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
                new AddGood(product);
            } else {
                errorMessages.add(check.getErrorPrice(product));
            }
        } else {
            errorMessages.add(new DtoError(product.getName(), product.getArtucul(), "Товара нет в наличии"));
        }
    }


    public List<DtoError> getErrorSearch() {
        return errorMessages;
    }

}
