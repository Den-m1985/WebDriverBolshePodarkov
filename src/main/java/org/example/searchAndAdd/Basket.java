package org.example.searchAndAdd;

import org.example.TextLinks;
import org.example.browser.chrome.DriverChrome;
import org.example.browser.chrome.XPathWait;
import org.example.searchAndAdd.search.NameCity;
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
        if (checkBasket() != 0) {
            int option = showDialog();
            if (option == 0) {
                clearBasket();
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
        String clear = TextLinks.CLEARBASKET.getString();
        //driver.findElement(By.className(clear)).click();

        new NameCity();
        //WebElement c = driver.findElement(By.className("basket-items-panel-buttons"));
        //c.click();

        int count = 5;
        while (count > 0) {
//            try {
//                WebElement c = driver.findElement(By.className("basket-items-panel-buttons"));
//                c.click();
//                System.out.println("1");
//            } catch (Exception e) {
//            }
//            try {
//                XPathWait pathWait = new XPathWait();
//                WebElement c = pathWait.xPathClassName("basket-items-panel-buttons");
//                c.click();
//                System.out.println("2");
//            } catch (Exception e) {
//            }
            try {
                WebElement removeItemButton = driver.findElement(By.xpath("//span[contains(text(),'Очистить корзину')]"));
                if (removeItemButton != null) {
                    // Если товары есть в корзине, выполняем действия для удаления
                    // Нажатие на кнопку "Удалить"
                    removeItemButton.click();
                }
                    System.out.println("3");
            } catch (Exception e) {
            }
            count--;
        }
    }


    private int showDialog() {
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

}
