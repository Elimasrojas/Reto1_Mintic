/*
Usted tiene la tarea de construir un programa en JAVA que permita sumar y multiplicar dos números. 
Para esto debe crear una clase llamada Calculadora e implementar dos métodos suma y producto. 
Ambos métodos recibirán como parámetro dos números de tipo flotante e imprimirán el 
resultado con un número decimal

Entrada	Cada caso de prueba estará formado por una línea formada por 2 valores 
    separados por un espacio.

Salida	El programa imprimirá una línea con dos valores.
    El resultado de la suma
    El resultado del producto
    Todos los resultados deben imprimirse con un número decimal

Casos de prueba:

Entrada	Salida Esperada
2 4	6.0 8.0
5 5	10.0 25.0
0 2	2.0 0.0
4 5	9.0 20.0
0 0	0.0 0.0
 */
package reto1;

import java.util.Scanner;

public class Reto0 {

    private final Scanner scanner = new Scanner(System.in);

    public String read() {
        return this.scanner.nextLine();
    }

    public void run() {
        String[] datos= read().split(" ");
        float num1= Float.parseFloat(datos[0]);
        float num2= Float.parseFloat(datos[1]);
        System.out.println(String.format("%.1f", suma(num1,num2))
                +" "+String.format("%.1f", producto(num1,num2)));
        
    }
    public float suma(float num1, float num2){
        return num1+num2;
    }
    public float producto(float num1, float num2){
        return num1*num2;
    }

//    public static void main(String[] args) {
//        Reto0 reto = new Reto0();
//        reto.run();
//    }

}
