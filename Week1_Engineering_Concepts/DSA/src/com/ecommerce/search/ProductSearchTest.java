package com.ecommerce.search;

import java.util.Arrays;

public class ProductSearchTest {

    public static void main(String[] args) {

        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(205, "Shoes", "Footwear"),
            new Product(33,  "Book", "Education"),
            new Product(478, "Bottle", "Sports"),
            new Product(160, "Headphones", "Electronics"),
        };

        // linear search on unsorted array
        System.out.println("Linear Search:");
        int idx = ProductSearch.linearSearch(products, 205);
        if (idx != -1)
            System.out.println("Found: " + products[idx]);
        else
            System.out.println("Product not found");

        idx = ProductSearch.linearSearch(products, 999);
        if (idx != -1)
            System.out.println("Found: " + products[idx]);
        else
            System.out.println("Product 999 not found");

        // sort by productId before binary search
        Arrays.sort(products, (a, b) -> a.getProductId() - b.getProductId());

        System.out.println("\nSorted array:");
        for (Product p : products)
            System.out.println("  " + p);

        System.out.println("\nBinary Search:");
        idx = ProductSearch.binarySearch(products, 205);
        if (idx != -1)
            System.out.println("Found: " + products[idx]);
        else
            System.out.println("Product not found");

        idx = ProductSearch.binarySearch(products, 999);
        if (idx != -1)
            System.out.println("Found: " + products[idx]);
        else
            System.out.println("Product 999 not found");
    }
}
