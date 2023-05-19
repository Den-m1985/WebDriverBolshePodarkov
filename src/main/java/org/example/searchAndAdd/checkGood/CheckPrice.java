package org.example.searchAndAdd.checkGood;

import org.example.TextLinks;
import org.example.browser.chrome.XPathWait;
import org.openqa.selenium.WebElement;

public class CheckPrice {
    int procent;

    public CheckPrice() {
    }

    public boolean checkPrice(int intGoodsPrice, String priceWeb) {

        int intPriceWeb = Integer.parseInt(priceWeb);

        procent = (intPriceWeb * 100) / intGoodsPrice;
        System.out.println("procent--" + procent);
        if (procent < 101) {
            return true;
        }
        return false;
    }


    public String[] getErrorPrice(String goodsName) {
        return new String[]{goodsName, "цена на сайте больше на " + procent + "%"};
    }
}
