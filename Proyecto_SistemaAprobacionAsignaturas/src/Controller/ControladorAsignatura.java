package Controller;
import Model.*;
import java.util.ArrayList;
public class ControladorAsignatura {
    public ArrayList<Asignatura> asignaturas;
    public AsignaturaDAO asigDAO;
    public ControladorAsignatura() {
        this.asigDAO = new AsignaturaDAO("EstAsig.csv");
    }
    public void generarParcial(){
        asignaturas = asigDAO.leerAsignaturas();
        for (Asignatura asig : asignaturas) {
            System.out.println(asig);
        }
    }
}
