package EjeComplementario;
import java.util.Scanner;
public class Complementraio2 {
    public class InformacionBasica {
        public static void main(String[] args) {
            // Create a Scanner object to read input
            Scanner input = new Scanner(System.in);

            // Prompt the user for their first name
            System.out.print("Ingrese sus nombres: ");
            String nombres = input.nextLine();

            // Prompt the user for their last name
            System.out.print("Ingrese sus apellidos: ");
            String apellidos = input.nextLine();

            // Prompt the user for their age
            System.out.print("Ingrese su edad: ");
            int edad = input.nextInt();

            // Consume the remaining newline character
            input.nextLine();

            // Prompt the user for their major (carrera)
            System.out.print("Ingrese su carrera: ");
            String carrera = input.nextLine();

            // Close the Scanner object
            input.close();

            // Print the information to the console
            System.out.println("\nInformación ingresada:");
            System.out.println("Nombres: " + nombres);
            System.out.println("Apellidos: " + apellidos);
            System.out.println("Edad: " + edad);
            System.out.println("Carrera: " + carrera);
        }
    }

}
