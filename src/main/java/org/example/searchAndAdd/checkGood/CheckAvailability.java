package org.example.searchAndAdd.checkGood;

import org.example.TextLinks;
import org.example.browser.chrome.DriverChrome;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckAvailability {


    public boolean checkGoodsPresent() {
        WebDriver driver = DriverChrome.getChromeDriver();
        String noFind = TextLinks.NOGOODS.getString();
        try {
            driver.findElement(By.className(noFind));
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public boolean isPresentButtonToCart() {
        WebDriver driver = DriverChrome.getChromeDriver();
        String toBasketString = TextLinks.TOBASKET.getString();
        try {
            driver.findElement(By.xpath(toBasketString));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
