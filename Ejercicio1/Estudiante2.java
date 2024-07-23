package Ejercicio1;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Estudiante2 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Creación del estudiante
            System.out.print("Ingrese el nombre del estudiante: ");
            String nombre = scanner.nextLine();

            System.out.print("Ingrese el apellido del estudiante: ");
            String apellido = scanner.nextLine();

            System.out.print("Ingrese la edad del estudiante: ");
            int edad = scanner.nextInt();
            scanner.nextLine();  // Consumir la nueva línea

            System.out.print("Ingrese el ciclo del estudiante: ");
            String ciclo = scanner.nextLine();

            Estudiante estudiante = new Estudiante(nombre, edad, apellido, ciclo);

            // Ingreso de materias
            List<String> materias = new ArrayList<>();
            System.out.println("Ingrese 5 materias para el estudiante:");
            for (int i = 0; i < 5; i++) {
                System.out.print("Materia " + (i + 1) + ": ");
                materias.add(scanner.nextLine());
            }

            estudiante.ingresarMaterias(materias);

            // Mostrar la información del estudiante
            System.out.println(estudiante.mostrarInformacion());

            scanner.close();
        }
}
