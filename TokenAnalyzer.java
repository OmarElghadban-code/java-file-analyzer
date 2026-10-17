package java112.analyzer;

/**
 * Defines the methods that an analyzer must implement.
 *
 * @author Omar Elghadban
 */

public interface TokenAnalyzer {

    /**
     * Processes a single token.
     *
     * @param token the token to process
     */
    void processToken(String token);

    /**
     * Generates an output file containing the analysis results.
     *
     * @param inputFilePath path to the input file
     * @param outputFilePath path to the output file
     */
    void generateOutputFile(String inputFilePath, String outputFilePath);
}