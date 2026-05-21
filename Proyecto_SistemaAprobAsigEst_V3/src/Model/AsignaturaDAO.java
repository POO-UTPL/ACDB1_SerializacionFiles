package Model;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AsignaturaDAO {
    public Scanner fin;
    public String nombreArchivoInNotas;
    public ArrayList<Asignatura> asignaturas;

    public AsignaturaDAO(String nombreArchivoInNotas) {
        this.nombreArchivoInNotas = nombreArchivoInNotas;
        this.asignaturas = new ArrayList<Asignatura>();
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
        while(fin.hasNext()){
            linea = fin.nextLine();
            String valores[] = linea.split(";");
            Asignatura asig = new Asignatura(
                                            valores[2],
                                            Double.parseDouble(valores[3]),
                                            Double.parseDouble(valores[4])
                                            );
            this.asignaturas.add(asig);
        }
        return asignaturas;
    }
}
