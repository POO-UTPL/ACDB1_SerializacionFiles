package Model;

import java.util.ArrayList;

public class Estudiante {
    public String cedula, nombreEst;
    public ArrayList<Asignatura> asignaturas;

    public Estudiante() {
    }

    public Estudiante(String cedula, String nombreEst, ArrayList<Asignatura> asignaturas) {
        this.cedula = cedula;
        this.nombreEst = nombreEst;
        this.asignaturas = asignaturas;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombreEst() {
        return nombreEst;
    }

    public void setNombreEst(String nombreEst) {
        this.nombreEst = nombreEst;
    }

    public ArrayList<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(ArrayList<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "cedula=" + cedula + ", nombreEst=" + nombreEst + ", asignaturas=" + asignaturas + '}';
    }
    
}
