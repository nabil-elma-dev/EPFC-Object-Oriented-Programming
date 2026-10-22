package labo05;


public class Person implements Comparable<Person> {

    private final String firstName;
    private final String lastName;
    private final Date dateOfBirth;

    public Person(String firstName, String lastName, int day, int month, int year) {
        this.firstName = firstName;
        this.lastName = lastName;
        dateOfBirth = new Date(day, month, year);
    }

    @Override
    public int compareTo(Person t) {
        //une personne avec une date de naissance plus petite
        //est plus agée, donc plus "grande" dans notre ordre.
        //il faut donc inverser la valeur de retour de 
        //compareTo(Date)
        return -this.dateOfBirth.compareTo(t.dateOfBirth);
    }

}
