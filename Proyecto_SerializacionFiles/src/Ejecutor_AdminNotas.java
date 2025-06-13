public class Ejecutor_AdminNotas {
    
}
class Estudiante{
    public double nb1, nb2, promedio;
    public String estado; //APROBADO, Reprobado
    public Estudiante(double nb1, double nb2) {
        this.nb1 = nb1; this.nb2 = nb2;  }

    public String toString() {
        return "Estudiante{" + "nb1=" + nb1 + ", nb2=" + nb2 + ", promedio=" + promedio + ", estado=" + estado + '}';}
}