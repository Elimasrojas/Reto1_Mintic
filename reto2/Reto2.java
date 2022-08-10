package reto2;


import java.util.Scanner;
import java.util.HashMap;
import java.util.stream.DoubleStream;
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
        String[] entrada = read().split(" ");
        
        Producto producto= new Producto(Integer.parseInt(entrada[0]),
                entrada[1], 
                Double.parseDouble(entrada[2]), 
                Double.parseDouble(entrada[3]));
        

        
        boolean mensaje = false;
        if(accion.equals("AGREGAR")) {
            mensaje=bd.agregar(producto);
        } else if (accion.equals("ACTUALIZAR")) {
            mensaje=bd.actualizar(producto);
        }else{
            mensaje=bd.borrar(producto.getCodigo());
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



class BaseDatosProductos {

    HashMap<Integer, Producto> listaProductos ;

    public BaseDatosProductos() {        
        listaProductos = new HashMap<>();
        this.cargarProductos();
    }
    
    private boolean verificarExistencia(int codigo){
        Stream<Producto> st=this.listaProductos.values().stream();
        return st.anyMatch(p->(p.getCodigo()==codigo));
    }
    public double generarInforme() {
        Stream<Producto> st=this.listaProductos.values().stream();
        DoubleStream totalInv= st.mapToDouble(p->p.getPrecio()*p.getInventario());        
        return totalInv.sum();
    }
    public boolean agregar(Producto producto) {        
        if(verificarExistencia(producto.getCodigo())){
            return false;
        }else{
            this.listaProductos.put(producto.getCodigo(),producto);
            return true;
        }   
    }

    public boolean actualizar(Producto producto) {
         if(verificarExistencia(producto.getCodigo())){
            this.listaProductos.replace(producto.getCodigo(),producto);
            return true;
        }else{            
            return false;
        }
    }

    public boolean borrar(int codigo) {
        if(verificarExistencia(codigo)){
            this.listaProductos.remove(codigo);
            return true;
        }else{            
            return false;
        }
    }

    private void cargarProductos() {
        this.listaProductos.put(1, new Producto(1, "Manzanas", 5000.0, 25));
        this.listaProductos.put(2, new Producto(2, "Limones", 2300.0,15));
        this.listaProductos.put(3, new Producto(3, "Peras", 2700.0,33));
        this.listaProductos.put(4, new Producto(4, "Arandanos", 9300.0,5));
        this.listaProductos.put(5, new Producto(5, "Tomates", 2100.0,42));
        this.listaProductos.put(6, new Producto(6, "Fresas", 4100.0,3));
        this.listaProductos.put(7, new Producto(7, "Helado", 4500.0,41));
        this.listaProductos.put(8, new Producto(8, "Galletas", 500.0,8));
        this.listaProductos.put(9, new Producto(9, "Chocolates", 3500.0,80));
        this.listaProductos.put(10, new Producto(10, "Jamon", 15000.0,10));
        
    }

    @Override
    public String toString() {
        return "BaseDatosProductos{" + "listaProductos=" + listaProductos + '}';
    }
    
}
class Producto {
    private int codigo;
    private String nombre;
    private double precio;
    private double inventario;

    public Producto(int codigo, String nombre, double precio, double inventario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.inventario = inventario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getInventario() {
        return inventario;
    }

    public void setInventario(double inventario) {
        this.inventario = inventario;
    }

    @Override
    public String toString() {
        return "Producto{" + "codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + ", inventario=" + inventario + '}';
    }
    
    
}

