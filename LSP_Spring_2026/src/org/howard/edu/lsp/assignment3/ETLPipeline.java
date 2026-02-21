package org.howard.edu.lsp.assignment3;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class ETLPipeline {
	
	  private static final String INPUT_FILE = "data/products.csv";
	    private static final String OUTPUT_FILE = "data/transformed_products.csv";

	    public static void main(String[] args) {

	        File inputFile = new File(INPUT_FILE);

	        if (!inputFile.exists()) {
	            System.err.println("Input file error, please check file");
	            System.exit(1);
	        }

	        try {
	            Files.createDirectories(Paths.get("data"));
	        } catch (IOException e) {
	            System.err.println("Could not create data directory.");
	            System.exit(1);
	        }

	        ETLSummary summary = new ETLSummary();
	        CSVProcessor processor = new CSVProcessor(INPUT_FILE, OUTPUT_FILE, summary);
	        processor.process();

	        summary.printSummary(OUTPUT_FILE);
	    }

}
