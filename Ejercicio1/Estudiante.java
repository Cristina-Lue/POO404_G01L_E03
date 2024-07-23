package Ejercicio1;
import java.util.ArrayList;
import java.util.List;

public class Estudiante {
    private String nombre;
    private int edad;
    private String apellido;
    private String ciclo;
    private List<String> materias;

    public Estudiante(String nombre, int edad, String genero, String matricula) {
        this.nombre = nombre;
        this.edad = edad;
        this.apellido = genero;
        this.ciclo = matricula;
        this.materias = new ArrayList<>();
    }

    public void ingresarMaterias(List<String> materias) {
        if (materias.size() != 5) {
            throw new IllegalArgumentException("Debe ingresar exactamente 5 materias.");
        }
        this.materias = materias;
    }

    public String mostrarInformacion() {
        String infoPersonal = "Nombre: " + nombre + " " + apellido + ", Edad: " + edad +  ", Matrícula: " + ciclo;
        String infoMaterias = "Materias: " + String.join(", ", materias);
        return infoPersonal + "\n" + infoMaterias;
    }
}
