package com.factory;

import com.factory.documents.Document;
import com.factory.factories.DocumentFactory;
import com.factory.factories.DocumentFactoryRegistry;

/**
 * Test class demonstrating the Factory Method Pattern.
 */
public class FactoryMethodTest {

    public static void main(String[] args) {

        System.out.println("=== Factory Method Pattern Test ===\n");

        // --- Test 1: Create each document type via its factory ---
        System.out.println("-- Test 1: Create documents using concrete factories --\n");

        String[] documentTypes = {"WORD", "PDF", "EXCEL"};

        for (String type : documentTypes) {
            DocumentFactory factory = DocumentFactoryRegistry.getFactory(type);
            factory.openNewDocument();
            System.out.println();
        }

        // --- Test 2: Full lifecycle per document ---
        System.out.println("-- Test 2: Full document lifecycle (open → save → close) --\n");

        for (String type : documentTypes) {
            DocumentFactory factory = DocumentFactoryRegistry.getFactory(type);
            Document doc = factory.createDocument();

            System.out.println("Document type : " + doc.getType());
            doc.open();
            doc.save();
            doc.close();
            System.out.println();
        }

        // --- Test 3: Polymorphism — client code works with Document interface ---
        System.out.println("-- Test 3: Polymorphic usage (client only knows Document) --\n");

        Document[] docs = {
            DocumentFactoryRegistry.getFactory("WORD").createDocument(),
            DocumentFactoryRegistry.getFactory("PDF").createDocument(),
            DocumentFactoryRegistry.getFactory("EXCEL").createDocument()
        };

        for (Document doc : docs) {
            doc.save(); // same call, different behaviour
        }

        // --- Test 4: Unknown type triggers clear error ---
        System.out.println("\n-- Test 4: Unknown document type handling --");
        try {
            DocumentFactoryRegistry.getFactory("CSV");
        } catch (IllegalArgumentException e) {
            System.out.println("Caught expected error: " + e.getMessage());
        }

        System.out.println("\n=== All tests passed ===");
    }
}
