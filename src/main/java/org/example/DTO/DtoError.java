package org.example.DTO;

import org.example.csvRead.csv.StructureCSV;

public class DtoError {

    private final String message;
    private final StructureCSV product;

    public DtoError(String message, StructureCSV product) {
        this.message = message;
        this.product = product;
    }

}
