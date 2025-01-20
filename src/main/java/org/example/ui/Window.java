package org.example.ui;

import org.example.enums.TextLinks;
import org.example.ui.helper_classes.ButtonStart;
import org.example.ui.helper_classes.JMenuWindows;
import org.example.ui.helper_classes.OutputStreamEncoding;

import javax.swing.*;
import java.awt.*;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class Window extends JFrame {

    public Window() throws UnsupportedEncodingException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setTitle(TextLinks.TITLE.getString());

        centerScreen();

        JTextArea textArea = textField();  // print text to area

        setJMenuBar(new JMenuWindows().createMenu(textArea));  // create menu

        add(new ButtonStart().buttonStart(), BorderLayout.NORTH);  // add button start

        add(new JScrollPane(textArea), BorderLayout.CENTER);  // create text field

        setVisible(true);

        startText();
    }


    private void centerScreen() {
        // get screen size width and height
        int screenWidth = getToolkit().getScreenSize().width;
        int screenHeight = getToolkit().getScreenSize().height;
        // find coordinate window to set
        int x = (int) ((screenWidth - getWidth()) / 1.1);
        int y = (screenHeight - getHeight()) / 2;
        setLocation(x, y);
    }


    private JTextArea textField() throws UnsupportedEncodingException {
        JTextArea textArea = new JTextArea();
        textArea.setBackground(new Color(220, 220, 220));  // background color
        textArea.setLineWrap(true); // переносит текст если поле заполнено
        textArea.setEditable(false);  // неизменяемый текст
        textArea.setMargin(new Insets(10, 10, 10, 10)); // Margin: header, left, footer, right

        //  print text to text area
        String STDOUT_ENCODING = TextLinks.ENCODING.getString();
        PrintStream printStream = new PrintStream(new OutputStreamEncoding(textArea, STDOUT_ENCODING),
                true, STDOUT_ENCODING);
        // re-assigns standard output stream and error output stream
        System.setOut(printStream);
        System.setErr(printStream);
        return textArea;
    }

    private void startText() {
        System.out.println();
        System.out.println("Нажимай кнопку. Откроется окно, по умолчанию Рабочий стол.");
    }
}
