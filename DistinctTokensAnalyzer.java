package java112.analyzer;

import java.util.*;
import java.io.*;

/**
 * Analyzes a file and keeps track of distinct tokens.
 *
 * @author Omar Elghadban
 */

public class DistinctTokensAnalyzer implements TokenAnalyzer {

    /** The set of distinct tokens. */
    private Set<String> distinctTokens;

    /**
     * Creates a new DistinctTokensAnalyzer.
     */

    public DistinctTokensAnalyzer() {
        distinctTokens = new TreeSet<>();
    }


    /**
     * Gets the set of distinct tokens.
     *
     * @return the set of distinct tokens
     */

    public Set<String> getDistinctTokens() {
        return distinctTokens;
    }

    /**
     * Adds a token to the set of distinct tokens.
     * Duplicate tokens are not added to the set.
     *
     * @param token the token to process
    */
    
    public void processToken(String token) {
        distinctTokens.add(token);
    }

    /**
     * Generates the distinct tokens output file.
     *
     * @param inputFilePath path to the input file
     * @param outputFilePath path to the output file
     */
    
    public void generateOutputFile(String inputFilePath, String outputFilePath) {
        try (PrintWriter output = new PrintWriter(new FileWriter(outputFilePath))) {

            for (String token : distinctTokens) {
                output.println(token);
            }

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

}