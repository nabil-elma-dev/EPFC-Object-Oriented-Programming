import java.util.Arrays;

public class ex_1 {
    public static void main() {
        int[] array = {3, 4, 1, 2};
        System.out.println(Arrays.toString(array));
        System.out.println("Min: " + minValue(array));
    }

    public static int minValue(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; ++i) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }
}
