/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mintic;

/**
 *
 * @author elima
 */
import java.util.Scanner;

public class DistanciaEntrePuntos {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);       
        int x1, x2,y1,y2, x, y;
        double distancia;        
        System.out.print("Coordenadas del Primer punto : ");
        x1 = scan.nextInt();
        y1 = scan.nextInt();
        System.out.print("Coordenadas del Segundo Punto : ");
        x2 = scan.nextInt();
        y2 = scan.nextInt();        
        x = x2 - x1;
        y = y2 - y1;
        distancia = Math.sqrt(x * x + y * y);
        System.out.println("Distancia entre dos Puntos : " + distancia);
    }
}
