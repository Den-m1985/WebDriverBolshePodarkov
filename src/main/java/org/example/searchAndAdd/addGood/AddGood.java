package org.example.searchAndAdd.addGood;

import org.example.TextLinks;
import org.example.browser.chrome.DriverChromeSingleton;
import org.example.browser.chrome.XPathWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AddGood {

    public AddGood(String goodsItem) {
        XPathWait pathWait = new XPathWait();
        WebDriver driver = DriverChromeSingleton.getChromeDriver();

        String linkString = TextLinks.ADDITEM.getString();
        WebElement elementLocator = pathWait.xPathClassName(linkString);

        Actions actions = new Actions(driver);
        actions.doubleClick(elementLocator).perform();
        elementLocator.sendKeys(goodsItem);

        String linkAddItem = TextLinks.CLICKBAY.getString();
        WebElement linkButton = pathWait.xPathClassName(linkAddItem);
        linkButton.click();

    }

}
