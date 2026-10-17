package java112.analyzer;

import java.io.*;
import java.util.*;
/**
 * Analyzes a file and keeps track of the total number of tokens.
 *
 * @author Omar Elghadban
 */

public class FileSummaryAnalyzer implements TokenAnalyzer {

    /** The total number of tokens processed. */
    private int totalTokensCount;

    /**
     * Creates a new FileSummaryAnalyzer.
     */
    public FileSummaryAnalyzer() {
    }

    /**
     * Gets the total number of tokens processed.
     *
     * @return the total number of tokens
     */

    public int getTotalTokensCount() {
        return totalTokensCount;
    }

    /**
     * Processes a single token by increasing the total token count.
     *
     * @param token the token to process
     */
    
    public void processToken(String token) {
        totalTokensCount++;
    }

    /**
     * Generates the summary output file.
     *
     * @param inputFilePath path to the input file
     * @param outputFilePath path to the output file
     */
    
    public void generateOutputFile(String inputFilePath, String outputFilePath) {
        File inputFile = new File(inputFilePath);

        try (PrintWriter output = new PrintWriter(new FileWriter(outputFilePath))) {

            output.println("Application: The Analyzer");
            output.println("Author: Omar Elghadban");
            output.println("Author email: oelghadban1@madisoncollege.edu");
            output.println("File: " + inputFile.getAbsolutePath());
            output.println("Date of analysis: " + new Date());
            output.println("Last Modified: " + new Date(inputFile.lastModified()));
            output.println("File Size: " + inputFile.length());
            output.println("File URI: " + inputFile.toURI());
            output.println("Total Tokens: " + totalTokensCount);


        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}