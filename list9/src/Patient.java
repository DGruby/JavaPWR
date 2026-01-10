public class Patient extends Person implements Treatable {
    @Override
    public void receiveTreatment() {
        System.out.println("Patient received treatment");
    }

    public Patient(String name, int age) {
        setName(name);
        setAge(age);
    }
}
