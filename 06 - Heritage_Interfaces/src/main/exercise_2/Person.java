package main.exercise_2;

public class Person {
// ATTRIBUTES
    private String firstName, lastName;

// CONSTRUCTOR
    public Person(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

// ACCESSORS
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

// METHODS
    // ToString
    @Override
    public String toString() {
        return this.firstName + " " + this.lastName;
    }
}
