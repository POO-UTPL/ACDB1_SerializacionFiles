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
        String notasXavierEntrada[][] = new String[6][3];
        generarNotas(notasXavier);
        persistirNotasFiles(notasXavier);
        lecturaNotasFiles(notasXavierEntrada);
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
            while(objLecturaFile.hasNextLine()){
                String materiaNotas[] = objLecturaFile.nextLine().split(";");
                System.out.println(Arrays.toString(materiaNotas));
            
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GestionFiles_FlujoCaracteresNotas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
