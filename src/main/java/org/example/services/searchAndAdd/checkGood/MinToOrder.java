package org.example.services.searchAndAdd.checkGood;

import org.example.enums.TextLinks;
import org.example.services.browser.chrome.DriverChrome;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MinToOrder {

    public boolean checkMinItem(int csvItem) {
        WebDriver driver = DriverChrome.getChromeDriver();
        try {
            String linkString = TextLinks.MIN_ITEM.getString();
            WebElement minItem = driver.findElement(By.className(linkString));
            String fieldValueText = minItem.getAttribute("value");  // Получение значения поля
            int result = Integer.parseInt(fieldValueText);
            if (result <= csvItem) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }
}
