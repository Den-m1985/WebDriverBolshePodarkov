package org.example.searchAndAdd.checkGood;

import org.example.TextLinks;
import org.example.browser.chrome.DriverChrome;
import org.example.browser.chrome.XPathWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckAvailability {


    public boolean checkGoodsPresent() {
        //XPathWait pathWait = new XPathWait();
        WebDriver driver = DriverChrome.getChromeDriver();
        String noFind = TextLinks.NOGOODS.getString();
        try {
             driver.findElement(By.className(noFind));
            //pathWait.xPathClassName(noFind);
             return true;
        } catch (Exception e) {
            return false;
        }
    }


    public boolean isPresentButtonToCart(){
        WebDriver driver = DriverChrome.getChromeDriver();
        //String subscribeString = TextLinks.SUBSCRIBE.getString();
        String toBasketString = TextLinks.TOBASKET.getString();
        try {
            driver.findElement(By.xpath(toBasketString));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
