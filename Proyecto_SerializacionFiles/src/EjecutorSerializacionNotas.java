import java.io.EOFException;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.Serializable;
import java.io.ObjectOutputStream; //Canal de salida, escritura, Output
import java.io.ObjectInputStream; //Canal de entrada, lectura, Input
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
public class EjecutorSerializacionNotas {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        ArrayList<Estudiante> listEst = new ArrayList<Estudiante>(Arrays.asList(
                                              new Estudiante(9.0, 9.5),
                                              new Estudiante(8.0, 9.0),
                                              new Estudiante(5.6, 4.9)));
        //FLUJO DE SALIDA/ESCRITURA BASADO EN BIT
        ObjectOutputStream flujoSalida = new ObjectOutputStream(new FileOutputStream("notas.dat"));
        for(Estudiante est : listEst){
            est.calcularPromedio();
            est.determinarEstado();
            flujoSalida.writeObject(est);//System.out.println(est);
        }
        flujoSalida.close();
        ArrayList<Estudiante> listaResultados = new ArrayList<Estudiante>();
        //FLUJO DE ENTRADA/LECTURA BASADO EN BIT
        try {
            ObjectInputStream flujoEntrada = new ObjectInputStream(new FileInputStream("notas.dat"));
            while(true){
                //Se lee el obj del arch, pero se deserializa
                Estudiante estudiante = (Estudiante) flujoEntrada.readObject();
                listaResultados.add(estudiante);
            }
        } catch (EOFException finArchivo) {
            System.out.println("Fin de archivo");
        } catch (Exception e) {
        }
        for(Estudiante est : listaResultados)
            System.out.println(est);
    }
}
class Estudiante implements Serializable{
    public double nb1, nb2, prom;
    public String estado;
    public Estudiante(double nb1, double nb2) {
        this.nb1 = nb1;  this.nb2 = nb2; }
    public void calcularPromedio(){
        this.prom = (this.nb1 + this.nb2)/2;}
    public void determinarEstado(){
        this.estado = this.prom >=6.5 ? "APROBADO" : "Reprobado";}
    public String toString() {
        return "Estudiante{" + "nb1=" + nb1 + ", nb2=" + nb2 + ", prom=" + prom + ", estado=" + estado + '}'; }  
}