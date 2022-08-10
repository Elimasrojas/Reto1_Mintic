
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

/*
* Recomendaciones Generales:
*
*    -> El método run() funcionará como nuestro método principal
*    -> No declarar objetos de tipo Scanner, utilizar el método read() para solicitar datos al usuario.
*    -> Si requiere utilizar varias clases, estas NO deben ser tipo public.
 */
class Reto2 {

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

    /**
     * método principal
     */
    public void run() {
        //Cargar Base de datos
        BaseDatosProductos bd = new BaseDatosProductos();
        
        String accion = read();
        String[] producto = read().split(" ");
        int codigo = Integer.parseInt(producto[0]);
        String nombre = producto[1];
        double precio = Double.parseDouble(producto[2]);
        double inventario = Double.parseDouble(producto[3]);
        boolean mensaje = false;
        if (accion.equals("AGREGAR")) {
            mensaje=bd.agregar(codigo,nombre,precio,inventario);
        } else if (accion.equals("ACTUALIZAR")) {
            mensaje=bd.actualizar(codigo,nombre,precio,inventario);
        }else{
            mensaje=bd.borrar(codigo,nombre,precio,inventario);
        }
        
        if(mensaje==true){
            System.out.println(String.format("%.1f", bd.generarInforme()) );
        }else{
            System.out.println("ERROR");
        }
        

        
    }

    public static void main(String[] args) {
        Reto2 r2 = new Reto2();
        r2.run();
    }
}
