package labo01;

public class TestDate {
    public static void main(String[] args) {
        Date d = new Date(24, 10, 2024);
        System.out.println(d);
        d.increment();
        System.out.println(d);
        System.out.println(d.day);

        Person serge = new Person("Serge", "Dupont", 13, 4, 1984);
        System.out.println(serge);
    }
}
