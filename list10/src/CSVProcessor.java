import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Processes CSV files containing patient visit data.
 * Handles file reading, data cleaning (removing quotes and empty lines),
 * and creation of VisitRecord objects from cleaned text data.
 */
public class CSVProcessor {

    /** List of cleaned, non-empty lines from the CSV file */
    private List<String> cleanedLines;

    /** List of VisitRecord objects created from the cleaned data */
    private List<VisitRecord> visits;

    /** Counter for the number of empty lines removed during processing */
    private int emptyLinesRemoved;

    /**
     * Constructs a CSVProcessor and immediately processes the specified file.
     * Reads the file, removes empty lines and quotation marks, and creates
     * VisitRecord objects from the valid data.
     *
     * @param filePath the path to the CSV file to process
     * @throws IOException if the file cannot be read or does not exist
     */
    public CSVProcessor(String filePath) throws IOException {
        cleanedLines = new ArrayList<>();
        visits = new ArrayList<>();
        emptyLinesRemoved = 0;

        loadAndCleanFile(filePath);
        createVisitRecords();
    }

    /**
     * Loads the CSV file and cleans the data by removing quotes and empty lines.
     * Increments the empty line counter for each blank line encountered.
     * Valid lines are stored in the cleanedLines list.
     *
     * @param filePath the path to the CSV file
     * @throws IOException if the file cannot be read
     */
    private void loadAndCleanFile(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;

        // Read file line by line
        while ((line = reader.readLine()) != null) {
            // Remove surrounding quotes and whitespace
            line = line.replace("\"", "").trim();

            if (line.isEmpty()) {
                emptyLinesRemoved++;
            } else {
                cleanedLines.add(line);
            }
        }

        reader.close();
    }

    /**
     * Creates VisitRecord objects from each cleaned line.
     * Each line is parsed by the VisitRecord constructor to extract
     * patient information using regular expressions.
     */
    private void createVisitRecords() {
        for (String line : cleanedLines) {
            visits.add(new VisitRecord(line));
        }
    }

    // ----- GETTERS -----

    /**
     * Gets the list of cleaned text lines from the CSV file.
     *
     * @return list of non-empty, cleaned data lines
     */
    public List<String> getCleanedLines() {
        return cleanedLines;
    }

    /**
     * Gets the list of VisitRecord objects created from the data.
     *
     * @return list of parsed VisitRecord objects
     */
    public List<VisitRecord> getVisits() {
        return visits;
    }

    /**
     * Gets the count of empty lines that were removed during processing.
     *
     * @return number of empty lines removed from the CSV file
     */
    public int getEmptyLinesRemoved() {
        return emptyLinesRemoved;
    }
}