public class Nurse extends Staff {
    public void performDuties(){
        System.out.println("Nurse performs her duties.");
    }
    public void checkVitals(Patient patient){
        System.out.println("Nurse checks vitals. of a patient " + patient.getName());
    }

    public Nurse(String name, int age) {
        super(name, age, "Nurse");
    }


}
