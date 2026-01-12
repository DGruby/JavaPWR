public interface ClinicOperations {

    // Appointments
    boolean addAppointment(Patient patient, Doctor doctor, java.time.LocalDateTime dateTime);
    void displayAppointmentsForPatient(Patient patient);
    void displayDoctorCalendar(Doctor doctor);

    // Prescriptions
    void addPrescription(Prescription prescription);
    void displayPrescriptionsForPatient(Patient patient);


    // Queries
    void displayPatientsWithActivePrescription(String medicine);
}

