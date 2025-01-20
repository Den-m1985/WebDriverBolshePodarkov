package org.example.services.searchAndAdd.addToBasket;

import org.example.enums.TextLinks;
import org.example.services.browser.chrome.DriverChrome;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.swing.*;
import java.util.List;

public class Basket {
    private final WebDriver driver = DriverChrome.getChromeDriver();

    public Basket() {
        String basket = TextLinks.BASKET_ADDRESS.getString();
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
            System.out.println();
            System.out.println(TextLinks.BASKET_EMPTY.getString());
        }
    }


    public int checkBasket() {
        String basketItem = TextLinks.BASKET_ITEM.getString();
        List<WebElement> cart = driver.findElements(By.className(basketItem));
        return cart.size();
    }


    public void clearBasket() {
        String clearBasket = TextLinks.CLEAR_BASKET.getString();
        WebElement removeItemButton = driver.findElement(By.className(clearBasket));
        removeItemButton.click();
    }


    private int dialogClearBasket() {
        Object[] options = {"Очистить корзину", "Оставить"};
        String text = "В корзине есть товары";

        // window with 2 button
        return JOptionPane.showOptionDialog(null, text, "Вопрос",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, options, options[0]);
    }

    private int dialogErrorBasket() {
        Object[] options = {"Попробовать снова", "Продолжить"};
        String text = "В корзине есть товары";

        // window with 2 button
        return JOptionPane.showOptionDialog(null, text, "Вопрос",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, options, options[0]);
    }
}
