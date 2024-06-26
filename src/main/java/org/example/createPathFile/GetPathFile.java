package org.example.createPathFile;

import org.example.TextLinks;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;

public class GetPathFile {
    private String path;

    public String getPathFile(String extension) {

        JFileChooser fileOpen = new JFileChooser();

        fileOpen.setPreferredSize(new Dimension(600, 500)); // window size
        FileNameExtensionFilter filter = new FileNameExtensionFilter("files " + extension, extension);
        fileOpen.setFileFilter(filter);

        String defaultFolder = TextLinks.OPENFILEPATH.getString();
        String userHome = TextLinks.USERHOME.getString();

        // open directory by default.
        fileOpen.setCurrentDirectory(new File(System.getProperty(userHome) + File.separator +
                defaultFolder));
        int ret = fileOpen.showDialog(null, "Открыть файл");
        if (ret == JFileChooser.APPROVE_OPTION) {
            File file = fileOpen.getSelectedFile();
            path = file.getAbsolutePath();
        }

        return path;
    }

}
