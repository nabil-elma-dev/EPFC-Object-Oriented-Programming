
package labo06.ex02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Program {
    public static void main(String[] args) {
        Person p1 = new Person("A", "a1");
        Person p2 = new Person("B", "b1");
        Person p3 = new Person("A", "a2");
        Person p4 = new Person("B", "b2");

        List<Person> li = new ArrayList<>();
        li.add(p1);
        li.add(p2);
        li.add(p3);
        li.add(p4);

        System.out.println(li);

        Collections.sort(li, new ComparatorPersonFirstName());
        //ou li.sort(new ComparatorPersonFirstName());
        System.out.println(li);

        Collections.sort(li, new ComparatorPersonLastName());
        System.out.println(li);

        //Constatez que le tri est stable !
    }
}
