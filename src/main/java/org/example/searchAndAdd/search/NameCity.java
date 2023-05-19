package org.example.searchAndAdd.search;

import org.example.TextLinks;
import org.example.browser.chrome.DriverChromeSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NameCity {

    public NameCity() {

        WebDriver driver = DriverChromeSingleton.getChromeDriver();

        TextLinks nameCity = TextLinks.NAMECITY;
        WebElement clickName = driver.findElement(By.cssSelector(nameCity.getString()));
        if (clickName.isDisplayed())
            clickName.click();

    }
}
