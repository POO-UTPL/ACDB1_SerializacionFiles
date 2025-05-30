import java.util.Scanner;
import java.util.Formatter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class FlujoFiles_BasadosCaracteres {
    public static void main(String[] args)  {
        /* //FLUJO SALIDA: del .java a la cmd
        System.out.println("Hola mundo");
        //FLUJO ENTRADA: del cmd al .java
        Scanner teclado = new Scanner(System.in); 
        System.out.println(teclado.nextLine());
        int num1 = teclado.nextInt(); */
        
        //FLUJO SALIDA = Escritura: del .java al file
        try { //Gestion de errores = Programacion a la defensiva
            Formatter flujoPersistencia = new Formatter(new File("saludo.txt"));
            flujoPersistencia.format("Suma: %.2f %.2f\n", 4.5, 9.1);
            flujoPersistencia.format("Resta: %.2f %.2f\n", -7.2, 3.5);
            flujoPersistencia.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        
        //FLUJO DE ENTRADA = Lectura: Del files al .java
        try {
            Scanner flujoLectura = new Scanner(new File("saludo.txt"));
            String opera1 = flujoLectura.next();
            double num1 = flujoLectura.nextDouble();
            double num2 = flujoLectura.nextDouble();
            System.out.println(num1 + ", " + num2);
            
            String opera2 = flujoLectura.next();
            double num3 = flujoLectura.nextDouble();
            double num4 = flujoLectura.nextDouble();
            flujoLectura.close();
            System.out.println(num3 + ", " + num4);
            
            double suma = num1 + num2;
            double resta = num3 - num4;
            
            Formatter flujoPersistenciaResultados = 
                    new Formatter(new File("resultados.csv"));
            flujoPersistenciaResultados.format("%s;%s;%s;%s;\n", "OPERACION", "NUMERO 1", "NUMERO 2", "RESULTADO");
            flujoPersistenciaResultados.format("%s;%.2f;%.2f;%.2f;\n",opera1, num1, num2, suma);
            flujoPersistenciaResultados.format("%s;%.2f;%.2f;%.2f;\n",opera2, num3, num4, resta);
            flujoPersistenciaResultados.close();
            
           
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FlujoFiles_BasadosCaracteres.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
