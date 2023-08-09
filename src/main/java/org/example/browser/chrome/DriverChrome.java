package org.example.browser.chrome;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class DriverChrome {
    private static WebDriver chromeDriver;

    public static WebDriver getChromeDriver() {
        if (chromeDriver == null) {
            chromeDriver = driverChrome();
        }
        return chromeDriver;
    }

    private static WebDriver driverChrome() {
        String chromedriverPath = System.getProperty("user.home") + File.separator +
                "chromedriver_win32" + "\\" + "chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromedriverPath);

        // установливаем зависимость, определяющую путь к chromedriver
        ChromeOptions options = new ChromeOptions();
        // https://www.selenium.dev/documentation/webdriver/drivers/options/#pageloadstrategy
        options.setPageLoadStrategy(PageLoadStrategy.EAGER); // ускорение загрузки сайта
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        options.addArguments("--user-agent='Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_2) AppleWebKit/537.17 (KHTML, like Gecko) Chrome/24.0.1309.0 Safari/537.17'");
        //options.setBrowserName(java.lang.String browserName)
        //options.setPlatform(Platform platform)
        //options.setVersion(java.lang.String version)

        WebDriver driver = new ChromeDriver(options);

        //ожидание каждый раз когда выполняется команда на сайте
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.manage().window().fullscreen();
        return driver;
    }

}
