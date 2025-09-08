public class Person {
    // three string fields
    private String firstName;
    private String lastName;
    private String id;

    // constructor
    public Person(String firstName, String lastName, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    // getters
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getId() { return id; }

    // toString prints out person info
    public String toString() {
        return id + " " + firstName + " " + lastName;
    }
}