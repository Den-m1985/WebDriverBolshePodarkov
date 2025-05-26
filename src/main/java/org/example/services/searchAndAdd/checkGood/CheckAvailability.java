package org.example.services.searchAndAdd.checkGood;

import org.example.enums.TextLinks;
import org.example.services.browser.chrome.WaitChrome;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckAvailability {

    public boolean isPresentButtonToCart() {
        WebDriverWait waitChrome = WaitChrome.getChromeDriverWait();

        String toBasketString = TextLinks.TO_BASKET.getString();
        try {
            WebElement button = waitChrome.until(
                    ExpectedConditions.elementToBeClickable(By.className(toBasketString))
            );
            String str = button.getText();
            String subscribe = TextLinks.SUBSCRIBE.getString();
            return !str.equals(subscribe);
        } catch (Exception e) {
            return false;
        }
    }
}
