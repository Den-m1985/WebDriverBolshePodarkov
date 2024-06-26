package org.example.searchAndAdd.addToBasket;

import org.example.TextLinks;
import org.example.browser.chrome.DriverChrome;
import org.example.csvRead.csv.StructureCSV;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AddGood {

    public AddGood(StructureCSV product) {
        WebDriver driver = DriverChrome.getChromeDriver();

        String linkString = TextLinks.ADDITEM.getString();
        WebElement elementLocator = driver.findElement(By.className(linkString));

        Actions actions = new Actions(driver);
        actions.doubleClick(elementLocator).perform();
        String goodsItem = String.valueOf(product.getItem());
        elementLocator.sendKeys(goodsItem);

        String linkAddItem = TextLinks.TOBASKET.getString();
        WebElement linkButton = driver.findElement(By.className(linkAddItem));
        linkButton.click();
    }

}
