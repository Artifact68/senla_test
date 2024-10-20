package currencyconverter;

import java.util.Scanner;
import java.util.HashMap;

public class CurrencyConverter {

    private static final HashMap<String, Double> exchangeRates = new HashMap<>();

    static {
        exchangeRates.put("EUR", 0.92);
        exchangeRates.put("GBP", 0.81);
        exchangeRates.put("AUD", 1.43);
        exchangeRates.put("JPY", 148.15);
        exchangeRates.put("INR", 82.64);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the amount in USD: ");
        double amountInUsd = scanner.nextDouble();
        scanner.nextLine();  // Clear the buffer

        System.out.print("Enter the currency to convert to (EUR, GBP, AUD, JPY, INR): ");
        String currency = scanner.nextLine().toUpperCase();

        if (exchangeRates.containsKey(currency)) {
            double convertedAmount = convertCurrency(amountInUsd, exchangeRates.get(currency));
            System.out.printf("Amount in %s: %.2f%n", currency, convertedAmount);
        } else {
            System.out.println("Sorry, we don't support that currency.");
        }

        scanner.close();
    }

    private static double convertCurrency(double amount, double rate) {
        return amount * rate;
    }
}
