public class Receptionist extends Staff {

    public void performDuties(){
        System.out.println("Receptionist performs her duties.");
    }

    public Receptionist(String name, int age) {
        setName(name);
        setAge(age);
        setRole("Receptionist");
    }
}
