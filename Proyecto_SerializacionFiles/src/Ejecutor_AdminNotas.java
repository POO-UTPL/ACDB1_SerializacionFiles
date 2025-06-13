import java.io.EOFException;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.ObjectOutputStream; //Flujo de salida, escritura de objts con flujos en bits
import java.io.FileOutputStream;   //Definir el nombre del archivo de bits
import java.io.ObjectInputStream; //Flujo de entrada, lectura de objts con flujos en bits
import java.io.FileInputStream;   //Definir el nombre del archivo de bits
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
public class Ejecutor_AdminNotas {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        /*Estudiante jose = new Estudiante(6.0, 10.0);
        Estudiante jhoel = new Estudiante(7.5, 5.4);
        Estudiante mateo = new Estudiante(5.6, 4.7);
        ArrayList<Estudiante> listaEst = new ArrayList<Estudiante>();
        listaEst.add(jose);
        listaEst.add(jhoel);
        listaEst.add(mateo);*/
        /*ArrayList<Estudiante> listaEst = new ArrayList<Estudiante>(Arrays.asList(
                                                                              new Estudiante(6.0, 10.0),
                                                                              new Estudiante(7.5, 5.4),
                                                                              new Estudiante(5.6, 4.7)));
        ObjectOutputStream flujoSalida = new ObjectOutputStream(new FileOutputStream("NotasFinales.dat"));
        for(Estudiante est : listaEst){
            est.calcularPromedio();
            est.determinarEstado();
            flujoSalida.writeObject(est); //System.out.println(est);
        }
        flujoSalida.close();*/
        ArrayList<Estudiante> listadoNotasFinalesEst = new ArrayList<Estudiante>();
        ObjectInputStream flujoEntrada = new ObjectInputStream(new FileInputStream("NotasFinales.dat"));
        try {
            while(true){
                //Deserealizarlo  => TRANSFORMAR
                Estudiante est = (Estudiante) flujoEntrada.readObject();
                listadoNotasFinalesEst.add(est);
            }
        } catch (EOFException finArchivo) {   
            System.out.println("Fin archivo");
        } catch (Exception e) {
        }
        for(Estudiante estudiante : listadoNotasFinalesEst)
                System.out.println(estudiante);
    }
}
//Serializacion de la clase
class Estudiante implements Serializable{
    public double nb1, nb2, promedio;
    public String estado; //APROBADO, Reprobado
    public Estudiante(double nb1, double nb2) {
        this.nb1 = nb1; this.nb2 = nb2;  }
    public void calcularPromedio(){
        this.promedio = (this.nb1 + this.nb2) / 2; }
    public void determinarEstado(){
        this.estado = (this.promedio >=6.5) ? "APROBADO" : "Repro";  }
    public String toString() {
        return "Estudiante{" + "nb1=" + nb1 + ", nb2=" + nb2 + ", promedio=" + promedio + ", estado=" + estado + '}';}
}