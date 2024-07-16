package Notas_AC;
import java.util.Scanner;

public class PromedioNota {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Calcular nota de un alumno");
        System.out.println("Ingrese la nota del alumno: ");
        double nota = sc.nextDouble();

        if (nota >= 7.0){
            System.out.println("el alumno aprovo la materia");
        } else if (nota >= 6.5 && nota < 7.0){
            System.out.println("El alumno esta apto para realizar el examen de suficiencia");
        } else {
            System.out.println("El alumno reprobo");
        }
        sc.close();
    }
}
