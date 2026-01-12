public class Receptionist extends Staff {

    @Override
    public void performDuties(){
        System.out.println("Receptionist performs her duties.");
    }

    public Receptionist(String name, int age) {
        super(name, age, "Receptionist");
    }
}
