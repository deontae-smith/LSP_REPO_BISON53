package org.howard.edu.lsp.midterm.strategy;

/**
 * 15% discount for holiday promotion.
 */
public class HolidayPricing implements PricingStrategy {

    @Override
    public double calculatePrice(double price) {
        return price * 0.85;
    }
}