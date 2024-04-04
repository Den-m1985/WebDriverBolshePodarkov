package org.example;

public enum TextLinks {
    ADDRESS("https://bolshepodarkov.ru/personal/profile/auth/login.php"), // login
    BASKETADDRESS("https://bolshepodarkov.ru/personal/basket/"),  // field open basket.
    LOGINFIELD("USER_LOGIN"),  // name email login
    PASSWORDFIELD("USER_PASSWORD"),  // name password login
    BUTTONENTER("Login"),  // name button enter account
    ISENTERACCOUNT("header-main__wrappersonal-container-personal-name"),// is entered account
    NAMECITY("//div[@class='bxmaker__geoip__city__line-question-btn-yes js-bxmaker__geoip__city__line-question-btn-yes']"),
    SEARCHFIELD("header-navigation__wrapsearch-container-form-input"),  // field search
    BUTTONSEARCH("header-navigation__wrapsearch-container-form-button"),  // button field "search"
    NOGOODS("//*[@id=\"i-5-bitrix-catalog-section-catalog-tile-3-OQ3k9PHlVICg\"]"),  // field with goods cart
    CARTFIELD("catalog-section-item-wrapper"),
    TOBASKET("calalog-quantity"),  // button field "add to basket"
    PRICE("catalog-section-item-price-discount"),  // поле цены
    MINITEM("intec-ui-part-input"),  //поле мин кол-ва для заказа
    ADDITEM("calalog-quantity-container-input"),  //поле добавить кол-во
    CLICKBAY("//*[@id=\"bx_3966226736_i-5-bitrix-catalog-section-catalog-tile-3-OQ3k9PHlVICg_60240\"]/div/div[2]/div[2]/a"),  //поле добавить в корзину
    BASKETITEM("basket-item"),  // поле товара в корзине
    CLEARBASKET("basket-items-panel-buttons"),// clear Basket
    OPENFILEPATH("Desktop"),  //открываем папку по умолчанию
    SAVEFILEPATH("Downloads"),  //сохраняем папку по умолчанию
    COUNROWSCSV("количество товаров в csv: "),
    SHEET("Sheet1"),  // имя страницы в отчете
    NOARTICUL("Проверить эти товары"),
    FILENAMESAVE("BolshePodarkov_Report"),  //имя файла с ненайденными артикулами
    AUTHORIZATION("Documents\\AuthBolshePodarkov.txt"), //имя файла для хранения логина и пароля
    TEXTSAVEFILE("Файл куда сохраняем ненайденные артикулы:"),
    TEXTFILEOPEN("Файл исходник:"),
    BASKETEMPTY("Корзина пуста"),
    CSV("csv");


    private final String string;


    TextLinks(String string) {
        this.string = string;
    }


    public String getString() {
        return string;
    }

}
