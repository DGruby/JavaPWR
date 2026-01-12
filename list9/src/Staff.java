import java.time.LocalDateTime;

public abstract class Staff extends Person {

    private String role;   // OK to keep private
    public abstract void performDuties();

    public Staff(String name, int age, String role) {
        super(name, age);
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // A member of Staff can create an appointment for a patient
    public boolean createAppointment(
            ClinicOperations clinic,
            Patient patient,
            Doctor doctor,
            LocalDateTime dateTime) {

        return clinic.addAppointment(patient, doctor, dateTime);
    }
}

