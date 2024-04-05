package org.example.browser;

import org.example.TextLinks;
import org.example.authentication.LoginStorage;
import org.example.browser.chrome.DriverChrome;
import org.example.window.helper_classes.Authorization;
import org.openqa.selenium.*;

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
        String LinksLogin = TextLinks.LOGINFIELD.getString();
        WebElement loginField = driver.findElement(By.name(LinksLogin));
        loginField.click();
        loginField.clear();
        loginField.sendKeys(login);

        // field Password
        String LinksPassword = TextLinks.PASSWORDFIELD.getString();
        WebElement passwordField = driver.findElement(By.name(LinksPassword));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
        password = "";

        // field button enter
        String buttonEnter = TextLinks.BUTTONENTER.getString();
        WebElement buttonEnterField = driver.findElement(By.name(buttonEnter));
        buttonEnterField.click();
    }

}
