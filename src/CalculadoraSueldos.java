import java.util.Scanner;

public class CalculadoraSueldos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el número de empleados: ");
        int numEmpleados = scanner.nextInt();

        double[] sueldos = new double[numEmpleados];

        for (int i = 0; i < numEmpleados; i++) {
            boolean sueldoValido = false;
            do {
                System.out.print("Ingrese el sueldo del empleado " + (i + 1) + ": ");
                double sueldo = scanner.nextDouble();

                if (sueldo >= 0) {
                    sueldos[i] = sueldo;
                    sueldoValido = true;
                } else {
                    System.out.println("Error: El sueldo no puede ser negativo. Intente de nuevo.");
                }
            } while (!sueldoValido);
        }

        System.out.println("\nSueldos ingresados:");
        for (int i = 0; i < numEmpleados; i++) {
            System.out.println("Empleado " + (i + 1) + ": $" + sueldos[i]);
        }

        scanner.close();
    }
}

