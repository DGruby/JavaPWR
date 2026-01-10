public class Doctor extends Staff {
    @Override
    public void performDuties() {
        System.out.println("Doctor performs his duties");
    }

    public void prescribeMedicine(String medicine) {
        System.out.println("Doctor prescribes medicine: " + medicine);
    }

    public Doctor(String name, int age) {
        setName(name);
        setAge(age);
        setRole("Doctor");
    }
}
