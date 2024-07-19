package EjerciciosComplementarios;

import java.util.Scanner;

public class Estudiante {
    private String nombre;
    private String apellido;
    private int edad;
    private String[] materias = new String[5]; // Arreglo para almacenar 5 materias

    // Constructor para asignar datos personales del estudiante
    public Estudiante(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    // Método para ingresar las 5 materias que cursa el estudiante
    public void ingresarMaterias() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese las 5 materias que cursa el estudiante:");
        for (int i = 0; i < materias.length; i++) {
            System.out.print("Materia " + (i + 1) + ": ");
            materias[i] = scanner.nextLine();
        }
    }

    // Método para mostrar toda la información del estudiante
    public void mostrarInformacion() {
        System.out.println("Datos del estudiante:");
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Edad: " + edad);
        System.out.println("Materias que cursa:");
        for (int i = 0; i < materias.length; i++) {
            System.out.println("- " + materias[i]);
        }
    }
}
