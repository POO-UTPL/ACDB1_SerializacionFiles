import java.util.Formatter;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class GestionFiles_FlujosCaractares {
    public static void main(String[] args) {
        try {
            //Flujo basa en caracteres SALIDA -> Escritura, envio, guardar, almacenar
            Formatter objArchivoSalida = new Formatter(new File("archivoSalida.txt"));
            objArchivoSalida.format("Suma: %.2f  %.2f", 3.5, 7.2);
            objArchivoSalida.format("\nResta: %.2f %.2f", -9.8, 5.5);
            objArchivoSalida.close();
            Scanner objArchivoEntrada = new Scanner(new File("archivoSalida.txt"));
            String lectura = objArchivoEntrada.next();
            System.out.println(lectura);
            double n1 = objArchivoEntrada.nextDouble();
            double n2 = objArchivoEntrada.nextDouble();
            System.out.println(n1 + ", " + n2);
            objArchivoEntrada.close();
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println(fileNotFoundException.getMessage());
        }
    }
}
