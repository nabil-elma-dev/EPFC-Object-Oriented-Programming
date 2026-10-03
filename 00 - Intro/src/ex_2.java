import java.util.Arrays;

public class ex_2 {
    public static void main() {
        int[] array = {3, 4, 1, 2};
        System.out.println(Arrays.toString(array));
        reversedArray(array);
        System.out.println(Arrays.toString(array));
    }

    public static void reversedArray(int[] array) {
        int left = 0;
        int right = array.length - 1;
        for (; left < array.length / 2; ++left) {
            var tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
            -- right;
        }
    }
}
