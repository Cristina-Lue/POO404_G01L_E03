package Complementarios;
import java.util.Scanner;
public class Ejercicio1 {
    public class EvaluacionAlumno {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Solicitar al usuario que ingrese la nota del alumno
            System.out.print("Ingrese la nota del alumno: ");
            double nota = scanner.nextDouble();

            // Evaluar la nota del alumno
            if (nota >= 7.0) {
                System.out.println("El alumno aprobó la materia.");
            } else if (nota >= 6.50 && nota < 7.0) {
                System.out.println("El alumno puede realizar un examen de suficiencia.");
            } else {
                System.out.println("El alumno reprobó la materia.");
            }

            // Cerrar el scanner
            scanner.close();
        }
    }

}
