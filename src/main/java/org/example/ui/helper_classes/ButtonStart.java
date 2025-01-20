package org.example.ui.helper_classes;

import org.example.services.StartCommand;

import javax.swing.*;
import java.util.Objects;

public class ButtonStart {

    public JButton buttonStart() {
        JButton startButton = new JButton("<html><h2><font color=\"blue\">START");
        startButton.setFocusPainted(false);  // бираем рамку вокруг кнопки
        ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/play64.png")));
        startButton.setIcon(icon);

        startButton.addActionListener(new StartCommand());

        return startButton;
    }
}
