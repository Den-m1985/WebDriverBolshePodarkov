package org.example.window.helper_classes;

import org.example.TextLinks;
import org.example.txt.WriteTxtReport;
import org.example.txt.WriteTxt;

import javax.swing.*;
import java.io.File;
import java.util.Objects;

public class JMenuWindows {


    public JMenuBar createMenu(JTextArea data) {
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(extraMenu(data));
        menuBar.add(createCSVMenu());
        return menuBar;
    }


    private JMenu extraMenu(JTextArea data) {
        // Создание выпадающего меню
        JMenu file = new JMenu("Дополнительно");

        JMenuItem save = new JMenuItem();
        ImageIcon iconSave = new ImageIcon(Objects.requireNonNull(getClass().getResource("/save40.png")));
        save.setIcon(iconSave);

        JMenuItem info = new JMenuItem();
        ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/info40.png")));
        info.setIcon(icon);

        JMenuItem login = new JMenuItem();
        ImageIcon iconLogin = new ImageIcon(Objects.requireNonNull(getClass().getResource("/enter40.png")));
        login.setIcon(iconLogin);

        file.add(save);
        file.addSeparator();
        file.add(info);
        file.addSeparator();
        file.add(login);

        save.addActionListener(arg0 -> new WriteTxtReport(data.getText()));
        info.addActionListener(arg0 -> new Info());
        login.addActionListener(arg0 -> {
            try {
                new Authorization();
                System.out.println("Авторизация прошла успешно");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        return file;
    }


    private JMenu createCSVMenu() {
        JMenu menu = new JMenu("CSV");

        JMenuItem StructureCSV = new JMenuItem("Структура CSV");
        StructureCSV.addActionListener(e -> enterCsvField());
        menu.add(StructureCSV);

        return menu;
    }


    public void enterCsvField() {
        String[] numbers = {"N0", "A", "B", "C", "D"};

        JComboBox<String> nameField = new JComboBox<>(numbers);
        JComboBox<String> articularField = new JComboBox<>(numbers);
        JComboBox<String> priceField = new JComboBox<>(numbers);
        JComboBox<String> itemField = new JComboBox<>(numbers);

        Object[] message = {"Выбери соответствие поля в CSV и поле ниже",
                "Название:", nameField,
                "Артикул:", articularField,
                "Цена:", priceField,
                "Количество:", itemField};
        int option = JOptionPane.showConfirmDialog(null, message, "Структура CSV", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String name = nameField.getSelectedItem().toString();
            String articular = articularField.getSelectedItem().toString();
            String price = priceField.getSelectedItem().toString();
            String item = itemField.getSelectedItem().toString();

            // write value to file
            String linksLoginFile = TextLinks.AUTHORIZATION.getString();
            String filePath = System.getProperty("user.home") + File.separator + linksLoginFile;
            new WriteTxt(filePath, name, articular, price, item);
        }
    }

}
