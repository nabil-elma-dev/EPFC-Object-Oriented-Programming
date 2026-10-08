import java.time.LocalDate;

public class Date {

    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {
        if (month < 1 || month > 12 ||
                day < 1 || day > daysInMonth(month, year)) {
            throw new RuntimeException("Invalid date passed to the constructor");
        }
        setDay(day);
        setMonth(month);
        setYear(year);
    }

    public int getDay() {
        return day;
    }

    public Date() {
        setDay(LocalDate.now().getDayOfMonth());
        setMonth(LocalDate.now().getMonthValue());
        setYear(LocalDate.now().getYear());
    }

    public void setDay(int day) {
        if (day < 1 && day > this.daysInMonth()) {
            throw new RuntimeException("Error: incorrect value for \"day\" attribute");
        }
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if (month < 1 || month > 12 || this.day > daysInMonth(month, this.year)) {
            throw new RuntimeException("Error: incorrect value for \"month\" attribute");
        }
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (isLeapYear() && !isLeapYear(year) && this.month == 2 && this.day == 29) {
            throw new RuntimeException("Error: incorrect value for \"year\" attribute (leap year into non-leap year while in 29th of february!)");
        }
        this.year = year;
    }

    public void increment() {
        if (lastDayOfMonth()) {
            setDay(1);
            if (month == 12) {
                setMonth(1);
                setYear(getYear() + 1);
            } else {
                setMonth(getMonth() + 1);
            }
        } else {
            setDay(getDay() + 1);
        }
    }

    private static int daysInMonth(int aMonth, int aYear) {
        final int[] DAYS_IN_MONTHS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return DAYS_IN_MONTHS[aMonth - 1] + (isLeapYear(aYear) && aMonth == 2 ? 1 : 0);
    }

    private int daysInMonth() {
        return daysInMonth(getMonth(), getYear());
    }

    private boolean lastDayOfMonth() {
        return getDay() == daysInMonth();
    }

    private static boolean isLeapYear(int aYear) {
        return aYear % 400 == 0 || (aYear % 100 != 0 && aYear % 4 == 0);
    }

    private boolean isLeapYear() {
        return isLeapYear(getYear());
    }

    public int dayOfYear() {
        int dayOfYear = this.getDay();
        for (int i = 1; i < getMonth(); i++) {
            dayOfYear += daysInMonth(i, getYear());
        }
        return dayOfYear;
    }

    public int dayOfWeek() {
        int m = this.getMonth(); // local copies because
        int y = this.getYear();  // month and year can be modified
        if (m == 1 || m == 2) {
            m += 12;
            y--;
        }

        int century = y / 100;
        int yearOfCentury = y % 100;
        int dayOfWeek = (this.getDay()
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
        return DAY_IN_FRENCH[dayOfWeek()] + " " + this.getDay() + " "
                + MONTH_IN_FRENCH[this.getMonth() - 1] + " " + this.getYear()
                + " le " + dayOfYear() + "-ième jour de l'année";
    }

    public void prettyPrint() {
        System.out.println(this); //println implicitly call "toString()"
    }

}