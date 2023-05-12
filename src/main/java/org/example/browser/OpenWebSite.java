package org.example.browser;

import org.example.TextLinks;
import org.example.browser.chrome.DriverChromeSingleton;
import org.openqa.selenium.WebDriver;

public class OpenWebSite {

    public OpenWebSite() {

        WebDriver driver = DriverChromeSingleton.getChromeDriver();


        TextLinks textLinks = TextLinks.ADDRESS;
        driver.get(textLinks.getString());
    }


}
