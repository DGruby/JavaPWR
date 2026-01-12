
import java.util.List;
import java.util.ArrayList;
public class Patient extends Person implements Treatable {
    private List<Appointment> appointments = new ArrayList<>();
    private List<Prescription> prescriptions = new ArrayList<>();

    public void addAppointment(Appointment a) {
        appointments.add(a);
    }

    public void addPrescription(Prescription p) {
        prescriptions.add(p);
    }


    @Override
    public void receiveTreatment() {
        System.out.println("Patient received treatment");
    }

    public Patient(String name, int age) {
        super(name, age);
    }
}
