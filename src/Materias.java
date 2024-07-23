import java.util.Scanner;

public class Materias {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del estudiante: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el apellido del estudiante: ");
        String apellido = scanner.nextLine();
        System.out.print("Ingrese la edad del estudiante: ");
        int edad = scanner.nextInt();
        scanner.nextLine();

        //Se crea una instancia de la clase Estudiante
        Estudiante estudiante = new Estudiante(nombre, apellido, edad);
        //Ingreso de las 5 materias
        for (int i = 0; i < 5; i++) {
            System.out.print("Ingrese la materia " + (i + 1) + ": ");
            String materia = scanner.nextLine();
            estudiante.ingresarMateria(i, materia);
        }
        
        estudiante.mostrarInformacion();
    }
}