
import java.util.HashMap;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class BaseDatosProductos {

    HashMap<Integer, Producto> listaProductos=null ;

    public BaseDatosProductos() {
        listaProductos = new HashMap<>();
        this.cargarProductos();
    }
    
    private boolean existeEnBD(int codigo){
        Stream<Producto> st=this.listaProductos.values().stream();
        return st.anyMatch(p->(p.getCodigo()==codigo));
    }
    public double generarInforme() {
        Stream<Producto> st=this.listaProductos.values().stream();
        DoubleStream totalInv= st.mapToDouble(p->p.getPrecio()*p.getInventario());        
        return totalInv.sum();
    }
    

    
    public boolean agregar(int codigo,String nombre, double precio, double inventario) {        
        if(existeEnBD(codigo)){
            return false;
        }else{
            this.listaProductos.put(codigo,new Producto(codigo,nombre,precio,inventario));
            return true;
        }
            
            
    }

    public boolean actualizar(int codigo,String nombre, double precio, double inventario) {
         if(existeEnBD(codigo)){
            this.listaProductos.put(codigo,new Producto(codigo,nombre,precio,inventario));
            return true;
        }else{            
            return false;
        }
    }

    public boolean borrar(int codigo,String nombre, double precio, double inventario) {
        if(existeEnBD(codigo)){
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
