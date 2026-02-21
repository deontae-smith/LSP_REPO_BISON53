package org.howard.edu.lsp.assignment3;

import java.io.*;
import java.math.BigDecimal;

public class CSVProcessor {
	   private static final String HEADER =
	            "ProductID,Name,Price,Category,PriceRange";

	    private String inputFile;
	    private String outputFile;
	    private ETLSummary summary;

	    public CSVProcessor(String inputFile, String outputFile, ETLSummary summary) {
	        this.inputFile = inputFile;
	        this.outputFile = outputFile;
	        this.summary = summary;
	    }

	    public void process() {

	        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
	             PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {

	            String headerLine = reader.readLine();

	            writer.println(HEADER);

	            if (headerLine == null) {
	                return;
	            }

	            String line;

	            while ((line = reader.readLine()) != null) {
	                summary.incrementRead();

	                if (line.trim().isEmpty()) {
	                    summary.incrementSkipped();
	                    continue;
	                }

	                String[] fields = line.split(",", -1);

	                if (fields.length != 4) {
	                    summary.incrementSkipped();
	                    continue;
	                }

	                for (int i = 0; i < fields.length; i++) {
	                    fields[i] = fields[i].trim();
	                }

	                Product product = parseProduct(fields);

	                if (product == null) {
	                    summary.incrementSkipped();
	                    continue;
	                }

	                Product transformed = ProductTransformer.transform(product);
	                String priceRange = ProductTransformer.calculatePriceRange(
	                        transformed.getPrice()
	                );

	                writer.printf("%d,%s,%.2f,%s,%s%n",
	                        transformed.getProductId(),
	                        transformed.getName(),
	                        transformed.getPrice(),
	                        transformed.getCategory(),
	                        priceRange);

	                summary.incrementTransformed();
	            }

	        } catch (IOException e) {
	            System.err.println("Error: Failed to process files - " + e.getMessage());
	            System.exit(1);
	        }
	    }

	    private Product parseProduct(String[] fields) {

	        try {
	            int id = Integer.parseInt(fields[0]);
	            BigDecimal price = new BigDecimal(fields[2]);
	            return new Product(id, fields[1], price, fields[3]);
	        } catch (NumberFormatException e) {
	            return null;
	        }
	    }

}
