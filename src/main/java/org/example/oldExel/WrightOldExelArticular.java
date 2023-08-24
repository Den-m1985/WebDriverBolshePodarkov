package org.example.oldExel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.example.TextLinks;
import org.example.createPathFile.CreatePathFile;
import org.example.oldExel.createWrite.CreateOldExel;
import org.example.oldExel.createWrite.WriteOldExel;

import java.util.Comparator;
import java.util.List;

public class WrightOldExelArticular {

    public WrightOldExelArticular(List<String[]> list) {
        int celSize = list.get(0).length;

        list.sort(Comparator.comparing(o -> o[celSize - 1]));

        //create no find article
        HSSFWorkbook workbook = new CreateOldExel().createOldExel(list);

        // create file name
        CreatePathFile createPathFile = new CreatePathFile();
        //write no find article, xls file in downloads directory
        String fileName = TextLinks.FILENAMESAVE.getString();
        String downloadsPath = createPathFile.createPathFile(fileName, "xls");

        new WriteOldExel(workbook, downloadsPath);

        System.out.println();
        System.out.println(TextLinks.TEXTSAVEFILE.getString());
        System.out.println(downloadsPath);

    }

}
