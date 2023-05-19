package org.example.searchAndAdd.search;

import org.example.TextLinks;
import org.example.browser.chrome.DriverChromeSingleton;
import org.example.browser.chrome.XPathWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClickInSearch {

    public ClickInSearch() {
        XPathWait pathWait = new XPathWait();
        WebDriver driver = DriverChromeSingleton.getChromeDriver();

        TextLinks LinksSearch = TextLinks.CLICKINSEARCH;
        //WebElement search = driver.findElement(By.className(LinksSearch.getString()));
        WebElement search = pathWait.xPathClassName(LinksSearch.getString());
        search.click();

    }
}
