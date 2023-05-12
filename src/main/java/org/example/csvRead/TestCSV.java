package org.example.csvRead;

import com.opencsv.exceptions.CsvException;
import org.example.csvRead.csv.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestCSV {

    public static void main(String[] args) throws IOException, CsvException {
        //String fileName = "C:\\Users\\Den\\Downloads\\WebDriver\\Alfa812(3).csv";
        //String fileName = "C:\\Users\\Den\\Downloads\\WebDriver\\bolshepodarkov.csv";
        String fileName = "C:\\Users\\Den\\Downloads\\WebDriver\\bolshepodarkov(short).csv";


        int cellPrice = 2;
        int cellItem = 3;   // Cell with item to order
        CsvFilter csvFilter = new CsvFilter(fileName);
        List<StructureCSV> data = csvFilter.csvFilter(cellPrice, cellItem);

        List<String[]> error = csvFilter.getError();
        List<String[]> reportList = new ArrayList<>();
//        String[] noAdd = {"goodsName", "Какая-то общая ошибка"};
//        reportList.add(noAdd);
        reportList.addAll(error);

        data.sort(Comparator.comparing(StructureCSV::getName));
        for (StructureCSV x : data) {
            System.out.println(x.getPrice());
        }
        System.out.println();
        for (String[] x : reportList) {
            //System.out.println(x[0] + "---" + x[1]);
        }


        String[] sdfd = {"219,2", "219.2", "2192", "0", "", null, "-20", "fgh,g", "fg"};
        for (String c : sdfd) {
            //System.out.println(isInteger(c));
        }


//        CsvRead csvRead = new CsvRead(fileName);
//        List<String[]> rows = csvRead.readCSV();
//
//        // В этом блоке оставляем только те колонки где есть цена и кол-во
//        OnlyGoods onlyGoods = new OnlyGoods();
//        List<StructureCSV> dataWithItem = onlyGoods.onlyGoods(rows, 2,3);
//        List<String[]> error = onlyGoods.reportCSV();
//        System.out.println("error.size()---" + error.size());
//        for (String[] x:error) {
//            System.out.println(x[0] + "---" + x[1]);
//        }
//
//        // этот блок возвращает иникальные элементы
//        UniqueGoods uniqueGoods = new UniqueGoods();
//        List<StructureCSV> uniqueValues = uniqueGoods.uniqueGoods(dataWithItem);
//        List<StructureCSV> duplicateNames = uniqueGoods.getDuplicateNames();
//
//
//        List<StructureCSV> resolveDuplicatedNames = new DuplicateGoods().duplicateGoods(duplicateNames);
//        uniqueValues.addAll(resolveDuplicatedNames);

//        for (StructureCSV x:uniqueValues) {
//            System.out.println(x.getName());
//        }
//        System.out.println();
//        for (StructureCSV x:duplicateNames) {
//            System.out.println(x.toString());
//        }
//        System.out.println();
//        for (StructureCSV x:resolveDuplicatedNames) {
//            System.out.println(x.toString());
//        }

    }

    static boolean isInteger(String str) {
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


    static int floatToInt(String str) {
        if (str.contains(",")) {
            String str2 = str.replace(",", ".");
            return (int) Float.parseFloat(str2);
        }
        return (int) Float.parseFloat(str);
    }


}
