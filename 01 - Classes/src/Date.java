public class Date {
// Attributes
    int day;
    int month;
    int year;

// Constructor
    public Date (int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

// Instance methods
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
        int nbDays = 0;
        for (int currentMonth = 1; currentMonth < this.month; ++currentMonth) {
            nbDays += switch (currentMonth) {
                case 1, 3, 5, 7, 8, 10, 12 -> 31;
                case 2 -> Date.isLeapYear(this.year) ? 29 : 28;
                default -> 30;
            };
        }
        return nbDays += this.day;
    }

    public int dayOfWeek() {
        int dayOfW = (this.day +
                ((monthZeller() + 1)*13) / 5
                + yearZeller() % 100
                + (yearZeller() % 100) / 4
                + (yearZeller() / 100) / 4
                + 5 * (yearZeller() / 100)
        ) % 7;
        return dayOfW;
    }

    public int monthZeller() {
        return switch (this.month) {
            case 1 -> 13;
            case 2 -> 14;
            default -> this.month;
        };
    }

    public int yearZeller() {
        return switch (monthZeller()) {
            case 13, 14 -> this.year - 1; // (!) this.year - 1 OK; --this.year modifies attribute year!!!
            default -> this.year;
        };

    }

    public String dayOfWeekStr() {
        return switch (dayOfWeek()) {
            case 0 -> "Saturday";
            case 1 -> "Sunday";
            case 2 -> "Monday";
            case 3 -> "Tuesday";
            case 4 -> "Wednesday";
            case 5 -> "Thursday";
            default -> "Friday";
        };
    }

    public String monthStr() {
        return switch (this.month) {
          case 1 ->  "January";
          case 2 ->  "February";
          case 3 ->  "March";
          case 4 ->  "April";
          case 5 ->  "Mai";
          case 6 ->  "June";
          case 7 ->  "July";
          case 8 ->  "August";
          case 9 ->  "September";
          case 10 -> "October";
          case 11 -> "November";
          default -> "December";
        };
    }

// Static methods
    public static boolean isLeapYear(int year) {
        return year % 4 == 0 && year % 100 != 0
                || year % 400 == 0;
    }

// toSTring
    @Override
    public String toString() {
        return this.day + "/" + this.month + "/" + this.year;
    }


    public void prettyPrint() {
        System.out.println(dayOfWeekStr() + ", " + monthStr() + " " + this.day + ", " + this.year);
    }
}