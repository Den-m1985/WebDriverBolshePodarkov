package org.example.services.searchAndAdd.checkGood;

import org.example.enums.TextLinks;
import org.example.services.browser.chrome.DriverChrome;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CountProduct {

    public int countProduct() {
        WebDriver driver = DriverChrome.getChromeDriver();
        String cartField = TextLinks.CART_FIELD.getString();
        try {
            List<WebElement> goodsArray = driver.findElements(By.className(cartField));
            return goodsArray.size();
        } catch (Exception ignored) {
        }
        return 0;
    }
}
