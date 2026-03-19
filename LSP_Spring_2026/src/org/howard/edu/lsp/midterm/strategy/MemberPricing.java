package org.howard.edu.lsp.midterm.strategy;

/**
 * 10% discount for members.
 */
public class MemberPricing implements PricingStrategy {

    @Override
    public double calculatePrice(double price) {
        return price * 0.90;
    }
}