import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
public class EjecutorSerializable {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        Saludo saludito = new Saludo("Hola mundo");
        System.out.println(saludito);
        
        //FLUJO DE SALIDA/ESCRITURA BASADO EN BITs: 
        ObjectOutputStream flujoSalida = new ObjectOutputStream(new FileOutputStream("Saludos.dat"));
        flujoSalida.writeObject(saludito);
        flujoSalida.close();
        //FLUJO DE ENTRADA/LECTURA BASADO EN BITs: 
        ObjectInputStream flujoEntrada = new ObjectInputStream(new FileInputStream("Saludos.dat"));
        //DESEAREALIZACION DE OBJETOS
        
        Saludo saludito2 = (Saludo) flujoEntrada.readObject();
        System.out.println(saludito2);
        saludito2.nombre = "Mateo";
        System.out.println(saludito2);
    }
}
//Serealizacion de obj. Saludo
class Saludo implements Serializable {
    public String nombre;
    public String saludo;
    public Saludo(String saludo) {
        this.saludo = saludo;
    }
    public String contruirSaludoPersonalizado(){
        this.saludo = this.saludo + " nombre";
        return this.saludo;
    }
    @Override
    public String toString() {
        return "Saludo{" + "nombre=" + nombre + ", saludo=" + saludo + '}';
    }
    
}
        
