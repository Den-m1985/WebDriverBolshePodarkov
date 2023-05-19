package org.example.searchAndAdd.checkGood;

import org.example.TextLinks;
import org.example.browser.chrome.XPathWait;
import org.openqa.selenium.WebElement;

public class GetPrice {

    public String getPrice() {
        XPathWait pathWait = new XPathWait();
        //WebDriver driver = DriverChromeSingleton.getChromeDriver();

        TextLinks LinksSearch = TextLinks.PRICE;
        WebElement price = pathWait.xPathClassName(LinksSearch.getString());
        String str = price.getText();
        String[] strArray = str.split(" ");

        return strArray[0].trim();
    }
}
