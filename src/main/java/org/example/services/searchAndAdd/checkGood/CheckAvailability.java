package org.example.services.searchAndAdd.checkGood;

import org.example.enums.TextLinks;
import org.example.services.browser.chrome.DriverChrome;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckAvailability {

    public boolean isPresentButtonToCart() {
        WebDriver driver = DriverChrome.getChromeDriver();
        String toBasketString = TextLinks.TO_BASKET.getString();
        try {
            WebElement button = driver.findElement(By.className(toBasketString));
            String str = button.getText();
            String subscribe = TextLinks.SUBSCRIBE.getString();
            return !str.equals(subscribe);
        } catch (Exception e) {
            return false;
        }
    }
}
