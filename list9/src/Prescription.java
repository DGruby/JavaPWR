import java.util.ArrayList;
import java.util.List;

public class Prescription {
    private Doctor doctor;
    private Patient patient;
    private List<String> treatments;
    private boolean active;

    public Prescription(Doctor doctor, Patient patient) {
        this.doctor = doctor;
        this.patient = patient;
        this.treatments = new ArrayList<>();
        this.active = true;
    }

    public void addTreatment(String treatment) {
        treatments.add(treatment);
    }

    public List<String> getTreatments() {
        return treatments;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public boolean isActive() {
        return active;
    }

    public void deactivate() {
        active = false;
    }

    @Override
    public String toString() {
        return "Prescription by Dr. " + doctor.getName() +
                " for " + patient.getName() +
                ", Treatments: " + treatments;
    }
}

