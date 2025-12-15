public class ClinicTest {
    public static void main(String[] args) {
        //create getters and setters for name, age?
        Patient patient = new Patient("Marek", 26);
        patient.introduce();
        patient.receiveTreatment();
        System.out.println();

        Doctor doctor = new Doctor("George", 60);
        doctor.introduce();
        doctor.performDuties();
        doctor.prescribeMedicine("Naloxone");
        System.out.println();

        Receptionist receptionist = new Receptionist("Sara", 30);
        receptionist.introduce();
        receptionist.performDuties();
        System.out.println();

        Nurse nurse = new Nurse("Joanna", 40);
        nurse.introduce();
        nurse.performDuties();
        nurse.checkVitals(patient);
        System.out.println();

    }
}
