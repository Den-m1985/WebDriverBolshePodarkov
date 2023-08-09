package org.example.browser.chrome;

import org.example.TextLinks;
import org.example.authentication.LoginStorage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {


    public LoginPage() {
        LoginStorage loginStorage = new LoginStorage();
        //WebDriver driver = DriverChrome.getChromeDriver();
        XPathWait pathWait = new XPathWait();

        int i = 0;
        while (i < 5) {
            try {
                // field Login
                String LinksLogin = TextLinks.LOGINFIELD.getString();
                //WebElement loginField = driver.findElement(By.cssSelector(LinksLogin));
                WebElement loginField = pathWait.xPathCssSelector(LinksLogin);
                loginField.click();
                String[] decryptedData = loginStorage.readFromFile();
                loginField.sendKeys(decryptedData[0]); // enter login
                decryptedData[0] = "";

                // field Password
                String LinksPassword = TextLinks.PASSWORDFIELD.getString();
                //WebElement passwordField = driver.findElement(By.cssSelector(LinksPassword));
                WebElement passwordField = pathWait.xPathCssSelector(LinksPassword);
                passwordField.click();
                passwordField.sendKeys(decryptedData[1]);  // enter password
                decryptedData[1] = "";

                // field button enter
                String buttonEnter = TextLinks.BUTTONENTER.getString();
                //WebElement buttonEnterField = driver.findElement(By.cssSelector(buttonEnter));
                WebElement buttonEnterField = pathWait.xPathCssSelector(buttonEnter);
                buttonEnterField.click();
                break;
            } catch (Exception ignored) {
            }
            i++;
        }
        //System.out.println("Кол-во попыток войти в личный кабинет " + i);
    }

}
