package labo00;

import java.util.Scanner;

public class Exercise_0_06 {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Quelle largeur ? ");
        int width = scan.nextInt();
        System.out.print("Quelle hauteur ? ");
        int height = scan.nextInt();

        int[][] matrix = new int[height][width];

        fill(matrix);
        System.out.println("Voilà la matrice : ");
        print(matrix);
    }

    public static void fill(int[][] matrix) {
        for (int line = 0; line < matrix.length; ++line) {
            for (int column = 0; column < matrix[line].length; ++column) {
                System.out.print("Quelle valeur pour (" + line + ", " + column + ") ? ");
                matrix[line][column] = scan.nextInt();
            }
        }
    }

    public static void print(int[][] matrix) {
        for (int[] arr : matrix) {
            for (int value : arr) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }
}
