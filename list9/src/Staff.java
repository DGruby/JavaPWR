public abstract class Staff extends Person {
    private String role; //should be private? never used
    public abstract void performDuties();

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
}
