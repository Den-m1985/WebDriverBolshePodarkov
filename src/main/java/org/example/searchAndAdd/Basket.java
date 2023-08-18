package org.example.searchAndAdd;

import org.example.TextLinks;
import org.example.browser.chrome.DriverChrome;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.swing.*;
import java.util.List;

public class Basket {
    private WebDriver driver = DriverChrome.getChromeDriver();


    public Basket() {
        String basket = TextLinks.BASKETADDRESS.getString();
        driver.get(basket);
        // если в корзине что-то есть запрашиваем дальнейшее дествие
        if (checkBasket() != 0) {
            int option = dialogClearBasket();
            if (option == 0) {
                clearBasket();
                // проверяем очистил ли корзину?
                if (checkBasket() != 0) {
                    int errorOption = dialogErrorBasket();
                    if (errorOption == 0)
                        DriverChrome.getChromeDriver().close();
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
       /*
       выполняем JavaScript-скрипт с использованием `JavascriptExecutor`
       чтобы прокрутить страницу до кнопки. Затем снова вызываем метод `click()`
       для удаления товаров из корзины.
       */
        String clearBasket = TextLinks.CLEARBASKET.getString();
        WebElement removeItemButton = driver.findElement(By.xpath(clearBasket));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", removeItemButton);
        removeItemButton.click();

    }


    private int dialogClearBasket() {
        // Создаем массив с текстом кнопок
        Object[] options = {"Очистить корзину", "Оставить"};
        String text = "В корзине есть товары";

        // Отображаем окно с двумя кнопками
        int result = JOptionPane.showOptionDialog(null, text, "Вопрос",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, options, options[0]);
        return result;
    }


    private int dialogErrorBasket() {
        // Создаем массив с текстом кнопок
        Object[] options = {"Попробовать снова", "Продолжить"};
        String text = "В корзине есть товары";

        // Отображаем окно с двумя кнопками
        int result = JOptionPane.showOptionDialog(null, text, "Вопрос",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, options, options[0]);
        return result;
    }

}
