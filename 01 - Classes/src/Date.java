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
        if (this.day == switch (this.month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 2 -> Date.isLeapYear(this.year) ? 29 : 28;
            default -> 30;
        }) {
            if (this.month == 12) {
                this.day = 1;
                this.month = 1;
                ++this.year;
            } else {
                ++this.month;
                this.day = 1;
            }
        } else {
            ++this.day;
        }
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

    public void dayOfWeek() {

    }

    public boolean isLeapYear() {
        return this.year % 4 == 0 && this.year % 100 != 0
                || this.year % 400 == 0;
    }

    public static boolean isLeapYear(int year) {
        return year % 4 == 0 && year % 100 != 0
                || year % 400 == 0;
    }

    @Override
    public String toString() {
        return this.day + "/" + this.month + "/" + this.year;
    }
}