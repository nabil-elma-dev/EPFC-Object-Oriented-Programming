//import java.time.LocalDate;
//
//public class Person {
//    public String firstName;
//    public String lastName;
//    public Date dateOfBirth;
//
//    public Person(String firstName, String lastName, int day, int month, int year) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.dateOfBirth = new Date(day, month, year);
//    }
//
//    @Override
//    public String toString() {
//        return firstName + " " + lastName + " né le " + dateOfBirth
//                + ", il a " + getAge() + " ans.";
//    }
//
//    public int getAge() {
//        LocalDate today = LocalDate.now();
//        int day = today.getDayOfMonth();
//        int month = today.getMonthValue();
//        int year = today.getYear();
//        int age = year - dateOfBirth.year;
//        if (month < dateOfBirth.month ||
//                (month == dateOfBirth.month && day < dateOfBirth.day))
//            age--;
//        return age;
//    }
//}