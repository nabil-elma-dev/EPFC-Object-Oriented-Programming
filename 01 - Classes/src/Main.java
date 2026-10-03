public class Main {
    static void main() {
        Date d = new Date(1, 5, 1998);
        System.out.println(d.day);
        d.increment();
        System.out.println(d.day);
        System.out.println(d.dayOfYear());
    }
}