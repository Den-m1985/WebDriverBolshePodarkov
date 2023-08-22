package org.example.window;

import org.example.TextLinks;
import org.example.txt.writeTxt.ReadTxtFile;
import org.example.window.helper_classes.ButtonStart;
import org.example.window.helper_classes.JMenuWindows;
import org.example.window.helper_classes.OutputStreamEncoding;

import javax.swing.*;
import java.awt.*;
import java.io.*;


public class Window extends JFrame {

    public Window() throws UnsupportedEncodingException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setTitle("   Bolshe Podarkov");

        centerScreen();  // set in the center of the screen

        JTextArea textArea = textField();  // print text to area

        setJMenuBar(new JMenuWindows().createMenu(textArea));  // create menu

        add(new ButtonStart().buttonStart(), BorderLayout.NORTH);  // add button start

        add(new JScrollPane(textArea), BorderLayout.CENTER);  // create text field

        add(readDataFromCsvFile(), BorderLayout.SOUTH); // structure CSV

        setVisible(true);

        System.out.println();
        System.out.println("Нажимай кнопку. Откроется окно, по умолчанию Рабочий стол.");
        System.out.println();
    }


    private void centerScreen() {
        // get screen size width and height
        int screenWidth = getToolkit().getScreenSize().width;
        int screenHeight = getToolkit().getScreenSize().height;
        // find coordinate window to set
        int x = (int)((screenWidth - getWidth())/1.1);
        int y = (screenHeight - getHeight()) / 2;
        setLocation(x, y);
    }


    private JTextArea textField() throws UnsupportedEncodingException {
        JTextArea textArea = new JTextArea();
        textArea.setBackground(new Color(220, 220, 220));  // background color
        //  print text to text area
        String STDOUT_ENCODING = "windows-1251";
        PrintStream printStream = new PrintStream(new OutputStreamEncoding(textArea, STDOUT_ENCODING),
                true, STDOUT_ENCODING);
        // re-assigns standard output stream and error output stream
        System.setOut(printStream);
        System.setErr(printStream);
        return textArea;
    }


    private JPanel readDataFromCsvFile() {
        JPanel panel = new JPanel();

        String linksLoginFile = TextLinks.AUTHORIZATION.getString();
        String filePath = System.getProperty("user.home") + File.separator + linksLoginFile;
        String str = new ReadTxtFile().readTxtFile(filePath);
        String[] div = str.split(System.lineSeparator());

        String result = "Поля для SCV:  " + div[1];
        JLabel fromCSV = new JLabel(result);
        panel.add(fromCSV);
        return panel;
    }

}
