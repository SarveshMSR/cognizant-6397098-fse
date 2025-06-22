public class TestForecasting {
    public static void main(String[] args) {
        double initialInvestment = 10000;
        double[] growthRates = {0.05, 0.07, 0.06}; // 3-year growth rates
        
        // Recursive calculation
        double futureValue = FinancialForecaster.calculateFutureValue(
            initialInvestment, growthRates, growthRates.length
        );
        
        System.out.println("Initial Investment: $" + initialInvestment);
        System.out.println("Growth Rates: " + java.util.Arrays.toString(growthRates));
        System.out.printf("Projected Value after %d years: $%.2f%n", 
                          growthRates.length, futureValue);
    }
}
