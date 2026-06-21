package com.ecommerce.search;

public class ProductSearch {

    // goes through every element one by one - O(n)
    public static int linearSearch(Product[] products, int targetId) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].getProductId() == targetId) {
                return i;
            }
        }
        return -1;
    }

    // array must be sorted by productId before calling this - O(log n)
    public static int binarySearch(Product[] products, int targetId) {
        int low = 0;
        int high = products.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (products[mid].getProductId() == targetId) {
                return mid;
            } else if (products[mid].getProductId() < targetId) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
