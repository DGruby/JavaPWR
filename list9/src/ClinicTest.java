import java.time.LocalDateTime;

public class ClinicTest {
    public static void main(String[] args) {

        // SYSTEM (USE INTERFACE)
        ClinicOperations clinic = new ClinicSystem();

        // PEOPLE
        Patient patient = new Patient("Marek", 26);
        Doctor doctor = new Doctor("George", 60);
        Receptionist receptionist = new Receptionist("Sara", 30);
        Nurse nurse = new Nurse("Joanna", 40);

        // BASIC INTRO
        patient.introduce();
        doctor.introduce();
        receptionist.introduce();
        nurse.introduce();
        System.out.println();

        // APPOINTMENTS (CREATED BY STAFF)
        LocalDateTime time1 = LocalDateTime.of(2025, 1, 10, 10, 0);
        LocalDateTime time2 = LocalDateTime.of(2025, 1, 10, 10, 0); // overlap

        receptionist.createAppointment(clinic, patient, doctor, time1);
        receptionist.createAppointment(clinic, patient, doctor, time2); // should fail

        System.out.println("\nPatient appointments:");
        clinic.displayAppointmentsForPatient(patient);

        System.out.println("\nDoctor calendar:");
        clinic.displayDoctorCalendar(doctor);

        // PRESCRIPTIONS (CREATED BY DOCTOR)
        Prescription prescription = doctor.createPrescription(patient);
        prescription.addTreatment("Naloxone");
        prescription.addTreatment("Physiotherapy");

        clinic.addPrescription(prescription);

        System.out.println("\nPatients with Naloxone prescription:");
        clinic.displayPatientsWithActivePrescription("Naloxone");
    }
}


