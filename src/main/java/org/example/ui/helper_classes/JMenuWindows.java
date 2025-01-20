package org.example.ui.helper_classes;

import org.example.services.txt.WriteTxtReport;
import javax.swing.*;
import java.util.Objects;

public class JMenuWindows {

    public JMenuBar createMenu(JTextArea data) {
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(extraMenu(data));
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
                System.err.println(e.getMessage());
            }
        });
        return file;
    }
}
