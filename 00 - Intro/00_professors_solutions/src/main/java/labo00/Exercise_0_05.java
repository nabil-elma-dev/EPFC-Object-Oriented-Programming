package labo00;

public class Exercise_0_05 {
    public static void main(String[] args) {
        int[] arr1 = {0, 2, 4, 8, 8};
        int[] arr2 = {1, 3, 5, 7, 9};
        print(arr1);
        print(arr2);
        System.out.println("Les deux en un");
        print(merge(arr1, arr2));
    }

    public static void print(int[] arr) {
        for (int x : arr)
            System.out.print(x + " ");
        System.out.println();
    }

    // Pré: Les tableaux array1 et array2 doivent être préalablement triés
    // Renvoie un nouveau tableau avec tous les éléments de tab1 et array2 triés
    public static int[] merge(int[] array1, int[] array2) {
        int[] array3 = new int[array1.length + array2.length];
        int idx1 = 0, idx2 = 0, idx3 = 0;

        // Tant qu'il y en a dans le 1 ET dans le 2
        while (idx1 < array1.length && idx2 < array2.length)
            if (array1[idx1] <= array2[idx2]) // on choisit le plus petit
                array3[idx3++] = array1[idx1++];
            else
                array3[idx3++] = array2[idx2++];

            // Version avec une ternaire : remarquez que c'est obscur ici
            // array3[idx3++] = array1[idx1] <= array2[idx2] ? array1[idx1++] : array2[idx2++];


        // On termine tout ce qui reste dans le 1 ...
        while (idx1 < array1.length)
            array3[idx3++] = array1[idx1++];

        // ... ou ...

        // ... tout ce qui reste dans le 2
        while (idx2 < array2.length)
            array3[idx3++] = array2[idx2++];
        return array3;
    }

}