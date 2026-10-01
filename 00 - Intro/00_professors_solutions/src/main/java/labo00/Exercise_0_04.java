package labo00;

public class Exercise_0_04 {
    public static void main(String[] args) {
        int[] arr1 = {0, 8, 2, 8, 4};
        int[] arr2 = {5, 1, 7, 3, 9};
        print(arr1);
        print(arr2);
        System.out.println("Les deux en un");
        print(concat(arr1, arr2));
    }

    public static void print(int[] array) {
        for (int x : array)
            System.out.print(x + " ");
        System.out.println();
    }

    // Renvoie un nouveau tableau contenant, en suivant 
    // tous les éléments de array1 et array2
    public static int[] concat(int[] array1, int[] array2) {
        int[] array3 = new int[array1.length + array2.length];
        for (int k = 0; k < array1.length; ++k)
            array3[k] = array1[k];
        for (int k = 0; k < array2.length; ++k)
            array3[k + array1.length] = array2[k];
        return array3;
    }

}