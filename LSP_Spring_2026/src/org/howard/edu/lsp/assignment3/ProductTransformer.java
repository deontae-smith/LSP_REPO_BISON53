package org.howard.edu.lsp.assignment3;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ProductTransformer {

    public static Product transform(Product product) {

        String transformedName = product.getName().toUpperCase();

        BigDecimal transformedPrice = transformPrice(
                product.getPrice(),
                product.getCategory()
        );

        String transformedCategory = transformCategory(
                product.getCategory(),
                transformedPrice
        );

        return new Product(
                product.getProductId(),
                transformedName,
                transformedPrice,
                transformedCategory
        );
    }

    private static BigDecimal transformPrice(BigDecimal price, String category) {
        BigDecimal result = price;

        if ("Electronics".equalsIgnoreCase(category.trim())) {
            result = price.multiply(new BigDecimal("0.90"));
        }

        return result.setScale(2, RoundingMode.HALF_UP);
    }

    private static String transformCategory(String category, BigDecimal finalPrice) {
        if ("Electronics".equalsIgnoreCase(category.trim()) &&
                finalPrice.compareTo(new BigDecimal("500.00")) > 0) {
            return "Premium Electronics";
        }
        return category;
    }

    public static String calculatePriceRange(BigDecimal price) {
        if (price.compareTo(new BigDecimal("10.00")) <= 0) {
            return "Low";
        } else if (price.compareTo(new BigDecimal("100.00")) <= 0) {
            return "Medium";
        } else if (price.compareTo(new BigDecimal("500.00")) <= 0) {
            return "High";
        } else {
            return "Premium";
        }
    }
}