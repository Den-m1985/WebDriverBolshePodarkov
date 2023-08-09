package org.example.browser;

import org.example.browser.chrome.DriverChrome;
import org.openqa.selenium.WebDriver;

public class OpenWebSite {

    public OpenWebSite(String webAddress) {
        WebDriver driver = DriverChrome.getChromeDriver();

        driver.get(webAddress);
    }

}
