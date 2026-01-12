import java.util.List;
import java.util.ArrayList;

public class Doctor extends Staff {
    private List<Appointment> appointments = new ArrayList<>();

    public Doctor(String name, int age) {
        super(name, age, "Doctor");
    }

    public void addAppointment(Appointment a) {
        appointments.add(a);
    }

    @Override
    public void performDuties() {
        System.out.println("Doctor performs his duties");
    }

    public Prescription createPrescription(Patient patient) {
        return new Prescription(this, patient);
    }
}
