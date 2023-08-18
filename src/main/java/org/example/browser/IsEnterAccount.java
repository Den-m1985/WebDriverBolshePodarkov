package org.example.browser;

import org.example.TextLinks;
import org.example.browser.chrome.DriverChrome;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class IsEnterAccount {

    public boolean isEnterAccount() {
        WebDriver driver = DriverChrome.getChromeDriver();
        String outBasket = TextLinks.OUTBASKET.getString();
        driver.findElement(By.xpath(outBasket));
        return true;
    }

}
