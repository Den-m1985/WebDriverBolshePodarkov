package org.example.browser.chrome;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitChrome extends DriverChromeSingleton {

    private static WebDriverWait wait;

    public static synchronized WebDriverWait getChromeDriverWait() {
        if (wait == null) {
            Duration duration = Duration.ofSeconds(10);
            WebDriver driver = DriverChromeSingleton.getChromeDriver();
            wait = new WebDriverWait(driver, duration);
        }
        return wait;
    }
}
