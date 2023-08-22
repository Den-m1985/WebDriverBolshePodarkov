package org.example.browser;

import org.example.TextLinks;
import org.example.browser.chrome.DriverChrome;
import org.example.browser.chrome.XPathWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class IsEnterAccount {

    public boolean isEnterAccount() {
        XPathWait pathWait = new XPathWait();
        //WebDriver driver = DriverChrome.getChromeDriver();
        String outBasket = TextLinks.OUTBASKET.getString();

        pathWait.xPath(outBasket);
        //driver.findElement(By.xpath(outBasket));
        return true;
    }

}
