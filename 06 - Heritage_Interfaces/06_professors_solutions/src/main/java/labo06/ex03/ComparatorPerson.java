package labo06.ex03;

import java.util.Comparator;

public class ComparatorPerson implements Comparator<Person> {

    @Override
    public int compare(Person t1, Person t2) {
        String nameT1 = t1.getLastName() + " " + t1.getFirstName();
        String nameT2 = t2.getLastName() + " " + t2.getFirstName();
        int cmpName = nameT1.compareToIgnoreCase(nameT2);
        if (cmpName != 0) {
            return cmpName;
        } else {
            return -t1.getDateOfBirth().compareTo(t2.getDateOfBirth());
        }
    }
}
