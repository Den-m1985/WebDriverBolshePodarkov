package org.example.browser.chrome;

import org.example.browser.chrome.WaitChrome;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class XPathWait extends WaitChrome {


    public WebElement xPath(String str){
        WebDriverWait wait = WaitChrome.getChromeDriverWait();
        return wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(str)));
    }
}
