import java.time.LocalDate;

public class Person {
    public static final LocalDate today = LocalDate.now();

    String firstName, lastName;
    Date dateOfBirth;

    public Person(String firstName, String lastName, int day, int month, int year) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = new Date(day, month, year);
    }

    public String toString() {
        return this.firstName + " " + this.lastName + " is " + getAge() +
                " y.o. (date of birth: " +
                this.dateOfBirth.day + " "
                + this.dateOfBirth.month + " "
                + this.dateOfBirth.year + ")";
    }

    public int getAge() {
        return today.getMonthValue() < this.dateOfBirth.month
                || this.dateOfBirth.month == today.getMonthValue() && today.getDayOfMonth() < this.dateOfBirth.day
        ?
                today.getYear() - this.dateOfBirth.year - 1
                : today.getYear() - this.dateOfBirth.year;
    }
}


