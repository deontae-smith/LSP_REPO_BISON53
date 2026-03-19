package org.howard.edu.lsp.midterm.strategy;

/**
 * PriceCalculator uses a PricingStrategy to calculate final price.
 */
public class PriceCalculator {

    private PricingStrategy strategy;

    // Constructor to set the pricing strategy
    public PriceCalculator(PricingStrategy strategy) {
        this.strategy = strategy;
    }

    // Allow changing strategy dynamically
    public void setPricingStrategy(PricingStrategy strategy) {
        this.strategy = strategy;
    }

    // Calculate final price using the current strategy
    public double calculatePrice(double price) {
        return strategy.calculatePrice(price);
    }
}