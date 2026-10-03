public class TestDate {
    static void main() {
        Date d = new Date(28, 2, 2000);
        d.prettyPrint(); // Monday 28/02

        d.increment();
        d.prettyPrint();    // Tuesday 29/02

        d.increment();
        d.prettyPrint();    // Wednesday 01/03
    }
}