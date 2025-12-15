public class Receptionist extends Staff {

    public void performDuties(){
        System.out.println("Receptionist performs her duties.");
    }

    public Receptionist(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
