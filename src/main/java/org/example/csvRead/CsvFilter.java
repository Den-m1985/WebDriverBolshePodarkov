package org.example.csvRead;

import com.opencsv.exceptions.CsvException;
import org.example.TextLinks;
import org.example.csvRead.csv.*;
import org.example.txt.GetNameFieldCSV;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

public class CsvFilter {
    private List<String[]> error;


    public List<StructureCSV> csvFilter(String fileName) throws IOException, CsvException {

        LinkedHashMap<String, Integer> cellCSV = new GetNameFieldCSV().getNameFieldCSV();

        CsvRead csvRead = new CsvRead(fileName);
        List<String[]> rows = csvRead.readCSV();

        // В этом блоке оставляем только те колонки где есть цена и кол-во
        OnlyGoods onlyGoods = new OnlyGoods();
        List<StructureCSV> dataWithItem = onlyGoods.onlyGoods(rows, cellCSV);
        error = onlyGoods.reportCSV();

        // этот блок возвращает иникальные элементы
        UniqueGoods uniqueGoods = new UniqueGoods();
        List<StructureCSV> uniqueValues = uniqueGoods.uniqueGoods(dataWithItem);
        List<StructureCSV> duplicateNames = uniqueGoods.getDuplicateNames();

        // этот блок работатет с повторяющимися именами.
        List<StructureCSV> resolveDuplicatedNames = new DuplicateGoods().duplicateGoods(duplicateNames);
        uniqueValues.addAll(resolveDuplicatedNames);

        String textLinks = TextLinks.COUNROWSCSV.getString();
        System.out.println(textLinks + uniqueValues.size());
        System.out.println();

        return uniqueValues;
    }


    public List<String[]> getError() {
        return error;
    }

}
