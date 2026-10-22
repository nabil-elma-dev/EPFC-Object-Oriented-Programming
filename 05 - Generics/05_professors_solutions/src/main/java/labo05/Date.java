package labo05;

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
            Date d = (Date) o;
            return this.year == d.year && this.month == d.month
                    && this.day == d.day;
        }
        return false;
    }
    private int toInt() {
        return year * 10000 + month * 100 + day;
    }
    @Override
    public int compareTo(Date t) {
        return this.toInt() - t.toInt();
    }
    @Override
    public String toString() {
        return day + "/" + month + "/" + year;
    }
}
