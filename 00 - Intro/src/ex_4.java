import java.util.Arrays;

public class ex_4 {
    public static void main() {
        int[] arrayA = {0, 8, 2, 8, 4};
        int[] arrayB = {5, 1, 7, 3, 9};
        System.out.println(Arrays.toString(arrayA));
        System.out.println(Arrays.toString(arrayB));
        System.out.println(Arrays.toString(tabFusion(arrayA, arrayB)));
    }

    public static int[] tabFusion(int[] arrayA, int[] arrayB) {
        int[] res = new int[arrayA.length + arrayB.length];
        for (int i = 0; i < arrayA.length; ++i) {
            res[i] = arrayA[i];
        }
        for (int k = 0; k < arrayB.length; ++k) {
            res[arrayA.length + k] = arrayB[k];
        }
        return res;
    }
}
