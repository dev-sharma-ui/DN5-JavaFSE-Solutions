package com.factory.factories;

/**
 * Registry that maps document type strings to their factories.
 * Keeps the client (test class) clean — it only deals with strings.
 */
public class DocumentFactoryRegistry {

    public static DocumentFactory getFactory(String documentType) {
        switch (documentType.toUpperCase()) {
            case "WORD":  return new WordDocumentFactory();
            case "PDF":   return new PdfDocumentFactory();
            case "EXCEL": return new ExcelDocumentFactory();
            default:
                throw new IllegalArgumentException(
                    "Unknown document type: " + documentType
                );
        }
    }
}
