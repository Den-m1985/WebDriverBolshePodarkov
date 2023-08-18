package org.example;

public enum TextLinks {
    ADDRESS("https://bolshepodarkov.ru/personal/profile/"),
    BASKETADDRESS("https://bolshepodarkov.ru/personal/basket/"),  // поле открыть корзину.
    LOGINFIELD("//form[@action='/personal/profile/?login=yes']//input[@name='USER_LOGIN']"),  // поле ввода логина
    PASSWORDFIELD("//form[@action='/personal/profile/?login=yes']//input[@name='USER_PASSWORD']"),  //поле ввода пароля
    BUTTONENTER("//form[@action='/personal/profile/?login=yes']//input[@name='Login']"),  // кпонка войти в аккаунт
    NAMECITY("//div[@class='bxmaker__geoip__city__line-question-btn-yes js-bxmaker__geoip__city__line-question-btn-yes']"),
    SEARCHFIELD("search-title-input"),  //поле поиска
    BUTTONSEARCH("glyph-icon-loop"),  //поле кнопки поска
    NOGOODS("catalog-content"),  // поле отсутствия товара
    TOBASKET("//span[contains(text(),'В корзину')]"),  // поле товара Подписаться
    PRICE("catalog-section-item-price-discount"),  // поле цены
    MINITEM("intec-ui-part-input"),  //поле мин кол-ва для заказа
    ADDITEM("intec-ui-part-input"),  //поле добавить кол-во
    CLICKBAY("catalog-section-item-purchase-buttons"),  //поле добавить в корзину
    BASKETITEM("basket-item"),  // поле товара в корзине
    CLEARBASKET("//span[contains(text(),'Очистить корзину')]"),// clear Basket
    OUTBASKET("//div[contains(text(),'Выйти')]"),// out Basket
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
