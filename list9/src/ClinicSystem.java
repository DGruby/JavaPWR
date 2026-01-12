import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ClinicSystem implements ClinicOperations {

    private List<Appointment> appointments = new ArrayList<>();
    private List<Prescription> prescriptions = new ArrayList<>();

    // STAFF creates appointment
    @Override
    public boolean addAppointment(Patient patient, Doctor doctor, LocalDateTime dateTime) {

        for (Appointment a : appointments) {
            if (a.getDoctor().equals(doctor) &&
                    a.getDateTime().equals(dateTime)) {
                System.out.println("Appointment conflict: doctor unavailable.");
                return false;
            }
        }

        Appointment appointment = new Appointment(patient, doctor, dateTime);
        appointments.add(appointment);

        patient.addAppointment(appointment);
        doctor.addAppointment(appointment);

        return true;
    }

    @Override
    public void displayAppointmentsForPatient(Patient patient) {
        for (Appointment a : appointments) {
            if (a.getPatient().equals(patient)) {
                System.out.println(a);
            }
        }
    }

    @Override
    public void displayDoctorCalendar(Doctor doctor) {
        for (Appointment a : appointments) {
            if (a.getDoctor().equals(doctor)) {
                System.out.println(a);
            }
        }
    }

    // DOCTOR creates prescription
    @Override
    public void addPrescription(Prescription prescription) {
        prescriptions.add(prescription);
        prescription.getPatient().addPrescription(prescription);
    }

    @Override
    public void displayPrescriptionsForPatient(Patient patient) {
        for (Prescription p : prescriptions) {
            if (p.getPatient().equals(patient)) {
                System.out.println(p);
            }
        }
    }

    @Override
    public void displayPatientsWithActivePrescription(String medicine) {
        for (Prescription p : prescriptions) {
            if (p.isActive() && p.getTreatments().contains(medicine)) {
                System.out.println(
                        p.getPatient().getName() +
                                " – prescribed by Dr. " +
                                p.getDoctor().getName()
                );
            }
        }
    }
}

