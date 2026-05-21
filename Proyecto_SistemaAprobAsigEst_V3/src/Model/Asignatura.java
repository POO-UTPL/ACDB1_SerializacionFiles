package Model;
public class Asignatura {
    public String nombreAsig;
    public double b1, b2, promedio, suple;
    public boolean estado;

    public Asignatura() {
    }

    public Asignatura(String nombreAsig, double b1, double b2) {
        this.nombreAsig = nombreAsig;
        this.b1 = b1;
        this.b2 = b2;
    }

    public String getNombreAsig() {
        return nombreAsig;
    }

    public void setNombreAsig(String nombreAsig) {
        this.nombreAsig = nombreAsig;
    }

    public double getB1() {
        return b1;
    }

    public void setB1(double b1) {
        this.b1 = b1;
    }

    public double getB2() {
        return b2;
    }

    public void setB2(double b2) {
        this.b2 = b2;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public double getSuple() {
        return suple;
    }

    public void setSuple(double suple) {
        this.suple = suple;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Asignatura{" + "nombreAsig=" + nombreAsig + ", b1=" + b1 + ", b2=" + b2 + ", promedio=" + promedio + ", suple=" + suple + ", estado=" + estado + '}';
    }
    
}
