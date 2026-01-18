import java.io.IOException;
import java.util.List;

/**
 * Main driver class for the Patient Visit Records Parser application.
 * Demonstrates the processing of patient visit data from a CSV file,
 * generating summary statistics, and displaying individual visit records.
 */
public class Main {

    /**
     * Entry point of the application.
     * Loads patient visit data from a CSV file, processes and cleans the data,
     * generates a statistical report, and prints all individual visit records.
     *
     * @param args command line arguments (not used)
     * @throws RuntimeException if the CSV file cannot be read
     */
    public static void main(String[] args) {
        CSVProcessor processor;
        ReportGenerator reportGenerator;

        // Load and process the CSV file
        try {
            processor = new CSVProcessor("/Users/poczt1/Desktop/intro to programming/JavaPWR/list10/src/Data/data.csv");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Extract processed data
        List<VisitRecord> visits = processor.getVisits();
        int emptyLines = processor.getEmptyLinesRemoved();

        // Generate and display summary report
        reportGenerator = new ReportGenerator(visits, emptyLines);
        reportGenerator.generateReport();

        // Print detailed information for each visit record
        for(VisitRecord visitRecord : visits) {
            System.out.println(visitRecord.toString());
        }
    }
}