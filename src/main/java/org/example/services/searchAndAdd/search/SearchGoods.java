package org.example.services.searchAndAdd.search;

import org.example.enums.TextLinks;
import org.example.services.browser.chrome.DriverChrome;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchGoods {

    public SearchGoods(String goodsSize) {
        WebDriver driver = DriverChrome.getChromeDriver();

        String LinksSearch = TextLinks.SEARCH_FIELD.getString();
        WebElement search = driver.findElement(By.className(LinksSearch));
        search.click();
        search.sendKeys(goodsSize);

        String linkButtonSearch = TextLinks.BUTTON_SEARCH.getString();
        WebElement buttonSearch = driver.findElement(By.className(linkButtonSearch));
        buttonSearch.click();

    }
}
