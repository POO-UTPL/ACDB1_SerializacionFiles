import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class GestionFiles_FlujoCaracteresNotas {
    public static void main(String[] args) {
        String notasXavier[][] = new String[6][3];
        String notasXavierEntrada[][] = new String[notasXavier.length][3];
        String resultados[][] = new String[notasXavier.length][2];
        generarNotas(notasXavier);
        persistirNotasFiles(notasXavier);
        lecturaNotasFiles(notasXavierEntrada);
        calcularResultados(resultados, notasXavierEntrada);
    }
    
    public static void generarNotas(String notas[][]){
        Random ale = new Random();
        // ValorAletorio      * (max-1 - min +1) + min
        for (int i = 0; i < notas.length; i++) {
            String nombreMateria = "Materia_" + (i+1);
            double notaB1 = ale.nextDouble() * (9 - 0 +1) + 0;
            double notaB2 = ale.nextDouble() * (9 - 0 +1) + 0;
            notas[i][0] = nombreMateria;
            notas[i][1] = String.valueOf(notaB1);
            notas[i][2] = String.valueOf(notaB2);
        }
    }
    public static void persistirNotasFiles(String notas[][]){
        try {
            Formatter objPersistenciaFile = new Formatter(new File("notasEntrada.csv"));
            for (int i = 0; i < notas.length; i++) {
                objPersistenciaFile.format("%s;%s;%s;\n", notas[i][0], notas[i][1], notas[i][2]);
            }
            objPersistenciaFile.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GestionFiles_FlujoCaracteresNotas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void lecturaNotasFiles(String notasLeidas[][]){
        try {
            Scanner objLecturaFile = new Scanner(new File("notasEntrada.csv"));
            objLecturaFile.useLocale(Locale.US);
            while(objLecturaFile.hasNextLine()){
                String materiaNotas[] = objLecturaFile.nextLine().split(";");
                System.out.println(Arrays.toString(materiaNotas));
            }
            objLecturaFile.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GestionFiles_FlujoCaracteresNotas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void calcularResultados(String resultados[][], String notasXavierEntrada[][]){
        //double nota1B1 = Double.parseDouble(notasXavierEntrada[0][1]);
        for (int i = 0; i < notasXavierEntrada.length; i++) {
            System.out.println(notasXavierEntrada[0][1]);
                //double nota1B1 = Double.parseDouble(notasXavierEntrada[i][1]);
                //System.out.println(nota1B1);
                //double nota2B1 = fn.parse(notasXavierEntrada[i][2]).doubleValue();
                //resultados[i][1] = ((nota1B1=nota2B1)/2 >= 6.5 ) ? "APRO" : "REPRO" ;
        }
    }
}
