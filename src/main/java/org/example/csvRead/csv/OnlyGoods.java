package org.example.csvRead.csv;

import org.example.DTO.DtoError;

import java.util.ArrayList;
import java.util.List;

public class OnlyGoods {
    int cellPrice = 2;
    int cellItem = 3;
    private List<DtoError> reportCSV;


    public List<StructureCSV> onlyGoods(List<String[]> rows) {

        List<StructureCSV> dataWithItem = new ArrayList<>();
        reportCSV = new ArrayList<>();
        for (String[] row : rows) {
            try {
                // Если в ячейке price и item число, то эту строку добавляем для дальнейшей работы.
                if (isFigure(row[cellItem]) && isFigure(row[cellPrice])) {
                    int price = floatToInt(row[cellPrice]);
                    int item = Integer.parseInt(row[cellItem]);
                    dataWithItem.add(new StructureCSV(row[0], row[1], price, item));
                }
            } catch (Exception ignored) {
            }
        }
        return dataWithItem;
    }


    public List<DtoError> reportCSV() {
        return reportCSV;
    }


    private boolean isFigure(String str) {
        if (str == null) {
            return false;
        }
        try {
            floatToInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    private int floatToInt(String str) {
        if (str.contains(",")) {
            String str2 = str.replace(",", ".");
            return (int) Float.parseFloat(str2);
        }
        return (int) Float.parseFloat(str);
    }

}
