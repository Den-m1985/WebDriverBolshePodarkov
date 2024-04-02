package org.example.browser;

import org.example.TextLinks;
import org.example.browser.chrome.DriverChrome;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class IsEnterAccount {

    public boolean isEnterAccount(String login) {
        //XPathWait pathWait = new XPathWait();
        WebDriver driver = DriverChrome.getChromeDriver();
        String isAccount = TextLinks.ISENTERACCOUNT.getString();

        //pathWait.xPath(isAccount);
        WebElement element = driver.findElement(By.className(isAccount));
        String str = element.getText();
        if (str.equals(login)){
            return true;
        }
        return false;
    }

}
