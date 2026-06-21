package com.ecommerce.forecasting;

import java.util.HashMap;

public class FinancialForecaster {

    private HashMap<Integer, Double> cache = new HashMap<>();

    // recursive method - each call handles one period
    // base case: when periods = 0, just return the present value
    public double calculateFutureValue(double presentValue, double growthRate, int periods) {
        if (periods == 0) {
            return presentValue;
        }
        return calculateFutureValue(presentValue, growthRate, periods - 1) * (1 + growthRate);
    }

    // memoized version to avoid recalculating same period multiple times
    public double calculateFutureValueMemo(double presentValue, double growthRate, int periods) {
        if (periods == 0) {
            return presentValue;
        }
        if (cache.containsKey(periods)) {
            return cache.get(periods);
        }
        double result = calculateFutureValueMemo(presentValue, growthRate, periods - 1) * (1 + growthRate);
        cache.put(periods, result);
        return result;
    }
}
