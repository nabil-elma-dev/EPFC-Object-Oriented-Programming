package labo00;

public class Exercise_0_03 {
    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        print(array);
        shiftRight(array);
        print(array);
    }

    public static void print(int[] array) {
        for (int x : array)
            System.out.print(x + " ");
        System.out.println();
    }

    // Ne fait rien si le tableau est vide
    public static void shiftRight(int[] array) {
        if (array.length > 0) {
            int tmp = array[array.length - 1];
            for (int k = array.length - 1; k > 0; --k)
                array[k] = array[k - 1];
            array[0] = tmp;
        }
    }
}