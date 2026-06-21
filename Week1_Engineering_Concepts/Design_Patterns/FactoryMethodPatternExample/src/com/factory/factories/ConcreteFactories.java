package com.factory.factories;

import com.factory.documents.Document;
import com.factory.documents.WordDocument;
import com.factory.documents.PdfDocument;
import com.factory.documents.ExcelDocument;

/**
 * Concrete factory for Word documents.
 */
class WordDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}

/**
 * Concrete factory for PDF documents.
 */
class PdfDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new PdfDocument();
    }
}

/**
 * Concrete factory for Excel documents.
 */
class ExcelDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new ExcelDocument();
    }
}
