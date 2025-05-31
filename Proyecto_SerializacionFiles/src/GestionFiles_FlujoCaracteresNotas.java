import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Formatter;
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
        calcularResultados(notasXavierEntrada, resultados);
        persistirResultados(notasXavierEntrada, resultados);
    }
    
    public static void generarNotas(String notas[][]){
        Random ale = new Random();
        // random.nextInt(max - min + 1) + min;         //Formula para generar aleatorios enteros
        // ValorAletorio      * (max-1 - min +1) + min  //Formula para generar aleatorios reales
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
            Formatter objPersistenciaFile = new Formatter(new File("notitasCheveresEntrada.csv"));
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
            Scanner objLecturaFile = new Scanner(new File("notitasCheveresEntrada.csv"));
            //objLecturaFile.useLocale(Locale.US);
            int i = 0;
            while(objLecturaFile.hasNextLine()){
                String materiaNotas[] = objLecturaFile.nextLine().split(";");
                notasLeidas[i][0] = materiaNotas[0];
                notasLeidas[i][1] = materiaNotas[1];
                notasLeidas[i][2] = materiaNotas[2];
                i++;
            }
            objLecturaFile.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GestionFiles_FlujoCaracteresNotas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void calcularResultados(String notasXavierEntrada[][], String resultados[][]){
        double notaB1 = 0, notaB2 = 0, promedio = 0;
        for (int i = 0; i < notasXavierEntrada.length; i++) {
            notaB1 = Double.parseDouble(notasXavierEntrada[i][1]);
            notaB2 = Double.parseDouble(notasXavierEntrada[i][2]);
            promedio = (notaB1 + notaB2) / 2;
            resultados[i][0] = String.valueOf(promedio);
            resultados[i][1] = (promedio >= 6.5 ) ? "APRO" : "REPRO" ;
        }
    }
    public static void persistirResultados(String notasXavierEntrada[][], String resultados[][]){
        try {
            Formatter objPersistenciaFile = new Formatter(new File("matrizNotasXavierResultados.csv"));
            for (int i = 0; i < resultados.length; i++) {
                objPersistenciaFile.format("%s;%s;%s;%s;%s;\n", 
                                               notasXavierEntrada[i][0], 
                                               notasXavierEntrada[i][1],
                                               notasXavierEntrada[i][2],
                                               resultados[i][0],
                                               resultados[i][1]);
            }
            objPersistenciaFile.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GestionFiles_FlujoCaracteresNotas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
