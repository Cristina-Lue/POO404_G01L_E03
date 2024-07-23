package Complementarios;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Ejercicio3 {
    public class GestionAlumnos {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            HashMap<String, String> alumnos = new HashMap<>();
            int opcion;

            do {
                System.out.println("Menú de Opciones:");
                System.out.println("1. Ingreso de estudiante");
                System.out.println("2. Ver estudiantes");
                System.out.println("3. Buscar estudiante");
                System.out.println("4. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir la nueva línea

                switch (opcion) {
                    case 1:
                        // Ingreso de estudiante
                        System.out.print("Ingrese el carnet del estudiante: ");
                        String carnet = scanner.nextLine();
                        System.out.print("Ingrese el nombre del estudiante: ");
                        String nombre = scanner.nextLine();
                        alumnos.put(carnet, nombre);
                        System.out.println("Estudiante ingresado correctamente.");
                        break;
                    case 2:
                        // Ver estudiantes
                        System.out.println("Lista de estudiantes:");
                        for (Map.Entry<String, String> entry : alumnos.entrySet()) {
                            System.out.println("Carnet: " + entry.getKey() + ", Nombre: " + entry.getValue());
                        }
                        break;
                    case 3:
                        // Buscar estudiante
                        System.out.print("Ingrese el carnet del estudiante a buscar: ");
                        carnet = scanner.nextLine();
                        nombre = alumnos.get(carnet);
                        if (nombre != null) {
                            System.out.println("Estudiante encontrado: " + nombre);
                        } else {
                            System.out.println("Estudiante no encontrado.");
                        }
                        break;
                    case 4:
                        // Salir
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } while (opcion != 4);

            // Cerrar el scanner
            scanner.close();
        }
    }

}
