package org.example.services.searchAndAdd.addToBasket;

import org.example.enums.TextLinks;
import org.example.services.browser.chrome.DriverChrome;
import org.example.services.csvRead.csv.StructureCSV;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AddGood {

    public AddGood(StructureCSV product) {
        WebDriver driver = DriverChrome.getChromeDriver();

        String linkString = TextLinks.ADD_ITEM.getString();
        WebElement elementLocator = driver.findElement(By.className(linkString));

        Actions actions = new Actions(driver);
        actions.doubleClick(elementLocator).perform();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String goodsItem = String.valueOf(product.getItem());
        elementLocator.sendKeys(goodsItem);

        String linkAddItem = TextLinks.TO_BASKET.getString();
        WebElement linkButton = driver.findElement(By.className(linkAddItem));
        linkButton.click();
    }
}
