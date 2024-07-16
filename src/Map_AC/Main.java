package Map_AC;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<String, Estudiante> estudiantes = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean salir = false;

        while (!salir) {
            System.out.println("Menú:");
            System.out.println("1. Ingreso de estudiante");
            System.out.println("2. Ver estudiantes");
            System.out.println("3. Buscar estudiante");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    ingresarEstudiante();
                    break;
                case 2:
                    verEstudiantes();
                    break;
                case 3:
                    buscarEstudiante();
                    break;
                case 4:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        }
    }

    private static void ingresarEstudiante() {
        System.out.print("Ingrese el carnet: ");
        String carnet = scanner.nextLine();
        System.out.print("Ingrese el nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el apellido: ");
        String apellido = scanner.nextLine();

        Estudiante estudiante = new Estudiante(carnet, nombre, apellido);
        estudiantes.put(carnet, estudiante);
        System.out.println("Estudiante ingresado correctamente.");
    }

    private static void verEstudiantes() {
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
        } else {
            for (Estudiante estudiante : estudiantes.values()) {
                System.out.println(estudiante);
            }
        }
    }

    private static void buscarEstudiante() {
        System.out.print("Ingrese el carnet del estudiante a buscar: ");
        String carnet = scanner.nextLine();
        Estudiante estudiante = estudiantes.get(carnet);

        if (estudiante != null) {
            System.out.println(estudiante);
        } else {
            System.out.println("Estudiante no encontrado.");
        }
    }
}