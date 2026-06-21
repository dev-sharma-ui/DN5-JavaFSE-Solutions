package com.singleton;

public class SingletonTest {

    public static void main(String[] args) {

        Logger l1 = Logger.getInstance();
        Logger l2 = Logger.getInstance();
        Logger l3 = Logger.getInstance();

        // should print the same hashcode for all three
        System.out.println("l1 hashcode: " + l1.hashCode());
        System.out.println("l2 hashcode: " + l2.hashCode());
        System.out.println("l3 hashcode: " + l3.hashCode());

        System.out.println("l1 == l2: " + (l1 == l2));
        System.out.println("l2 == l3: " + (l2 == l3));

        l1.log("App started");
        l2.log("User logged in");
        l3.log("Data fetched");

        // all three see same count because its the same instance
        System.out.println("Total logs: " + l1.getLogCount());
    }
}
