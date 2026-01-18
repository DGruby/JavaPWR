import java.time.LocalDate;
import java.util.List;

/**
 * Generates formatted summary reports from patient visit records.
 * Calculates statistics including total records, date ranges, rejected rows,
 * and medication usage across all patient visits.
 */
public class ReportGenerator {

    /** List of valid patient visit records to analyze */
    private List<VisitRecord> visits;

    /** Number of rows rejected during CSV parsing due to invalid data */
    private int rejectedRows;

    /**
     * Constructs a ReportGenerator with visit records and rejection count.
     *
     * @param visits list of valid VisitRecord objects to include in the report
     * @param rejectedRows number of rows that were rejected during parsing
     */
    public ReportGenerator(List<VisitRecord> visits, int rejectedRows) {
        this.visits = visits;
        this.rejectedRows = rejectedRows;
    }

    /**
     * Generates and prints a formatted summary report to the console.
     * The report includes:
     * - Total number of valid records
     * - Number of rejected rows
     * - Date range of all visits (earliest to latest)
     * - Count of patients taking medications
     *
     * If no valid records exist, prints a message and returns early.
     */
    public void generateReport() {
        System.out.println("===== VISIT REPORT =====");
        System.out.println("Total valid records: " + visits.size());
        System.out.println("Rejected rows: " + rejectedRows);

        if (visits.isEmpty()) {
            System.out.println("No valid visit records available.");
            return;
        }

        // Find earliest and latest visit dates
        LocalDate earliest = visits.get(0).getDate();
        LocalDate latest = visits.get(0).getDate();

        int patientsWithDrugs = 0;

        // Iterate through all visits to calculate statistics
        for (VisitRecord visit : visits) {
            LocalDate date = visit.getDate();

            // Update date range
            if (date.isBefore(earliest)) {
                earliest = date;
            }
            if (date.isAfter(latest)) {
                latest = date;
            }

            // Count patients with medications
            if (visit.getMedications() != null && !visit.getMedications().isEmpty()) {
                patientsWithDrugs++;
            }
        }

        System.out.println("Date range: " + earliest + " to " + latest);
        System.out.println("Patients who took drugs: " + patientsWithDrugs);
        System.out.println("========================");
    }
}