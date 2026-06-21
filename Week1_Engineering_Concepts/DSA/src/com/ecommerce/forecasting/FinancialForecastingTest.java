package com.ecommerce.forecasting;

public class FinancialForecastingTest {

    public static void main(String[] args) {

        FinancialForecaster forecaster = new FinancialForecaster();

        double principal = 10000;
        double rate = 0.08; // 8% growth rate
        int years = 5;

        double result = forecaster.calculateFutureValue(principal, rate, years);
        System.out.println("Future value after " + years + " years: " + result);

        // print year by year
        System.out.println("\nYear-by-year breakdown:");
        for (int i = 0; i <= years; i++) {
            double val = forecaster.calculateFutureValue(principal, rate, i);
            System.out.printf("Year %d: %.2f%n", i, val);
        }

        // memoized version
        System.out.println("\nUsing memoized version (year 10):");
        double memo = forecaster.calculateFutureValueMemo(principal, rate, 10);
        System.out.printf("Future value: %.2f%n", memo);
    }
}
