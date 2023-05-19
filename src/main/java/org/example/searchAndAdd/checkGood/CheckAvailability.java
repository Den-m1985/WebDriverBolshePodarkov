package org.example.searchAndAdd.checkGood;

import org.example.TextLinks;
import org.example.browser.chrome.DriverChromeSingleton;
import org.example.browser.chrome.XPathWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckAvailability {



    public boolean CheckSubScribe() {
        XPathWait pathWait = new XPathWait();
        WebDriver driver = DriverChromeSingleton.getChromeDriver();

        TextLinks LinksSearch = TextLinks.SUBSCRIBE;
        //WebElement search = driver.findElement(By.className(LinksSearch.getString()));
        WebElement subScribe = pathWait.xPathClassName(LinksSearch.getString());
        System.out.println(subScribe.getText());
//        if (subScribe.isDisplayed()) {
//            System.out.println("Подписаться на товар");
//            return true;
//        }
        return false;
    }
}
