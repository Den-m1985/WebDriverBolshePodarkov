package org.example.services.browser;

import org.example.enums.TextLinks;
import org.example.services.browser.chrome.DriverChrome;
import org.openqa.selenium.WebDriver;

public class OpenWebSite {

    public OpenWebSite() {
        WebDriver driver = DriverChrome.getChromeDriver();

        driver.get(TextLinks.ADDRESS.getString());
    }

}
