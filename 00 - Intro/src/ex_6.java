import java.util.Arrays;
import java.util.Scanner;

public class ex_6 {
    public static Scanner s = new Scanner(System.in);

    public static void main() {
        System.out.print("Length: ");
        int column = s.nextInt();
        System.out.print("Height: ");
        int row = s.nextInt();
        int[][] matrix = new int[row][column];

        MatrixBuilder(row, column, matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    public static void MatrixBuilder(int row, int column, int[][] matrix) {
        for (int lg = 0; lg < row; lg++) {
            for (int h = 0; h < column; h++) {
                System.out.print("value for (" + lg + ", " + h + ") ? ");
                matrix[lg][h] = s.nextInt();
            }
        }
    }
}
