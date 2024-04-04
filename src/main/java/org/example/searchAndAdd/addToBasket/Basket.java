package org.example.searchAndAdd.addToBasket;

import org.example.TextLinks;
import org.example.browser.chrome.DriverChrome;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.swing.*;
import java.util.List;

public class Basket {
    private WebDriver driver = DriverChrome.getChromeDriver();


    public Basket() {
        String basket = TextLinks.BASKETADDRESS.getString();
        driver.get(basket);
        // if basket have goods
        if (checkBasket() != 0) {
            int option = dialogClearBasket();
            if (option == 0) {
                clearBasket();
                if (checkBasket() != 0) {
                    int errorOption = dialogErrorBasket();
                    if (errorOption == 0)
                        driver.close();
                }
            }
        } else {
            String basketEmpty = TextLinks.BASKETEMPTY.getString();
            System.out.println(basketEmpty);
        }
    }


    public int checkBasket() {
        String basketItem = TextLinks.BASKETITEM.getString();
        List<WebElement> cart = driver.findElements(By.className(basketItem));
        return cart.size();
    }


    public void clearBasket() {
        String clearBasket = TextLinks.CLEARBASKET.getString();
        WebElement removeItemButton = driver.findElement(By.className(clearBasket));
        removeItemButton.click();
    }


    private int dialogClearBasket() {
        Object[] options = {"Очистить корзину", "Оставить"};
        String text = "В корзине есть товары";

        // window with 2 button
        int result = JOptionPane.showOptionDialog(null, text, "Вопрос",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, options, options[0]);
        return result;
    }


    private int dialogErrorBasket() {
        Object[] options = {"Попробовать снова", "Продолжить"};
        String text = "В корзине есть товары";

        // window with 2 button
        int result = JOptionPane.showOptionDialog(null, text, "Вопрос",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, options, options[0]);
        return result;
    }

}
