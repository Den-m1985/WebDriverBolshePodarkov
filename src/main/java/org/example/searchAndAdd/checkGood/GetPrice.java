package org.example.searchAndAdd.checkGood;

import org.example.TextLinks;
import org.example.browser.chrome.XPathWait;
import org.openqa.selenium.WebElement;

public class GetPrice {

    public String getPriceFromWeb() {
        XPathWait pathWait = new XPathWait();
        //WebDriver driver = DriverChrome.getChromeDriver();

        String LinksSearch = TextLinks.PRICE.getString();
        WebElement price = pathWait.xPathClassName(LinksSearch);
        String str = price.getText();
        String[] strArray = str.split(" ");

        return strArray[0].trim();
    }

}
