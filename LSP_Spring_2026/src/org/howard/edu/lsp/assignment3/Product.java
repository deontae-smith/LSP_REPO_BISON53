package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;


public class Product {
    private int productId;
    private String name;
    private BigDecimal price;
    private String category;

    public Product(int productId, String name, BigDecimal price, String category) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public int getProductId() { return productId; }
    public String getName() { return name; }
    public BigDecimal getPrice() { return price; }
    public String getCategory() { return category; }
}
