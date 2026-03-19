package org.howard.edu.lsp.midterm.strategy;

/**
 * 20% discount for VIP customers.
 */
public class VipPricing implements PricingStrategy {

    @Override
    public double calculatePrice(double price) {
        return price * 0.80;
    }
}