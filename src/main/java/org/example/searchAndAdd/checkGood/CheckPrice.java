package org.example.searchAndAdd.checkGood;

public class CheckPrice {
    int percent;

    public CheckPrice() {
    }

    public boolean checkPrice(int csvPrice, String webPrice) {

        int intWebPrice = Integer.parseInt(webPrice);

        percent = (intWebPrice * 100) / csvPrice;
        if (percent < 101) {
            return true;
        }
        return false;
    }


    public String[] getErrorPrice(String goodsName,  String csvArticular) {
        return new String[]{goodsName, csvArticular, "цена на сайте больше на " + percent + "%"};
    }

}
