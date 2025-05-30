import java.util.Scanner;
import java.util.Formatter;
import java.io.File;
import java.io.FileNotFoundException;
public class FlujoFiles_BasadosCaracteres {
    public static void main(String[] args) {
        /*//FLUJO SALIDA: del .java a la cmd
        System.out.println("Hola mundo");
        //FLUJO ENTRADA: del cmd al .java
        Scanner teclado = new Scanner(System.in); 
        System.out.println(teclado.nextLine());  */
        
        //FLUJO SALIDA: del .java al file
        try { //Gestion de errores = Programacion a la defensiva
            Formatter flujoPersistencia = new Formatter(new File("saludo.txt"));
            flujoPersistencia.format("%s\n", "Que mas?");
            flujoPersistencia.format("Suma: %.2f %.2f\n", 4.5, 9.1);
            flujoPersistencia.format("Resta: %.2f %.2f\n", -7.2, 3.5);
            flujoPersistencia.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
