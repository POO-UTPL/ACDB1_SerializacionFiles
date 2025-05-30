import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
public class FlujoFiles_BasadoCaracteresNotas {
    public static void main(String[] args) {
        Random ale = new Random();
        try {
            Formatter outNotas = new Formatter(new File("NotasEntrada.csv"));
            for (int i = 0; i < 10; i++) {
                //random.nextInt(max - min + 1) + min;
                int nota1B1 = ale.nextInt(10 - 0 + 1) + 0;
                int nota2B1 = ale.nextInt(10 - 0 + 1) + 0;
                outNotas.format("Materia_%d;%d;%d", (i+1), nota1B1, nota2B1);
                outNotas.close();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FlujoFiles_BasadoCaracteresNotas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
