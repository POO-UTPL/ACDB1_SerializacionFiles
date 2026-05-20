package Controller;
import Model.*;
import java.util.ArrayList;

public class ControllerAsignatura {
    public AsignaturaDAO asignaturaDAO;
    public String nombreArchivo;
    public ArrayList<Asignatura> asignaturas;

    public ControllerAsignatura(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
        asignaturaDAO = new AsignaturaDAO(nombreArchivo);
    }
    
    public void calcularPromedios(){
        asignaturas = asignaturaDAO.leerAsignaturas();
        for(Asignatura asig : asignaturas){
            System.out.println(asig);
        }
    }
    
}
