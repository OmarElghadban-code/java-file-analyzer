package java112.analyzer;

/**
 * Starts the Analyzer program.
 *
 * @author Omar Elghadban
 */
public class Driver {

    /**
     * Creates a FileAnalysis object and starts the analysis.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        FileAnalysis analysis = new FileAnalysis();
        analysis.analyze(args);
    }
}