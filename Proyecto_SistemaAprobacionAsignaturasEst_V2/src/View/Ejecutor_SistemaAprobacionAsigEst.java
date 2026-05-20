package View;
import Controller.*;
import Model.AsignaturaDAO;
public class Ejecutor_SistemaAprobacionAsigEst {
    public static void main(String[] args) {
        ControllerAsignatura controllerAsig = new ControllerAsignatura("src/DB/DB_EstAsigs.csv");
        controllerAsig.calcularPromedios();
    }
}
