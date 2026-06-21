package com.singleton;

/**
 * Singleton Logger class.
 * Uses double-checked locking for thread-safe lazy initialization.
 */
public class Logger {

    // volatile ensures visibility of changes across threads
    private static volatile Logger instance = null;

    private int logCount = 0;

    // Private constructor prevents external instantiation
    private Logger() {
        System.out.println("Logger instance created.");
    }

    /**
     * Returns the single instance of Logger.
     * Double-checked locking for thread safety without
     * synchronizing every call.
     */
    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    public void log(String message) {
        logCount++;
        System.out.println("[LOG #" + logCount + "] " + message);
    }

    public int getLogCount() {
        return logCount;
    }
}
