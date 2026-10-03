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
        int days = 0;
        for (int currentMonth = 1; currentMonth < this.month; ++currentMonth) {
            days += switch (currentMonth) {
                case 1, 3, 5, 7, 8, 10, 12 -> 31;
                case 2 -> Date.isLeapYear(this.year) ? 29 : 28;
                default -> 30;
            };
        }
        return days += this.day;
    }

    public int dayOfWeek() {

    }

    public boolean isLeapYear() {
        return this.year % 4 == 0 && this.year % 100 != 0
                || this.year % 400 == 0;
    }

    public static boolean isLeapYear(int year) {
        return year % 4 == 0 && year % 100 != 0
                || year % 400 == 0;
    }
}