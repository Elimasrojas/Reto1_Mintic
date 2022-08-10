package reto1;

import java.util.Scanner;


public class Reto1_origen {

    
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        String[] datos= scan.nextLine().split(" ");        
        double masa=Double.parseDouble(datos[0]);
        double altura=Double.parseDouble(datos[1]);
        int edad=Integer.parseInt(datos[2]);
        
        if(validacion(masa, altura, edad)){
            double imc=calcularIMC(masa, altura);
            System.out.println(String.format("%.1f",imc )+" "
            + CalcularRiesgo(imc, edad));
        }else{
            System.out.println("Error");
        }        
        
    }
    public static  String CalcularRiesgo(double imc, int edad){
        String riesgo="";
        if(imc<22 && edad <45){
            riesgo="bajo";
        }
        if (imc<22 && edad >=45) riesgo="Medio";
        if (imc>=22 && edad <45) riesgo="Medio";
        if (imc>=22 && edad >=45) riesgo="Alto";
        return riesgo;
    }
    public static double calcularIMC(double masa,double altura){
        double IMC=masa/Math.pow(altura, 2);
        return IMC;
    }
    public static boolean validacion(double masa,double altura, int edad){
        if ((masa <0 || masa >150 )|| (altura<0.1 || altura >2.5)||(edad<0 || edad > 110)){
            return false;
        }
        return true;
    }
    
}
