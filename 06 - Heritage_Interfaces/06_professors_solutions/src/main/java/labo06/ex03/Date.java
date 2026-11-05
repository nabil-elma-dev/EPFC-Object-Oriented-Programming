package labo06.ex03;


public class Date implements Comparable<Date> {

    private final int day;
    private final int month;
    private final int year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Date) {
            Date other = (Date) o;
            return this.year == other.year && this.month == other.month
                    && this.day == other.day;
        }
        return false;
    }

    @Override
    public int compareTo(Date other) {
        return (this.year * 10000 + this.month * 100 + this.day) -
                (other.year * 10000 + other.month * 100 + other.day);
    }

    @Override
    public String toString() {
        return day + "/" + month + "/" + year;
    }


}
