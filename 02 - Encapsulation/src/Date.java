public class Date {

    public int day;
    public int month;
    public int year;

    public Date(int day, int month, int year) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void increment() {
        if (lastDayOfMonth()) {
            day = 1;
            if (month == 12) {
                month = 1;
                year++;
            } else {
                month++;
            }
        } else {
            day++;
        }
    }

    private int daysInMonth(int aMonth, int aYear) {
        final int[] DAYS_IN_MONTHS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return DAYS_IN_MONTHS[aMonth - 1] + (isLeapYear(aYear) && aMonth == 2 ? 1 : 0);
    }

    private int daysInMonth() {
        return daysInMonth(month, year);
    }

    private boolean lastDayOfMonth() {
        return day == daysInMonth();
    }

    private boolean isLeapYear(int aYear) {
        return aYear % 400 == 0 || (aYear % 100 != 0 && aYear % 4 == 0);
    }

    private boolean isLeapYear() {
        return isLeapYear(year);
    }

    public int dayOfYear() {
        int dayOfYear = this.day;
        for (int i = 1; i < month; i++) {
            dayOfYear += daysInMonth(i, year);
        }
        return dayOfYear;
    }

    public int dayOfWeek() {
        int m = this.month; // local copies because
        int y = this.year;  // month and year can be modified
        if (m == 1 || m == 2) {
            m += 12;
            y--;
        }

        int century = y / 100;
        int yearOfCentury = y % 100;
        int dayOfWeek = (day
                + (((m + 1) * 26) / 10)
                + yearOfCentury
                + (yearOfCentury / 4)
                + (century / 4)
                + 5 * century) % 7;

        return (dayOfWeek + 5) % 7;
    }

    @Override
    public String toString() {
        final String[] MONTH_IN_FRENCH = {
                "Janvier", "Février", "Mars",
                "Avril", "Mai", "Juin", "Juillet", "Aout",
                "Septembre", "Octobre", "Novembre", "Décembre"
        };
        final String[] DAY_IN_FRENCH = {
                "Lundi", "Mardi", "Mercredi",
                "Jeudi", "Vendredi", "Samedi",
                "Dimanche"
        };
        return DAY_IN_FRENCH[dayOfWeek()] + " " + day + " "
                + MONTH_IN_FRENCH[month - 1] + " " + year
                + " le " + dayOfYear() + "-ième jour de l'année";
    }

    public void prettyPrint() {
        System.out.println(this); //println implicitly call "toString()"
    }

}