public class FinancialForecaster {
    public static double calculateFutureValue(double currentValue, double[] growthRates, int years) {
        if (years == 0) return currentValue;
        
        double currentGrowth = growthRates[growthRates.length - years];
        double nextValue = currentValue * (1 + currentGrowth);
        return calculateFutureValue(nextValue, growthRates, years - 1);
    }
}
