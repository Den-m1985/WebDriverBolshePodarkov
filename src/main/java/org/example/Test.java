package org.example;

import org.example.command.Command;
import org.example.createPathFile.GetPathFile;

public class Test {
    public static void main(String[] args) {

        //String pathCSV = null;

        //GetPathFile getPathFile = new GetPathFile();

//        int i = 0;
//        while (i < 2) {
//            TextLinks extension = TextLinks.CSV;
//            pathCSV = getPathFile.getPathFile(extension.getString());
//            if (pathCSV != null)
//                break;
//            else i++;
//        }
        String pathCSV = "C:\\Users\\Den\\Downloads\\WebDriver\\bolshepodarkov.csv";
        //String pathCSV = "C:\\Users\\Den\\Downloads\\WebDriver\\bolshepodarkov(short).csv";

        System.out.println();
        TextLinks textLinks = TextLinks.TEXTFILEOPEN;
        System.out.println(textLinks.getString());
        System.out.println(pathCSV);
        System.out.println();

        Command command = new Command();

        try {
            command.startProgram(pathCSV);

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }



    }
}
