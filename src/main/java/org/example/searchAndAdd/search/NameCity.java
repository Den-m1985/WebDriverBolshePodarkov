package org.example.searchAndAdd.search;

import org.example.TextLinks;
import org.example.browser.chrome.DriverChrome;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NameCity {

    public NameCity() {

        WebDriver driver = DriverChrome.getChromeDriver();

        String nameCity = TextLinks.NAMECITY.getString();
        WebElement clickName = driver.findElement(By.cssSelector(nameCity));
        if (clickName.isDisplayed())
            clickName.click();

    }
}
