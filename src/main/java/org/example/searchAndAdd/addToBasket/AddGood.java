package org.example.searchAndAdd.addToBasket;

import org.example.TextLinks;
import org.example.browser.chrome.DriverChrome;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AddGood {

    public AddGood(String goodsItem) {
        WebDriver driver = DriverChrome.getChromeDriver();

        String linkString = TextLinks.ADDITEM.getString();
        WebElement elementLocator = driver.findElement(By.className(linkString));

        Actions actions = new Actions(driver);
        actions.doubleClick(elementLocator).perform();
        elementLocator.sendKeys(goodsItem);

        String linkAddItem = TextLinks.CLICKBAY.getString();
        WebElement linkButton = driver.findElement(By.xpath(linkAddItem));
        linkButton.click();

    }

}
