package Model;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class AsignaturaDAO {
    public Scanner fin;
    public String nombreArchivoInNotas;
    public ArrayList<Asignatura> asignaturas;

    public AsignaturaDAO(String nombreArchivoInNotas) {
        this.nombreArchivoInNotas = nombreArchivoInNotas;
    }
    
    public void crearFin(){
        try {
            fin = new Scanner(new File(this.nombreArchivoInNotas));
        } catch (Exception e) {
            System.out.println("ERROR AL CREAR EL FIN");
        }
    }
    
    public ArrayList<Asignatura> leerAsignaturas(){
        crearFin();
        String linea = fin.nextLine();
        System.out.println(linea);
        return asignaturas;
    }
    
    public static void main(String[] args) {
        AsignaturaDAO asigDAO = new AsignaturaDAO("src/DB/NotasIn.csv");
        asigDAO.leerAsignaturas();
    }
}
