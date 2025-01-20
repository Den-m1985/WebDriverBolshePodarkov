package org.example.services.searchAndAdd.checkGood;

import org.example.enums.TextLinks;
import org.example.services.browser.chrome.XPathWait;
import org.openqa.selenium.WebElement;

public class GetPrice {

    public String getPriceFromWeb() {
        XPathWait pathWait = new XPathWait();
        //WebDriver driver = DriverChrome.getChromeDriver();

        String LinksSearch = TextLinks.PRICE.getString();
        WebElement price = pathWait.xPathClassName(LinksSearch);
        String str = price.getText();

        /*
        ["49", "руб.", "Старая", "цена
        29", "руб.", "Оптовая"]
         */
        String[] strArray = str.split(" ");

        return strArray[0].trim();
    }
}
