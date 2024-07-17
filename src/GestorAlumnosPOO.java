import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GestorAlumnosPOO {

    private static Map<String, String> alumnos = new HashMap<>(); // HashMap para almacenar los alumnos (carnet, nombre)

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("\nMenú de opciones:");
            System.out.println("1. Ingreso de estudiante");
            System.out.println("2. Ver estudiante");
            System.out.println("3. Buscar estudiante");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después de nextInt()

            switch (opcion) {
                case 1:
                    ingresarEstudiante(scanner);
                    break;
                case 2:
                    verEstudiante();
                    break;
                case 3:
                    buscarEstudiante(scanner);
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 4);

        scanner.close();
    }

    private static void ingresarEstudiante(Scanner scanner) {
        System.out.print("Ingrese el carnet del estudiante: ");
        String carnet = scanner.nextLine();

        System.out.print("Ingrese el nombre del estudiante: ");
        String nombre = scanner.nextLine();

        alumnos.put(carnet, nombre);
        System.out.println("Estudiante ingresado correctamente.");
    }

    private static void verEstudiante() {
        System.out.println("\nLista de estudiantes:");
        if (alumnos.isEmpty()) {
            System.out.println("No hay estudiantes ingresados.");
        } else {
            for (Map.Entry<String, String> entry : alumnos.entrySet()) {
                System.out.println("Carnet: " + entry.getKey() + ", Nombre: " + entry.getValue());
            }
        }
    }

    private static void buscarEstudiante(Scanner scanner) {
        System.out.print("Ingrese el carnet del estudiante a buscar: ");
        String carnet = scanner.nextLine();

        if (alumnos.containsKey(carnet)) {
            String nombre = alumnos.get(carnet);
            System.out.println("Estudiante encontrado - Carnet: " + carnet + ", Nombre: " + nombre);
        } else {
            System.out.println("Estudiante con carnet " + carnet + " no encontrado.");
        }
    }
}

