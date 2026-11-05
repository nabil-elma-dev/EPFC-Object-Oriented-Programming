package labo06.ex03;

import java.util.Objects;

public class Person {

    private final String firstName;
    private final String lastName;
    private final Date dateOfBirth;

    public Person(String firstName, String lastName, int day, int month, int year) {
        this.firstName = firstName;
        this.lastName = lastName;
        dateOfBirth = new Date(day, month, year);
    }

    @Override
    public String toString() {
        return getFirstName() + " " + getLastName() + " né le " + getDateOfBirth();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.dateOfBirth, other.dateOfBirth)) {
            return false;
        }
        return true;
    }


}
