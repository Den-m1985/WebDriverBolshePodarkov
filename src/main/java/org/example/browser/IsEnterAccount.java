package org.example.browser;

import org.example.TextLinks;
import org.example.browser.chrome.DriverChrome;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class IsEnterAccount {

    public boolean isEnterAccount(String login) {
        WebDriver driver = DriverChrome.getChromeDriver();
        String isAccount = TextLinks.ISENTERACCOUNT.getString();

        WebElement element = driver.findElement(By.className(isAccount));
        String str = element.getText();
        return str.equals(login);
    }

}
