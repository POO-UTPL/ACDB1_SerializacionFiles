import java.util.ArrayList;
import java.util.Arrays;
public class Ejecutor_AdminNotas {
    public static void main(String[] args) {
        /*Estudiante jose = new Estudiante(6.0, 10.0);
        Estudiante jhoel = new Estudiante(7.5, 5.4);
        Estudiante mateo = new Estudiante(5.6, 4.7);
        ArrayList<Estudiante> listaEst = new ArrayList<Estudiante>();
        listaEst.add(jose);
        listaEst.add(jhoel);
        listaEst.add(mateo);*/
        ArrayList<Estudiante> listaEst = new ArrayList<Estudiante>(Arrays.asList(
                                                                              new Estudiante(6.0, 10.0),
                                                                              new Estudiante(7.5, 5.4),
                                                                              new Estudiante(5.6, 4.7)));
        for(Estudiante est : listaEst){
            est.calcularPromedio();
            est.determinarEstado();
            System.out.println(est);
        }
    }
}
class Estudiante{
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