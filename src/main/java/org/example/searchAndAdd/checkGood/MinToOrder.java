package org.example.searchAndAdd.checkGood;

import org.example.TextLinks;
import org.example.browser.chrome.DriverChrome;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MinToOrder {


    public boolean checkMinItem(int csvItem) {
        WebDriver driver = DriverChrome.getChromeDriver();
        try {
            String linkString = TextLinks.MINITEM.getString();
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
