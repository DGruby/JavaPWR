import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VisitRecord {
    private LocalDate date;
    private int patientsAge;
    private String patientsPhoneNumber;
    private List<String> medications;
    private String patientsEmail;
    private String doctorsName;

    public VisitRecord(String data) {
        medications = new ArrayList<>();

        // Date
        Matcher dateMatcher = Pattern
                .compile("^(\\d{4}-\\d{2}-\\d{2})")
                .matcher(data);
        if (dateMatcher.find()) {
            date = LocalDate.parse(dateMatcher.group(1));
        }

        // Age
        Matcher ageMatcher = Pattern
                .compile("Patient is (\\d+) years old")
                .matcher(data);
        if (ageMatcher.find()) {
            patientsAge = Integer.parseInt(ageMatcher.group(1));
        }

        // Medications (can be comma-separated)
        Matcher medsMatcher = Pattern
                .compile("Patient takes: (.*?)(?:, [A-Z][a-zA-Z ]*:)")
                .matcher(data);

        if (medsMatcher.find()) {
            String[] meds = medsMatcher.group(1).split("\\s*,\\s*");
            for (String med : meds) {
                medications.add(med);
            }
        }


        // Email
        Matcher emailMatcher = Pattern
                .compile("Email: ([^,]+)")
                .matcher(data);
        if (emailMatcher.find()) {
            patientsEmail = emailMatcher.group(1);
        }

        // Doctor
        Matcher doctorMatcher = Pattern
                .compile("Doctor: (.+)$")
                .matcher(data);
        if (doctorMatcher.find()) {
            doctorsName = doctorMatcher.group(1).replace(".", "");
        }
    }

    public LocalDate getDate() {
        return date;
    }

    public int getPatientsAge() {
        return patientsAge;
    }

    public String getPatientsPhoneNumber() {
        return patientsPhoneNumber;
    }

    public List<String> getMedications() {
        return medications;
    }

    public String getPatientsEmail() {
        return patientsEmail;
    }

    public String getDoctorsName() {
        return doctorsName;
    }

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
