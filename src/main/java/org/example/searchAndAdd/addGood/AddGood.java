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

        TextLinks linkString = TextLinks.ADDITEM;
        WebElement elementLocator = pathWait.xPathClassName(linkString.getString());
        Actions actions = new Actions(driver);
        actions.doubleClick(elementLocator).perform();
        elementLocator.sendKeys(goodsItem);

        TextLinks linkAddItem = TextLinks.CLICKBAY;
        WebElement linkButton = pathWait.xPathClassName(linkAddItem.getString());
        linkButton.click();

    }

}
