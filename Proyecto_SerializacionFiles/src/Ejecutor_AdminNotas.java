import java.util.ArrayList;

public class Ejecutor_AdminNotas {
    public static void main(String[] args) {
        Estudiante jose = new Estudiante(6.0, 10.0);
        Estudiante jhoel = new Estudiante(7.5, 5.4);
        Estudiante mateo = new Estudiante(5.6, 4.7);
        ArrayList<Estudiante> listaEst = new ArrayList<Estudiante>();
        listaEst.add(jose);
        listaEst.add(jhoel);
        listaEst.add(mateo);
        for(Estudiante est : listaEst)
            System.out.println(est);
    }
}
class Estudiante{
    public double nb1, nb2, promedio;
    public String estado; //APROBADO, Reprobado
    public Estudiante(double nb1, double nb2) {
        this.nb1 = nb1; this.nb2 = nb2;  }
    public String toString() {
        return "Estudiante{" + "nb1=" + nb1 + ", nb2=" + nb2 + ", promedio=" + promedio + ", estado=" + estado + '}';}
}