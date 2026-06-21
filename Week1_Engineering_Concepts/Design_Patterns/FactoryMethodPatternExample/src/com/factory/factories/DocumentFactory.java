package com.factory.factories;

import com.factory.documents.Document;

/**
 * Abstract Factory class defining the Factory Method.
 * Subclasses decide which Document type to instantiate.
 */
public abstract class DocumentFactory {

    // The Factory Method — subclasses must override this
    public abstract Document createDocument();

    /**
     * Template method: uses the factory method internally.
     * Demonstrates that the factory can do work beyond just creating.
     */
    public void openNewDocument() {
        Document doc = createDocument();
        System.out.println("Created: " + doc.getType());
        doc.open();
    }
}
