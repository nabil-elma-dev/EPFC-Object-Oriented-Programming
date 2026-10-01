package labo00;

public class Exercise_0_02 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        print(arr);
        reverse(arr);
        print(arr);
    }

    public static void print(int[] arr) {
        for (int x : arr)
            System.out.print(x + " ");
        System.out.println();

    }

    public static void swap(int[] array, int index1, int index2) {
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

    public static void reverse(int[] array) {
        int leftIndex = 0, rightIndex = array.length - 1;
        while (leftIndex < rightIndex) {
            swap(array, leftIndex, rightIndex);
            ++leftIndex;
            --rightIndex;
        }
    }
}