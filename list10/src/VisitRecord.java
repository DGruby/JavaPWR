import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Represents a single patient visit record extracted from CSV data.
 * Uses regular expressions to parse visit date, patient age, medications,
 * contact information, and doctor details from unstructured text descriptions.
 */
public class VisitRecord {
    /** The date of the patient visit in YYYY-MM-DD format */
    private LocalDate date;

    /** The patient's age in years */
    private int patientsAge;

    /** The patient's cell phone number */
    private String patientsPhoneNumber;

    /** List of medications the patient is taking */
    private List<String> medications;

    /** The patient's email address */
    private String patientsEmail;

    /** The name of the doctor who performed the visit (Surname, Name format) */
    private String doctorsName;

    /**
     * Constructs a VisitRecord by parsing a raw CSV data string.
     * Extracts date, age, medications, email, and doctor information using regex patterns.
     * Fields that cannot be found in the data will remain null or empty.
     *
     * @param data the raw CSV line containing patient visit information
     */
    public VisitRecord(String data) {
        medications = new ArrayList<>();

        // Date - matches YYYY-MM-DD pattern at start of string
        Matcher dateMatcher = Pattern
                .compile("^(\\d{4}-\\d{2}-\\d{2})")
                .matcher(data);
        if (dateMatcher.find()) {
            date = LocalDate.parse(dateMatcher.group(1));
        }

        // Age - matches "Patient is XX years old" pattern
        Matcher ageMatcher = Pattern
                .compile("Patient is (\\d+) years old")
                .matcher(data);
        if (ageMatcher.find()) {
            patientsAge = Integer.parseInt(ageMatcher.group(1));
        }

        // Medications - matches comma-separated list after "Patient takes:"
        Matcher medsMatcher = Pattern
                .compile("Patient takes: (.*?)(?:, [A-Z][a-zA-Z ]*:)")
                .matcher(data);

        if (medsMatcher.find()) {
            String[] meds = medsMatcher.group(1).split("\\s*,\\s*");
            for (String med : meds) {
                medications.add(med);
            }
        }

        // Email - matches "Email: " followed by email address
        Matcher emailMatcher = Pattern
                .compile("Email: ([^,]+)")
                .matcher(data);
        if (emailMatcher.find()) {
            patientsEmail = emailMatcher.group(1);
        }

        // Doctor - matches "Doctor: " followed by name until end of line
        Matcher doctorMatcher = Pattern
                .compile("Doctor: (.+)$")
                .matcher(data);
        if (doctorMatcher.find()) {
            doctorsName = doctorMatcher.group(1).replace(".", "");
        }
    }

    /**
     * Gets the date of the visit.
     *
     * @return the visit date, or null if not found
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Gets the patient's age.
     *
     * @return the patient's age in years, or 0 if not found
     */
    public int getPatientsAge() {
        return patientsAge;
    }

    /**
     * Gets the patient's phone number.
     *
     * @return the patient's phone number, or null if not found
     */
    public String getPatientsPhoneNumber() {
        return patientsPhoneNumber;
    }

    /**
     * Gets the list of medications the patient is taking.
     *
     * @return list of medication names, empty list if none found
     */
    public List<String> getMedications() {
        return medications;
    }

    /**
     * Gets the patient's email address.
     *
     * @return the patient's email, or null if not found
     */
    public String getPatientsEmail() {
        return patientsEmail;
    }

    /**
     * Gets the doctor's name who performed the visit.
     *
     * @return the doctor's name in "Surname, Name" format, or null if not found
     */
    public String getDoctorsName() {
        return doctorsName;
    }

    /**
     * Returns a string representation of the visit record.
     *
     * @return formatted string containing all visit record fields
     */
    @Override
    public String toString() {
        return "VisitRecord{" +
                "date=" + date +
                ", patientsAge=" + patientsAge +
                ", patientsPhoneNumber='" + patientsPhoneNumber + '\'' +
                ", medications=" + medications +
                ", patientsEmail='" + patientsEmail + '\'' +
                ", doctorsName='" + doctorsName + '\'' +
                '}';
    }
}