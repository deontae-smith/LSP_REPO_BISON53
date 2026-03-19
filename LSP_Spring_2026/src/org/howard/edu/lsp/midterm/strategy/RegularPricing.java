package org.howard.edu.lsp.midterm.strategy;

/**
 * No discount for regular customers.
 */
public class RegularPricing implements PricingStrategy {

    @Override
    public double calculatePrice(double price) {
        return price;
    }
}