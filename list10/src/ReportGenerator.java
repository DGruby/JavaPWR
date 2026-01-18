import java.time.LocalDate;
import java.util.List;

public class ReportGenerator {

    private List<VisitRecord> visits;
    private int rejectedRows;

    public ReportGenerator(List<VisitRecord> visits, int rejectedRows) {
        this.visits = visits;
        this.rejectedRows = rejectedRows;
    }

    public void generateReport() {
        System.out.println("===== VISIT REPORT =====");
        System.out.println("Total valid records: " + visits.size());
        System.out.println("Rejected rows: " + rejectedRows);

        if (visits.isEmpty()) {
            System.out.println("No valid visit records available.");
            return;
        }

        LocalDate earliest = visits.get(0).getDate();
        LocalDate latest = visits.get(0).getDate();

        int patientsWithDrugs = 0;

        for (VisitRecord visit : visits) {
            LocalDate date = visit.getDate();

            if (date.isBefore(earliest)) {
                earliest = date;
            }
            if (date.isAfter(latest)) {
                latest = date;
            }

            if (visit.getMedications() != null && !visit.getMedications().isEmpty()) {
                patientsWithDrugs++;
            }
        }

        System.out.println("Date range: " + earliest + " to " + latest);
        System.out.println("Patients who took drugs: " + patientsWithDrugs);
        System.out.println("========================");
    }
}
