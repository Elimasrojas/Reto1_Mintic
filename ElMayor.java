
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author elima
 */
public class ElMayor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*Leer tres números enteros e imprimir el mayor*/
        System.out.println("Digitar 3 numeros enteros separados de espacio.\n a b c:");
        Scanner scan = new Scanner(System.in);
        String[] numeros = scan.nextLine().split(" ");
        int a, b, c;
        a = Integer.parseInt(numeros[0]);
        b = Integer.parseInt(numeros[1]);
        c = Integer.parseInt(numeros[2]);
        int mayor = 0;
        if (a > b) {
            if (a > c) {
                mayor = a;
            } else {
                mayor = c;
            }
        } else {
            if (b > c) {
                mayor = b;
            } else {
                mayor = c;
            }
        }
        System.out.println(mayor);

        //con Stream
        int[] amayor = {2, 4, 0};
        IntStream stream = Arrays.stream(amayor);
        OptionalInt op = stream.max();
        System.out.println(op.getAsInt());

        IntStream listx = Arrays.stream(amayor);
        OptionalInt op1 = listx.sorted().max();
        System.out.println(op1.getAsInt());

        List<Integer> lista = new ArrayList();
        lista.add(2);
        lista.add(4);
        lista.add(0);

        int[] digits = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        long n = IntStream.of(digits).count();
        System.out.println(IntStream.of(digits).findFirst());

        IntStream streamb = IntStream.of(1, 2, 3, 4, 5, 6, 7);
        System.out.println(
                streamb.anyMatch(i -> i % 3 == 0)
        ); // true

    }

}
