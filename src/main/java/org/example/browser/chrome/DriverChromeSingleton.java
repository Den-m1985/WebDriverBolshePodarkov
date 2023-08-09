package org.example.browser.chrome;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverChromeSingleton extends DriverChrome {
    //private static WebDriver chromeDriver;

    //protected WebDriver driver = new DriverChrome().driverChrome();


    //private static final DriverChrome instance = null;


//    public static synchronized WebDriver getChromeDriver() {
//        if (chromeDriver == null) {
//            chromeDriver = new DriverChromeSingleton().driverChrome();
//        }
//        return chromeDriver;
//    }

//    @Override
//    public WebDriver driverChrome() {
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        options.addArguments("--disable-notifications");
//        options.setCapability("unexpectedAlertBehaviour", "ignore");
//        options.setCapability("ignoreProtectedModeSettings", true);
//        options.setCapability(ChromeOptions.CAPABILITY, options);
//
//        return super.driverChrome(); // вызов родительского метода с помощью super
//    }

}
