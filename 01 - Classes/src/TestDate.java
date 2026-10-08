import java.time.LocalDate;

public class TestDate {
    public static void main(String[] args) {
        Person pn = new Person("Albert", "Einstein", LocalDate.now().getDayOfMonth(), LocalDate.now().getMonthValue(), 1998);
        Person pn_minus_one = new Person("Isaac", "Newton", LocalDate.now().getDayOfMonth() + 1, LocalDate.now().getMonthValue(), 1998);
        System.out.println(pn); // prints n
        System.out.println(pn_minus_one); // prints n-1
    }

}