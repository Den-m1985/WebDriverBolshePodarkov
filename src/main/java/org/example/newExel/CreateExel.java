package org.example.newExel;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.TextLinks;

import java.util.List;

public class CreateExel {


    public XSSFWorkbook createExel(List<String[]> list) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        String textSheet = TextLinks.SHEET.getString();
        Sheet sheet = workbook.createSheet(textSheet);

        //Row  строка
        //Cell столб
        Row row = sheet.createRow(0);
        String noFindArticular = TextLinks.NOARTICUL.getString();
        row.createCell(0).setCellValue(noFindArticular);

        // create topic
        Row rowTop = sheet.createRow(2);
        rowTop.createCell(0).setCellValue("Наименование");
        rowTop.createCell(2).setCellValue("Артикул");
        rowTop.createCell(3).setCellValue("Тип ошибки");


        for (int i = 0; i < list.size(); i++) {
            Row row2 = sheet.createRow(i + 3);
            int size = list.get(i).length;
            row2.createCell(0).setCellValue(list.get(i)[0]);
            if (size > 2)
                row2.createCell(2).setCellValue(list.get(i)[1]);
            row2.createCell(3).setCellValue(list.get(i)[size - 1]);
        }
        return workbook;
    }

}
