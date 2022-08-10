
import java.util.Scanner;

public class Cuadrante {

   
    public static void main(String[] args) {
       
        System.out.println("Digite una coordenada x,y: ");
        Scanner scan = new Scanner(System.in);
        String coord[]=scan.nextLine().split(",");
        int x=Integer.parseInt(coord[0]);
        int y=Integer.parseInt(coord[1]);
        String mensaje="";
        if(x>0 && y>0){
            mensaje="Cuandrante I";
        }else if(x<0 && y<0){
            mensaje="Cuandrante III";
        }else if (x<0 && y>0){
            mensaje="Cuandrante II";
        }else if(x>0 && y<0){
            mensaje="Cuandrante IV";
        }else{
            mensaje="En el Centro";
        }
            
        System.out.println(mensaje);
        
        
    }

}
