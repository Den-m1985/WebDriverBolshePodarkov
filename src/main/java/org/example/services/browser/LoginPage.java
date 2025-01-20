package org.example.services.browser;

import org.example.enums.TextLinks;
import org.example.services.authentication.LoginStorage;
import org.example.services.browser.chrome.DriverChrome;
import org.example.ui.helper_classes.Authorization;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.swing.*;

public class LoginPage {
    private final String login;
    private CharSequence password;


    public LoginPage() throws Exception {
        String[] decryptedData = new LoginStorage().readFromFile();
        login = decryptedData[0];
        password = decryptedData[1];
        decryptedData[1] = "";

        Thread.sleep(2000);
        int attempt = 3;
        while (attempt > 0) {
            try {
                tryEnterAccount();
                new IsEnterAccount().isEnterAccount(login);
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


    private void tryEnterAccount() {
        WebDriver driver = DriverChrome.getChromeDriver();

        // field Login
        String LinksLogin = TextLinks.LOGIN_FIELD.getString();
        WebElement loginField = driver.findElement(By.name(LinksLogin));
        loginField.click();
        loginField.clear();
        loginField.sendKeys(login);

        // field Password
        String LinksPassword = TextLinks.PASSWORD_FIELD.getString();
        WebElement passwordField = driver.findElement(By.name(LinksPassword));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
        password = "";

        // field button enter
        String buttonEnter = TextLinks.BUTTON_ENTER.getString();
        WebElement buttonEnterField = driver.findElement(By.name(buttonEnter));
        buttonEnterField.click();
    }

}
