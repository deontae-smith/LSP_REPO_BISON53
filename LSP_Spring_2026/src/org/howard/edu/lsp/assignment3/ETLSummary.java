package org.howard.edu.lsp.assignment3;

public class ETLSummary {
	 private int rowsRead = 0;
	    private int rowsTransformed = 0;
	    private int rowsSkipped = 0;

	    public void incrementRead() { rowsRead++; }
	    public void incrementTransformed() { rowsTransformed++; }
	    public void incrementSkipped() { rowsSkipped++; }

	    public void printSummary(String outputFile) {
	        System.out.println("\n=== ETL Process Summary ===");
	        System.out.println("Rows read: " + rowsRead);
	        System.out.println("Rows transformed: " + rowsTransformed);
	        System.out.println("Rows skipped: " + rowsSkipped);
	        System.out.println("Output file: " + outputFile);
	    }

}
