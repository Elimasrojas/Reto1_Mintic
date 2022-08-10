package mintic;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class Promedio {

    public static boolean EsVocal(char letra) {
        return "aeiou".contains(String.valueOf(letra));
    }

    public static void main(String[] args) {
//        int[] datos = {1, 2, 3, 4, 5};
//        Stream.of(datos).map(Math::sqrt);

        int arr[] = new int[]{12, 34, 45, 21, 33, 4};
        int sum = Arrays.stream(arr).parallel().reduce(0, (a, b) -> a + b);
        System.out.println("Array Sum = " + sum);

        int arr1[] = new int[]{12, 34, 45, 21, 33, 4};
        int sum1 = Arrays.stream(arr1).reduce(0, (a, b) -> a + b);
        System.out.println("Array Sum = " + sum1);

        int arr2[] = new int[]{12, 34, 45, 21, 33, 4};
        int sum2 = Arrays.stream(arr2).sum();
        System.out.println("Array Sum = " + sum2);

        Scanner leer2 = new Scanner(System.in);
        System.out.println("Digite una palabra: ");
        String palabra2 = leer2.nextLine();
        int longitud2 = palabra2.length();
        char vector[] = new char[longitud2];
        int vocales2 = 0;
        for (int i = 0; i < longitud2; i++) {
            vector[i] = palabra2.charAt(i);
            //System.out.print(vector[i]);
            char letra_actual = vector[i];
            if (EsVocal(letra_actual)) {
                vocales2++;
            }
        }
        System.out.println("Cantidad de vocales:" + vocales2);

        Scanner leer1 = new Scanner(System.in);
        System.out.println("Digite una palabra: ");
        String palabra1 = leer1.nextLine();
        int longitud1 = palabra1.length();
        int vocales1 = 0;
        for (int i = 0; i < longitud1; i++) {
            switch (palabra1.charAt(i)) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    vocales1++;
            }
        }
        System.out.println("Cantidad de vocales:" + vocales1);
    }

}
