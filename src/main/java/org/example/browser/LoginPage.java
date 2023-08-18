package org.example.browser;

import org.example.TextLinks;
import org.example.authentication.LoginStorage;
import org.example.browser.IsEnterAccount;
import org.example.browser.chrome.DriverChrome;
import org.example.window.helper_classes.Authorization;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.swing.*;

public class LoginPage {


    public LoginPage() throws Exception {
        int attempt = 3;
        while (attempt > 0) {
            try {
                tryEnterAccount();
                new IsEnterAccount().isEnterAccount();
                attempt = 0;
            } catch (Exception ignored) {
                new Authorization();
                if (attempt == 1) {
                    JOptionPane.showMessageDialog(null, "Не удалось войти в аккаунт");
                    throw new RuntimeException("Не удалось войти в аккаунт");
                }
            }
            attempt--;
        }
    }


    private void tryEnterAccount() throws Exception {
        WebDriver driver = DriverChrome.getChromeDriver();
        // field Login
        String LinksLogin = TextLinks.LOGINFIELD.getString();
        WebElement loginField = driver.findElement(By.xpath(LinksLogin));
        loginField.click();
        loginField.clear();

        String[] decryptedData = new LoginStorage().readFromFile();
        loginField.sendKeys(decryptedData[0]); // enter login
        decryptedData[0] = "";

        // field Password
        String LinksPassword = TextLinks.PASSWORDFIELD.getString();
        WebElement passwordField = driver.findElement(By.xpath(LinksPassword));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(decryptedData[1]);  // enter password
        decryptedData[1] = "";

        // field button enter
        String buttonEnter = TextLinks.BUTTONENTER.getString();
        WebElement buttonEnterField = driver.findElement(By.xpath(buttonEnter));
        buttonEnterField.click();
    }

}
