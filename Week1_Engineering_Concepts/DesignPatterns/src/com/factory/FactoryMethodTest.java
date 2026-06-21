package com.factory;

import com.factory.documents.Document;
import com.factory.factories.*;

public class FactoryMethodTest {

    public static void main(String[] args) {

        // create a word document using word factory
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document word = wordFactory.createDocument();
        word.open();
        word.save();
        word.close();

        System.out.println();

        // create a pdf document
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdf = pdfFactory.createDocument();
        pdf.open();
        pdf.save();
        pdf.close();

        System.out.println();

        // create an excel document
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excel = excelFactory.createDocument();
        excel.open();
        excel.save();
        excel.close();
    }
}
