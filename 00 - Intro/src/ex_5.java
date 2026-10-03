import java.util.Arrays;

public class ex_5 {
    public static void main() {
        int[] arrayA = {0, 2, 4, 8, 8};
        int[] arrayB = {1, 3, 5, 7, 9};
        System.out.println(Arrays.toString(arrayA));
        System.out.println(Arrays.toString(arrayB));
        System.out.println(Arrays.toString(tabFusionSorted(arrayA, arrayB)));
    }

    public static int[] tabFusionSorted(int[] arrayA, int[] arrayB) {
        int posA = 0;
        int posB = 0;
        int[] res = new int[arrayA.length + arrayB.length];
        for (int i = 0; i < res.length - 1; ++ i) {
            if (arrayA[posA] < arrayB[posB]) {
                res[i] = arrayA[posA];
                if (posA < arrayA.length - 1)
                    ++ posA;
            } else {
                res[i] = arrayB[posB];
                if (posB < arrayB.length - 1)
                    ++ posB;
            }

        }
        res[posA + posB + 1] = Math.max(arrayA[arrayA.length - 1], arrayB[arrayB.length - 1]);

        return res;
    }
}
