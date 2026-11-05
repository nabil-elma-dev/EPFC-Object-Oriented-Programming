package labo06.ex03;

import java.util.Set;
import java.util.TreeSet;

public class Program {
    public static void main(String[] args) {
        Set<Person> s = new TreeSet<>(new ComparatorPerson());
        s.add(new Person("Donald", "Knuth", 10, 1, 1938));
        s.add(new Person("Donald", "Knuth", 10, 1, 1940));
        s.add(new Person("Dennis", "Ritchie", 9, 9, 1941));
        s.add(new Person("Linus", "Torvalds", 28, 12, 1969));
        s.add(new Person("James", "Gosling", 19, 5, 1955));
        s.add(new Person("Roulio", "Gosling", 19, 5, 1955));
        s.add(new Person("Edsger", "Dijkstra", 11, 5, 1930));
        s.add(new Person("Tony", "Hoare", 11, 1, 1934));
        System.out.println(s);
    }

}
