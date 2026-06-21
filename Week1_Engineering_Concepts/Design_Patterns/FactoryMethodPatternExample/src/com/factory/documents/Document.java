package com.factory.documents;

/**
 * Common interface for all document types.
 */
public interface Document {
    void open();
    void save();
    void close();
    String getType();
}
