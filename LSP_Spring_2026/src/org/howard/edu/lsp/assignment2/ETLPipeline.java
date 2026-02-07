package org.howard.edu.lsp.assignment2;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.*;

public class ETLPipeline {
    
    private static final String INPUT_FILE = "data/products.csv";
    private static final String OUTPUT_FILE = "data/transformed_products.csv";
    private static final String HEADER = "ProductID,Name,Price,Category,PriceRange";
    
    public static void main(String[] args) {
        int rowsRead = 0;
        int rowsTransformed = 0;
        int rowsSkipped = 0;
        
        File inputFile = new File(INPUT_FILE);
       
//        if (!inputFile.exists()) {
//            System.err.println("Input file error");
//            System.exit(1);
//        }
        
 
        try {
            Files.createDirectories(Paths.get("data"));
        } catch (IOException e) {
            System.err.println("Could not create data directory.");
            System.exit(1);
        }
        
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILE));
             PrintWriter writer = new PrintWriter(new FileWriter(OUTPUT_FILE))) {
            
            String headerLine = reader.readLine();
            if (headerLine == null) {
                writer.println(HEADER);
                printSummary(rowsRead, rowsTransformed, rowsSkipped);
                return;
            }
            
            
            writer.println(HEADER);
            
            String line;
            while ((line = reader.readLine()) != null) {
                rowsRead++;
                
                if (line.trim().isEmpty()) {
                    rowsSkipped++;
                    continue;
                }
                
                
                String[] fields = line.split(",", -1);
                
                if (fields.length != 4) {
                    rowsSkipped++;
                    continue;
                }
                
                for (int i = 0; i < fields.length; i++) {
                    fields[i] = fields[i].trim();
                }
                
                int productId;
                try {
                    productId = Integer.parseInt(fields[0]);
                } catch (NumberFormatException e) {
                    rowsSkipped++;
                    continue;
                }
                
                String name = fields[1];
                
                BigDecimal price;
                try {
                    price = new BigDecimal(fields[2]);
                } catch (NumberFormatException e) {
                    rowsSkipped++;
                    continue;
                }
                
                String category = fields[3];
                
                String transformedName = transformName(name);
                BigDecimal transformedPrice = transformPrice(price, category);
                String transformedCategory = transformCategory(category, transformedPrice);
                String priceRange = calculatePriceRange(transformedPrice);
                
                writer.printf("%d,%s,%.2f,%s,%s%n",
                    productId,
                    transformedName,
                    transformedPrice,
                    transformedCategory,
                    priceRange);
                
                rowsTransformed++;
            }
            
        } catch (IOException e) {
            System.err.println("Error: Failed to process files - " + e.getMessage());
            System.exit(1);
        }
        
        printSummary(rowsRead, rowsTransformed, rowsSkipped);
    }
    
    private static String transformName(String name) {
        return name.toUpperCase();
    }
    
    private static BigDecimal transformPrice(BigDecimal price, String category) {
        BigDecimal transformedPrice = price;
        
        if ("Electronics".equalsIgnoreCase(category.trim())) {
            transformedPrice = price.multiply(new BigDecimal("0.90"));
        }
        
        return transformedPrice.setScale(2, RoundingMode.HALF_UP);
    }
    
    private static String transformCategory(String originalCategory, BigDecimal finalPrice) {
        if ("Electronics".equalsIgnoreCase(originalCategory.trim()) && 
            finalPrice.compareTo(new BigDecimal("500.00")) > 0) {
            return "Premium Electronics";
        }
        return originalCategory;
    }
    
    private static String calculatePriceRange(BigDecimal price) {
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
    
    private static void printSummary(int rowsRead, int rowsTransformed, int rowsSkipped) {
        System.out.println("\n=== ETL Process Summary ===");
        System.out.println("Rows read: " + rowsRead);
        System.out.println("Rows transformed: " + rowsTransformed);
        System.out.println("Rows skipped: " + rowsSkipped);
        System.out.println("Output file: " + OUTPUT_FILE);
    }
}
