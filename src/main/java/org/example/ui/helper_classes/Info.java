package org.example.ui.helper_classes;

public class Info {

    public Info() {
        String info = """
                Данный проект разработан для работы с сайтом https://bolshepodarkov.ru
                Он основан на Selenium Framework.
                Также используется:
                - csv
                - exl
                - swing

                Этот проект нужен для автоматизации процесса заказа товаров.

                Подготовка перед запуском проекта:
                нам нужно получить csv файл, содержащий 4 столбца (название товара, артикул, цена, количество).
                Получается при разборе с сайта SP39.ru.

                Далее запускаем программу.

                Откроется окно выбора файла.
                Вы должны выбрать CSV-файл. Далее программа будет работать в автономном режиме.

                Есть нюанс: если свернуть браузер, то со временем операционная система
                отключает этот браузер и программа не может добавлять товары; за каждый не добавленный продукт,
                он генерирует отчет. Программа продолжает работать.
                Отчет содержит название продукта и возникшую ошибку (общая ошибка,
                товар не найден, цена на сайте выше и процент
                если есть более одного продукта (программа не может решить, какой продукт
                на выбор и отправляет в отчет)).

                Файл отчета появится в папке «Загрузки».
                Выглядит это так:
                BolshePodarkov_Report_14_04_2023.xls
                """;
        System.out.println(info);
    }
}
