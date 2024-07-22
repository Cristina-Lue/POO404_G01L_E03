package informacion;
import java.util.Scanner;

public class InformacionBasica {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese sus nombres: ");
        String nombres = scanner.nextLine();

        System.out.print("Ingrese sus apellidos: ");
        String apellidos = scanner.nextLine();

        System.out.print("Ingrese su edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine(); // Consumir la línea restante

        System.out.print("Ingrese su carrera: ");
        String carrera = scanner.nextLine();

        System.out.println("\nInformación ingresada:");
        System.out.println("Nombres: " + nombres);
        System.out.println("Apellidos: " + apellidos);
        System.out.println("Edad: " + edad);
        System.out.println("Carrera: " + carrera);

        scanner.close();
    }
}