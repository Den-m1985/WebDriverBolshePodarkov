package org.example.searchAndAdd.search;

import org.example.TextLinks;
import org.example.browser.chrome.DriverChromeSingleton;
import org.example.browser.chrome.XPathWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchGoods {


    public SearchGoods(String goodsSize) {
        XPathWait pathWait = new XPathWait();
        WebDriver driver = DriverChromeSingleton.getChromeDriver();

        TextLinks LinksSearch = TextLinks.SEARCHFIELD;
        //WebElement search = driver.findElement(By.cssSelector(LinksSearch.getString()));
        WebElement search = pathWait.xPathCssSelector(LinksSearch.getString());
        search.click();
        search.sendKeys(goodsSize);

        TextLinks linkButtonSearch = TextLinks.BUTTONSEARCH;
        //WebElement buttonSearch = driver.findElement(By.cssSelector(linkButtonSearch.getString()));
        WebElement buttonSearch = pathWait.xPathCssSelector(linkButtonSearch.getString());
        buttonSearch.click();

    }


}
