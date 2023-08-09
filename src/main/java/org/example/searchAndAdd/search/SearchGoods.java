package org.example.searchAndAdd.search;

import org.example.TextLinks;
import org.example.browser.chrome.DriverChrome;
import org.example.browser.chrome.XPathWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchGoods {


    public SearchGoods(String goodsSize) {
        XPathWait pathWait = new XPathWait();
        //WebDriver driver = DriverChrome.getChromeDriver();

        String LinksSearch = TextLinks.SEARCHFIELD.getString();
        WebElement search = pathWait.xPathClassName(LinksSearch);
        //WebElement search = driver.findElement(By.className(LinksSearch));
        search.click();
        search.sendKeys(goodsSize);

        String linkButtonSearch = TextLinks.BUTTONSEARCH.getString();
        WebElement buttonSearch = pathWait.xPathClassName(linkButtonSearch);
        //WebElement buttonSearch = driver.findElement(By.className(linkButtonSearch));
        buttonSearch.click();

    }

}
