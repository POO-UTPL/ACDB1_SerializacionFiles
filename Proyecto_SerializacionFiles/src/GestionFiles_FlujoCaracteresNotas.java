import java.util.Random;
public class GestionFiles_FlujoCaracteresNotas {
    public static void main(String[] args) {
        String notasXavier[][] = new String[6][3];
        generarNotas(notasXavier);
    }
    
    public static void generarNotas(String notas[][]){
        Random ale = new Random();
        // ValorAletorio      * (max - min +1) + min
        for (int i = 0; i < notas.length; i++) {
            String nombreMateria = "Materia_" + (i+1);
            double notaB1 = ale.nextDouble() * (10 - 0 +1) + 0;
            double notaB2 = ale.nextDouble() * (10 - 0 +1) + 0;
            notas[i][0] = nombreMateria;
            notas[i][1] = String.valueOf(notaB1);
            notas[i][2] = String.valueOf(notaB2);
        }
    }
}
