public class Nurse extends Staff {
    public void performDuties(){
        System.out.println("Nurse performs her duties.");
    }
    public void checkVitals(Patient patient){
        System.out.println("Nurse checks vitals. of a patient " + patient.name);
    }

    public Nurse(String name, int age) {
        this.name = name;
        this.age = age;
    }


}
