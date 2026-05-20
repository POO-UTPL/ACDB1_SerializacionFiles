package Model;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AsignaturaDAO {
    public Scanner fin;
    public String nombreFileIn;
    public ArrayList<Asignatura> asignaturas;

    public AsignaturaDAO(String nombreFileIn) {
        this.nombreFileIn = nombreFileIn;
        asignaturas = new  ArrayList<Asignatura>();
    }
    
    public void crearFIn(){
        try {
            fin = new Scanner(new File("src/DB/" + nombreFileIn));
        } catch (Exception e) {
            System.out.println("Error al crear FIn ");
        }
    }
    public ArrayList<Asignatura> leerAsignaturas(){
        crearFIn();
        String linea = fin.nextLine();
        while(fin.hasNext()){
            linea = fin.nextLine();
            String valores[] = linea.split(";");
            Asignatura asig = new Asignatura();
            asig.setNombreAsig(valores[2]);
            asig.setB1(Double.parseDouble(valores[3]));
            asig.setB2(Double.parseDouble(valores[4]));
            this.asignaturas.add(asig);
        }
        fin.close();
        return asignaturas;
    }
}
