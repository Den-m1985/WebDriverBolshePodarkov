package org.example.browser.chrome;

import org.example.TextLinks;
import org.example.authentication.LoginStorage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends DriverChromeSingleton {


    public LoginPage() {

        LoginStorage loginStorage = new LoginStorage();
        WebDriver driver = DriverChromeSingleton.getChromeDriver();

        /*
        try {
            WebElement login2 = driver.findElement(By.name("widget-panel-button-text intec-grid-item-auto"));
            System.out.println("login.getText()---" + login2.getText());
            WebElement login = driver.findElement(By.className("widget-panel-button-text intec-grid-item-auto"));
            System.out.println("login.getText()---" + login.getText());
        } catch (Exception ignored) {
        }
        */

        int i = 0;
        while (i < 5) {
            try {
                // field Login
                TextLinks LinksLogin = TextLinks.LOGINFIELD;
                WebElement loginField = driver.findElement(By.cssSelector(LinksLogin.getString()));
                loginField.click();
                String[] decryptedData = loginStorage.readFromFile();
                loginField.sendKeys(decryptedData[0]); // enter login
                decryptedData[0] = "";

                // field Password
                TextLinks LinksPassword = TextLinks.PASSWORDFIELD;
                WebElement passwordField = driver.findElement(By.cssSelector(LinksPassword.getString()));
                passwordField.click();
                passwordField.sendKeys(decryptedData[1]);  // enter password
                decryptedData[1] = "";

                // field button enter
                TextLinks buttonEnter = TextLinks.BUTTONENTER;
                WebElement buttonEnterField = driver.findElement(By.cssSelector(buttonEnter.getString()));
                buttonEnterField.click();
                break;
            } catch (Exception ignored) {
            }
            i++;
        }
        //System.out.println("Кол-во попыток войти в личный кабинет " + i);
    }


}
