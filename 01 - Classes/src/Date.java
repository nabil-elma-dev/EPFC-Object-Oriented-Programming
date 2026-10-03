public class Date {
    int day;
    int month;
    int year;

    public Date (int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void increment() {

    }

    public int dayOfYear() {

    }

    public int dayOfWeek() {

    }

    public boolean isLeapYear() {
        return this.year % 4 == 0 && this.year % 100 != 0
                || this.year % 400 == 0;
    }
}