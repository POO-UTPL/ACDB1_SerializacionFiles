package View;

import Controller.*;

public class Ejecutor_SistemaAprobAsigEst {
    public static void main(String[] args) {
        AsignaturaController asignaturaController = new AsignaturaController("src/DB/NotasIn.csv");
        asignaturaController.calcularPromedio();
        asignaturaController.definirEstado();
        System.out.println(asignaturaController.asignaturas);
    }
}
