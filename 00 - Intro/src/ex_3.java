import java.util.Arrays;

public class ex_3 {
    public static void main() {
        int[] array = {3, 4, 1, 2};
        System.out.println(Arrays.toString(array));
        rotation(array);
        System.out.println(Arrays.toString(array));
    }

    public static void rotation(int[] array) {
        for (int i = array.length - 1; i > 0; --i) {
            int tmp = array[i];
            array[i] = array[i - 1];
            array[i - 1] = tmp;
        }
    }
}
