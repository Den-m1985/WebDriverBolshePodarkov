package org.example.newExel;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.TextLinks;
import org.example.createPathFile.CreatePathFile;

import java.util.Comparator;
import java.util.List;

public class CreateReportExel {

    public CreateReportExel(List<String[]> list) {
        int celSize = list.get(0).length;

        list.sort(Comparator.comparing(o -> o[celSize - 1]));

        //create no find article
        XSSFWorkbook workbook = new CreateExel().createExel(list);

        // create file name
        CreatePathFile createPathFile = new CreatePathFile();
        //write no find article, xls file in downloads directory
        String fileName = TextLinks.FILENAMESAVE.getString();
        String downloadsPath = createPathFile.createPathFile(fileName, "xlsx");

        new WriteExelXlsx(workbook, downloadsPath);

        System.out.println();
        System.out.println(TextLinks.TEXTSAVEFILE.getString());
        System.out.println(downloadsPath);
    }

}
