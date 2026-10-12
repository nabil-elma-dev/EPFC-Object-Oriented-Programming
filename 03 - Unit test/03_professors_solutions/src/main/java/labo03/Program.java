package labo03;

public class Program {

    public static void swap(Date[] arr, int i, int j) {
        Date tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void sort(Date[] arr) {
        for (int i = 0; i < arr.length - 1; ++i) {
            int posMin = posMinFrom(i, arr);
            swap(arr, i, posMin);
        }
    }

    private static int posMinFrom(int i, Date[] arr) {
        int posMin = i;
        for (int k = i + 1; k < arr.length; ++k)
            if (arr[k].compareTo(arr[posMin]) < 0)
                posMin = k;
        return posMin;
    }

    public static void print(Date[] arr) {
        for (Date d : arr)
            System.out.println(d);
        System.out.println();
    }


    public static void swap(Person[] arr, int i, int j) {
        Person tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void sort(Person[] arr) {
        for (int i = 0; i < arr.length - 1; ++i) {
            int posMin = posMinFrom(i, arr);
            swap(arr, i, posMin);
        }

    }

    private static int posMinFrom(int i, Person[] arr) {
        int posMin = i;
        for (int k = i + 1; k < arr.length; ++k)
            if (arr[k].compareTo(arr[posMin]) < 0)
                posMin = k;
        return posMin;
    }

    public static void print(Person[] arr) {
        for (Person p : arr)
            System.out.println(p);
        System.out.println();
    }

    public static void main(String[] args) {
        Date[] arr = {
                new Date(2, 2, 2005),
                new Date(31, 12, 2011),
                new Date(21, 1, 2012),
                new Date(1, 3, 2012),
                new Date(1, 1, 2012),
                new Date(29, 2, 2012),
        };
        System.out.println("Avant le Tri de Dates");
        print(arr);
        sort(arr);
        System.out.println("Après le Tri");
        print(arr);

        Person[] personArray = new Person[]{
                new Person("Johnny", "Depp", 9, 6, 1963),
                new Person("Brad", "Pitt", 18, 12, 1963),
                new Person("Will", "Smith", 25, 9, 1968)
        };
        System.out.println("Avant le Tri de Personnes");
        print(personArray);
        sort(personArray);
        System.out.println("Après le Tri");
        print(personArray);
    }

}
