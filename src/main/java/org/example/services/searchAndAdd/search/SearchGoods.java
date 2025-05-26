package org.example.services.searchAndAdd.search;

import org.example.enums.TextLinks;
import org.example.services.browser.chrome.WaitChrome;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchGoods {

    public SearchGoods(String goodsSize) {
        WebDriverWait waitChrome = WaitChrome.getChromeDriverWait();

        String LinksSearch = TextLinks.SEARCH_FIELD.getString();
        WebElement search = waitChrome.until(
                ExpectedConditions.elementToBeClickable(By.className(LinksSearch))
        );
        search.click();
        search.sendKeys(goodsSize);

        String linkButtonSearch = TextLinks.BUTTON_SEARCH.getString();
        WebElement buttonSearch = waitChrome.until(
                ExpectedConditions.elementToBeClickable(By.className(linkButtonSearch))
        );
        buttonSearch.click();

    }
}
