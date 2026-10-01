package labo00;

public class Exercise_0_01 {
    public static void main(String[] args) {
        int[] array = {1, 7, -1, 5, 2, 0};
        System.out.println(minimum(array));
    }

    public static int minimum(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; ++i) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }
}