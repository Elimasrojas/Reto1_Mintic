package reto1;

import java.util.Scanner;

/*
* Recomendaciones Generales:
*
*    -> El método run() funcionará como nuestro método principal
*    -> No declarar objetos de tipo Scanner, utilizar el método read() para solicitar datos al usuario.
*    -> Si requiere utilizar varias clases, estas NO deben ser tipo public.
 */
class Reto1 {

    /**
     * Este debe ser el único objeto de tipo Scanner en el código
     */
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Este método es usado para solicitar datos al usuario
     *
     * @return Lectura de la siguiente linea del teclado
     */
    public String read() {
        return this.scanner.nextLine();
    }

    public void run() {
        
        String[] datos = read().split(" ");
        double masa = Double.parseDouble(datos[0]);
        double altura = Double.parseDouble(datos[1]);
        int edad = Integer.parseInt(datos[2]);

        if (validacion(masa, altura, edad)) {
            double imc = calcularIMC(masa, altura);
            System.out.println(String.format("%.1f", imc) + " "
                    + CalcularRiesgo(imc, edad));
        } else {
            System.out.println("ERROR");
        }
    }

    public String CalcularRiesgo(double imc, int edad) {
        String riesgo = "";
        if (imc < 22 && edad < 45) {
            riesgo = "Bajo";
        }
        if (imc < 22 && edad >= 45) {
            riesgo = "Medio";
        }
        if (imc >= 22 && edad < 45) {
            riesgo = "Medio";
        }
        if (imc >= 22 && edad >= 45) {
            riesgo = "Alto";
        }
        return riesgo;
    }

    public double calcularIMC(double masa, double altura) {
        double IMC = masa / Math.pow(altura, 2);
        return IMC;
    }

    public boolean validacion(double masa, double altura, int edad) {
        if ((masa < 0 || masa > 150) || (altura < 0.1 || altura > 2.5) || (edad < 0 || edad > 110)) {
            return false;
        }
        return true;
    }
}
