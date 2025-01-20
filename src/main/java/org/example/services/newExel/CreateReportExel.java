package org.example.services.newExel;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.DTO.DtoError;
import org.example.enums.TextLinks;
import org.example.services.createPathFile.CreatePathFile;

import java.util.Comparator;
import java.util.List;

public class CreateReportExel {

    public CreateReportExel(List<DtoError> list) {

        list.sort(Comparator.comparing(DtoError::getMessage));

        //create no find article
        XSSFWorkbook workbook = new CreateExel().createExel(list);

        //write no find article, xls file in downloads directory
        String fileName = TextLinks.FILE_NAME_SAVE.getString();
        String extension = TextLinks.XLSX.getString();
        String downloadsPath =  new CreatePathFile().createPathFile(fileName, extension);

        new WriteExelXlsx(workbook, downloadsPath);

        System.out.println();
        System.out.println(TextLinks.TEXT_SAVE_FILE.getString());
        System.out.println(downloadsPath);
    }
}
