package com.factory.documents;

public class WordDocument implements Document {

    @Override
    public void open() {
        System.out.println("[WordDocument] Opening .docx file in Word processor...");
    }

    @Override
    public void save() {
        System.out.println("[WordDocument] Saving document as .docx format.");
    }

    @Override
    public void close() {
        System.out.println("[WordDocument] Closing Word document.");
    }

    @Override
    public String getType() {
        return "Word Document (.docx)";
    }
}
