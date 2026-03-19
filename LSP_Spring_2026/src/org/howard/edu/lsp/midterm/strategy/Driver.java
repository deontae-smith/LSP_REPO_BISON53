package org.howard.edu.lsp.midterm.strategy;

public class Driver {
    public static void main(String[] args) {
        double purchasePrice = 100.0;

        // REGULAR customer
        PriceCalculator calculator = new PriceCalculator(new RegularPricing());
        System.out.println("REGULAR: " + calculator.calculatePrice(purchasePrice));

        // MEMBER customer
        calculator.setPricingStrategy(new MemberPricing());
        System.out.println("MEMBER: " + calculator.calculatePrice(purchasePrice));

        // VIP customer
        calculator.setPricingStrategy(new VipPricing());
        System.out.println("VIP: " + calculator.calculatePrice(purchasePrice));

        // HOLIDAY customer
        calculator.setPricingStrategy(new HolidayPricing());
        System.out.println("HOLIDAY: " + calculator.calculatePrice(purchasePrice));
    }
}