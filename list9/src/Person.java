public abstract class Person {
    private int age;
    private String name;

    public void introduce() {
        System.out.println(name + ", " + age + " years old.");
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

}