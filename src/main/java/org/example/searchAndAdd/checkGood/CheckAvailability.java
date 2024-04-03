package org.example.searchAndAdd.checkGood;

import org.example.TextLinks;
import org.example.browser.chrome.DriverChrome;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckAvailability {


    public boolean checkGoodsPresent() {
        WebDriver driver = DriverChrome.getChromeDriver();
        String noFind = TextLinks.NOGOODS.getString();
        try {
            List<WebElement> goodsArray = driver.findElements(By.xpath(noFind));
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
            driver.findElement(By.className(toBasketString)).isEnabled();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
