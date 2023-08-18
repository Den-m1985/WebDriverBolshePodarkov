package org.example.createPathFile;

import org.example.TextLinks;

import java.io.File;

public class CreatePathFile {

    public CreatePathFile() {
    }


    public String createPathFile(String fileName, String extension) {
        Date date = new Date();
        String str = date.currentDate();

        String defaultFolder = TextLinks.SAVEFILEPATH.getString();

        return System.getProperty("user.home") + File.separator +
                defaultFolder + File.separator + fileName + "_" + str + "." + extension;
    }

}
