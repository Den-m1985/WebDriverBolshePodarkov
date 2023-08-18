package org.example.window.helper_classes;

import org.example.TextLinks;
import org.example.controller.Controller;
import org.example.createPathFile.GetPathFile;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartCommand implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        String pathCSV = null;
        GetPathFile getPathFile = new GetPathFile();
        int i = 0;
        while (i < 2) {
            TextLinks extension = TextLinks.CSV;
            pathCSV = getPathFile.getPathFile(extension.getString());
            if (pathCSV != null)
                break;
            else i++;
        }

        System.out.println();
        System.out.println(TextLinks.TEXTFILEOPEN.getString());
        System.out.println(pathCSV);
        System.out.println();

        try {
            new Controller(pathCSV);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        JOptionPane.showMessageDialog(null, "Успешно");
    }

}
