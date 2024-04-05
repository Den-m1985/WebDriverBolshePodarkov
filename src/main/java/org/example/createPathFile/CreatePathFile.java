package org.example.createPathFile;

import org.example.TextLinks;

import java.io.File;

public class CreatePathFile {


    public String createPathFile(String fileName, String extension) {
        Date date = new Date();
        String str = date.currentDate();

        String defaultFolder = TextLinks.SAVEFILEPATH.getString();
        String userHome = TextLinks.USERHOME.getString();
        String joinFileName = System.getProperty(userHome) + File.separator +
                defaultFolder + File.separator + fileName + "_" + str + "." + extension;

        return checkSameName(joinFileName);
    }


    private String checkSameName(String fileName) {
        File file = new File(fileName);
        String baseName = fileName.substring(0, fileName.lastIndexOf('.'));
        String extension = fileName.substring(fileName.lastIndexOf('.') + 1);

        int count = 1;
        while (file.exists()) {
            fileName = baseName + "(" + count + ")" + "." + extension;
            file = new File(fileName);
            count++;
        }
        return fileName;
    }

}
