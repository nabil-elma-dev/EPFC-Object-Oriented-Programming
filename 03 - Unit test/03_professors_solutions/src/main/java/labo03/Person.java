package labo03;

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

    @Override
    public String toString() {
        return firstName + " " + lastName + " né le " + dateOfBirth
                + ", il a " + getAge() + " ans.";
    }

    public int getAge() {
        return getAgeAt(new Date());
    }

    public int getAgeAt(Date d) {
        int age = d.getYear() - dateOfBirth.getYear();
        if (d.getMonth() < dateOfBirth.getMonth()
                || (d.getMonth() == dateOfBirth.getMonth()
                && d.getDay() < dateOfBirth.getDay())) {
            age--;
        }
        return age;
    }

    public int compareTo(Person p) {
        return -this.dateOfBirth.compareTo(p.dateOfBirth);
    }

    public boolean equals(Object o) {
        if (o instanceof Person) {
            Person p = (Person) o;
            return this.firstName.equals(p.firstName) &&
                    this.lastName.equals(p.lastName) &&
                    this.dateOfBirth.equals(p.dateOfBirth);
        }
        return false;
    }

    public static void main(String[] args) {
        Person p = new Person("Pierre", "Durand", 1, 1, 1970);
        System.out.println(p);
    }
}
