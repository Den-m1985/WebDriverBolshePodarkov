package org.example;

public enum TextLinks {
    ADDRESS("https://bolshepodarkov.ru/personal/profile/"),
    LOGINFIELD("body > div.intec-template > div.intec-template-content > div > div.intec-template-page > div.ns-bitrix.c-system-auth-authorize.c-system-auth-authorize-default > div > div > div > div > div:nth-child(1) > div > form > div.system-auth-authorize-form-fields.intec-ui-form-fields > div:nth-child(1) > div.intec-ui-form-field-content > input"),  // поле ввода логина
    PASSWORDFIELD("body > div.intec-template > div.intec-template-content > div > div.intec-template-page > div > div > div > div > div > div:nth-child(1) > div > form > div.system-auth-authorize-form-fields.intec-ui-form-fields > div:nth-child(2) > div.intec-ui-form-field-content > input"),  //поле ввода пароля
    ENTERACCOUNT("//*[@id=\"popup-window-content-i-3-bitrix-system-auth-form-panel-iIjGFB3HxHmm-modal\"]/div/div/div/div[1]/div/form/div[3]/input"),  //поле входа
    BUTTONENTER("body > div.intec-template > div.intec-template-content > div > div.intec-template-page > div > div > div > div > div > div:nth-child(1) > div > form > div.system-auth-authorize-form-buttons > input"),  // кпонка войти в аккаунт
    NAMECITY("#bxmaker__geoip__city__line-id > div > div.bxmaker__geoip__city__line-question.js-bxmaker__geoip__city__line-question > div.bxmaker__geoip__city__line-question-btn-box > div.bxmaker__geoip__city__line-question-btn-yes.js-bxmaker__geoip__city__line-question-btn-yes"),
    SEARCHFIELD("#-input-1"),  //поле поиска
    BUTTONSEARCH("#i-4-bitrix-search-title-input-1-XdqEv16rajmu > div > form > div > div.intec-grid-item-auto > button > i"),  //поле кнопки поска
    CLICKINSEARCH("catalog-section-item-wrapper"),  // поле выбора товара в поиске
    SUBSCRIBE("i-15-bitrix-catalog-section-catalog-tile-3-OQ3k9PHlVICg_subscribe_2301"),  // поле отсутствия товара
    //PRICE("catalog-element-price-discount"),  // поле цены
    PRICE("catalog-section-item-price-discount"),  // поле цены
    ADDITEM("intec-ui-part-input"),  //поле добавить кол-во
    SIZE("//*[@id=\"content\"]/div/div[2]/form/div/select"),  //поле выбра размера
    CLICKBAY("catalog-section-item-purchase-buttons"),  //поле добавить в корзину
    CLOSEWINDOW("//*[@id=\"fancybox-close\"]"),  //закрыть всплывающее окно
    FIELDCART("//*[@id=\"cart_informer\"]"),  // поле открыть корзину.
    OPENFILEPATH("Desktop"),  //открываем папку по умолчанию
    SAVEFILEPATH("Downloads"),  //сохраняем папку по умолчанию
    COUNROWSCSV("количество товаров в csv: "),
    SHEET("Sheet1"),  // имя страницы в отчете
    NOARTICUL("Проверить эти товары"),
    FILENAMESAVE("BolshePodarkov_Report"),  //имя файла с ненайденными артикулами
    AUTHORIZATION("Documents\\AuthBolshePodarkov.txt"), //имя файла для хранения логина и пароля
    TEXTSAVEFILE("Файл куда сохраняем ненайденные артикулы"),
    TEXTFILEOPEN("Файл исходник:"),
    CSV("csv");

    private final String string;

    TextLinks(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }
}
