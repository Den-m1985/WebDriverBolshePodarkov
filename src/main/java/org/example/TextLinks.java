package org.example;

public enum TextLinks {
    ADDRESS("https://bolshepodarkov.ru/personal/profile/auth/login.php"), // login
    BASKETADDRESS("https://bolshepodarkov.ru/personal/basket/"),  // field open basket.
    LOGINFIELD("USER_LOGIN"),  // name email login
    PASSWORDFIELD("USER_PASSWORD"),  // name password login
    BUTTONENTER("Login"),  // name button enter account
    ISENTERACCOUNT("header-main__wrappersonal-container-personal-name"),// is entered account
    SEARCHFIELD("header-navigation__wrapsearch-container-form-input"),  // field search
    BUTTONSEARCH("header-navigation__wrapsearch-container-form-button"),  // button field "search"
    CARTFIELD("catalog-section-item-wrapper"),
    TOBASKET("calalog-quantity"),  // button field "add to basket or subscribe"
    PRICE("catalog-section-item-price-discount"),
    MINITEM("intec-ui-part-input"),  // field to minimum to order
    ADDITEM("calalog-quantity-container-input"),  // field add item to basket
    BASKETITEM("basket-item"),  // field basket items
    CLEARBASKET("basket-items-panel-buttons"),// clear Basket
    SUBSCRIBE("Подписаться"),
    OPENFILEPATH("Desktop"),  // open the default folder
    SAVEFILEPATH("Downloads"),  // save report file
    COUNROWSCSV("количество товаров в csv: "),
    SHEET("Sheet1"),
    NOARTICUL("Проверить эти товары"),
    FILENAMESAVE("BolshePodarkov_Report"),
    AUTHORIZATION("Documents\\AuthBolshePodarkov.txt"), // file storage name with login
    TEXTSAVEFILE("Файл куда сохраняем ненайденные артикулы:"),
    TEXTFILEOPEN("Файл исходник:"),
    BASKETEMPTY("Корзина пуста"),
    CSV("csv"),
    USERHOME("user.home");


    private final String string;


    TextLinks(String string) {
        this.string = string;
    }


    public String getString() {
        return string;
    }

}
