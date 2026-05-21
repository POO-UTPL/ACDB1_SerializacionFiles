package Controller;

import Model.*;
import java.util.ArrayList;

public class AsignaturaController {
    public AsignaturaDAO asignaturaDAO;
    public String nombreArchivoInNotas;
    public ArrayList<Asignatura> asignaturas;

    public AsignaturaController(String nombreArchivoInNotas) {
        this.nombreArchivoInNotas = nombreArchivoInNotas;
        this.asignaturaDAO = new AsignaturaDAO(this.nombreArchivoInNotas);
    }
    
    public void calcularPromedio(){
        asignaturas = asignaturaDAO.leerAsignaturas();
        for (Asignatura asig : asignaturas){
            asig.setPromedio( (asig.getB1() + asig.getB2()) / 2 );
        }
    }
    
}
