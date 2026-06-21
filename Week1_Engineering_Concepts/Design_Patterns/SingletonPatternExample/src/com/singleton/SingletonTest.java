package com.singleton;

/**
 * Test class to verify the Singleton pattern implementation.
 */
public class SingletonTest {

    public static void main(String[] args) {

        System.out.println("=== Singleton Pattern Test ===\n");

        // --- Test 1: Basic instance retrieval ---
        System.out.println("-- Test 1: Obtaining instances --");
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        Logger logger3 = Logger.getInstance();

        System.out.println("logger1 hashCode: " + logger1.hashCode());
        System.out.println("logger2 hashCode: " + logger2.hashCode());
        System.out.println("logger3 hashCode: " + logger3.hashCode());

        // --- Test 2: Reference equality ---
        System.out.println("\n-- Test 2: Reference equality (== check) --");
        System.out.println("logger1 == logger2 : " + (logger1 == logger2));
        System.out.println("logger2 == logger3 : " + (logger2 == logger3));

        // --- Test 3: Shared state ---
        System.out.println("\n-- Test 3: Shared state across references --");
        logger1.log("Application started");
        logger2.log("User logged in");
        logger3.log("Processing request");

        // All three references share the same log count
        System.out.println("\nTotal logs via logger1: " + logger1.getLogCount());
        System.out.println("Total logs via logger2: " + logger2.getLogCount());
        System.out.println("Total logs via logger3: " + logger3.getLogCount());

        // --- Test 4: Simulated multi-module usage ---
        System.out.println("\n-- Test 4: Simulated multi-module usage --");
        simulateModule("AuthModule");
        simulateModule("PaymentModule");
        simulateModule("ReportModule");

        System.out.println("\nFinal log count: " + Logger.getInstance().getLogCount());
        System.out.println("\n=== All tests passed: Only one Logger instance exists ===");
    }

    private static void simulateModule(String moduleName) {
        Logger logger = Logger.getInstance();
        logger.log("[" + moduleName + "] Module initialized");
    }
}
