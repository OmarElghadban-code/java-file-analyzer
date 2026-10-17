package java112.analyzer;

import java.io.*;

/**
 * Coordinates the file analysis process.
 *
 * @author Omar Elghadban
 */

public class FileAnalysis {

    /** The number of command-line arguments required. */
    private static final int VALID_ARGS = 1;

    /** Analyzes the total number of tokens. */
    private FileSummaryAnalyzer summaryAnalyzer;

    /** Analyzes the distinct tokens. */
    private DistinctTokensAnalyzer distinctAnalyzer;

    /**
     * Analyzes the input file.
     *
     * @param arguments command-line arguments
     */

    public void analyze(String[] arguments) {
        if (arguments.length != VALID_ARGS) {
            System.out.println("Please enter one argument on the command line.");
            return;
        
        }

        createAnalyzers();
        openInputFile(arguments[0]);
        writeOutputFiles(arguments[0]);
    }

    /**
     * Creates the analyzer objects.
     */

    private void createAnalyzers() {
        summaryAnalyzer = new FileSummaryAnalyzer();
        distinctAnalyzer = new DistinctTokensAnalyzer();
    }

    /**
     * Opens the input file for reading.
     *
     * @param filePath path to the input file
     */

    private void openInputFile(String filePath) {
        try (BufferedReader input =
                new BufferedReader(new FileReader(filePath))) {
            
            readInputFile(input);

        } catch (FileNotFoundException exception) {
            System.out.println("The file, " + filePath
                    + ", was not found. Please verify the file exists.");

            exception.printStackTrace();

        } catch (IOException exception) {
            System.out.println("There was a problem reading the file: "
                    + filePath);

            exception.printStackTrace();
        }

    }

   /**
    * Reads through the input file.
    *
    * @param input the BufferedReader for the input file
    * @throws IOException if an error occurs while reading the file
    */

    private void readInputFile(BufferedReader input) throws IOException {
        String line;

        while ((line = input.readLine()) != null) {
            String[] tokenArray = line.split("\\W");

            processTokenArray(tokenArray);
        }
    }

    /**
     * Processes the tokens from one line of the input file.
     *
     * @param tokenArray array of tokens to process
     */

    private void processTokenArray(String[] tokenArray) {
        for (String token : tokenArray) {
            if (!token.isEmpty()) {
                summaryAnalyzer.processToken(token);
                distinctAnalyzer.processToken(token);
            }
        }
    }

    /**
     * Generates the output files.
     *
     * @param inputFilePath path to the input file
     */
    
    private void writeOutputFiles(String inputFilePath) {
         summaryAnalyzer.generateOutputFile(
                inputFilePath, "output/summary.txt");

        distinctAnalyzer.generateOutputFile(
                inputFilePath, "output/distinct_tokens.txt");
    }
}