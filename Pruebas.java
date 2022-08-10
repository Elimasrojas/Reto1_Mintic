
import java.time.Period;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class Pruebas {

    public static void main(String[] args) {
        HashMap<Integer, Producto> listaProductos = new HashMap<>();
        listaProductos.put(1, new Producto(1, "Manzanas", 5000.0, 25));
        listaProductos.put(2, new Producto(2, "Limones", 2300.0, 15));
        listaProductos.put(3, new Producto(3, "Peras", 2700.0, 33));
        listaProductos.put(4, new Producto(4, "Arandanos", 9300.0, 5));
        listaProductos.put(5, new Producto(5, "Tomates", 2100.0, 42));
        listaProductos.put(6, new Producto(6, "Fresas", 4100.0, 3));
        listaProductos.put(7, new Producto(7, "Helado", 4500.0, 41));
        listaProductos.put(8, new Producto(8, "Galletas", 500.0, 8));
        listaProductos.put(9, new Producto(9, "Chocolates", 3500.0, 80));
        listaProductos.put(10, new Producto(10, "Jamon", 15000.0, 10));
        listaProductos.put(10, new Producto(10, "xxx", 1, 0));

        listaProductos.forEach((Integer k, Producto v) -> System.out.println(v.getNombre()));
        Stream<Producto> st = listaProductos.values().stream();
        st.forEach((Producto v) -> System.out.println(v.getNombre()));
        Stream<Map.Entry<Integer, Producto>> stream = listaProductos.entrySet().stream();
        stream.forEach((m) -> System.out.println(m + " " + m.getValue().getNombre()));
//        System.out.println("Stream: "
//                + Arrays.toString(stream.toArray()));

        List<Integer> lista = Arrays.asList(3, 2, 9, 6, 0, 1);
        //lista.add(7);
        for (Integer list : lista) {
            System.out.println(list);
        }
        Optional.ofNullable("")
                .ifPresentOrElse(mensaje -> System.out.println("Mi menaje"),
                        () -> System.out.println("xxx")
                );
        
        Period.ofDays(200);

    }

}
