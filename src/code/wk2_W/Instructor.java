package code.wk2_W;

public class Instructor {
    private String lastName;
    private String firstName;
    private String officeNumber;

    public Instructor() {
    }

    public Instructor(String lastName, String firstName, String officeNumber) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.officeNumber = officeNumber;
    }

    public Instructor(Instructor object2) {
        lastName = object2.lastName;
        firstName = object2.firstName;
        officeNumber = object2.officeNumber;
    }

    // 把一个一个 set 整合成一起 set 了
    public void set(String lastName, String firstName, String officeNumber) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.officeNumber = officeNumber;
    }

    @Override
    public String toString() {

        String str = "Instructor{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", officeNumber='" + officeNumber + '\'' +
                '}';
        return str;
    }
}
