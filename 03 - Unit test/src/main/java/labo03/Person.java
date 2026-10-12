package main.java.labo03;


import java.util.Objects;

public class Person {

    private final String firstName;
    private final String lastName;
    private final Date dateOfBirth;

    public Person(String firstName, String lastName,
                  int day, int month, int year) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = new Date(day, month, year);
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
    public String toString() {
        return firstName + " " + lastName + " né le " + dateOfBirth
                + ", il a " + getAge() + " ans.";
    }

    public int getAge() {
        Date today = new Date();
        int age = today.getYear() - dateOfBirth.getYear();
        if (today.getMonth() < dateOfBirth.getMonth()
                || (today.getMonth() == dateOfBirth.getMonth()
                && today.getDay() < dateOfBirth.getDay())) {
            age--;
        }
        return age;
    }

    public int getAge(Date d) {
        int age = d.getYear() - this.dateOfBirth.getYear();
        return d.getMonth() < this.dateOfBirth.getMonth()
                || d.getMonth() == this.dateOfBirth.getMonth() && d.getDay() < this.dateOfBirth.getDay()
                ?
                    age - 1
                    : age;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Person person) {
            return this.getFirstName().equals(person.firstName)
                    && this.getLastName().equals(person.lastName)
                    && this.getDateOfBirth().equals(person.getDateOfBirth());
        }
        return false;
    }

    public int comparePeople(Person other) {
        return this.getFirstName().compareToIgnoreCase(other.getFirstName()) == 0 ?
                    this.getLastName().compareToIgnoreCase(other.lastName)
                    : this.getFirstName().compareToIgnoreCase(other.getFirstName());
    }

    public int compareAge(Person other) {
        return this.getDateOfBirth().compareTo(other.getDateOfBirth());
    }

    public int compareFull(Person other) {
        return comparePeople(other) == 0 ?
                compareAge(other)
                : - comparePeople(other); // - is needed to standardize compareFull behavior
    }
}
