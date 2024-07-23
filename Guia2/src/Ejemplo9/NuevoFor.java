package Ejemplo9;
import java.util.Scanner;
public class NuevoFor {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Solicitar el número de empleados
            System.out.print("Ingrese el número de empleados: ");
            int numEmpleados = scanner.nextInt();

            // Arreglo para almacenar los sueldos de los empleados
            double[] sueldos = new double[numEmpleados];

            // Leer los sueldos de los empleados
            for (int i = 0; i < numEmpleados; i++) {
                double sueldo;
                do {
                    System.out.print("Ingrese el sueldo del empleado " + (i + 1) + ": ");
                    sueldo = scanner.nextDouble();
                    if (sueldo < 0) {
                        System.out.println("Error: El sueldo no puede ser negativo. Intente de nuevo.");
                    }
                } while (sueldo < 0);
                sueldos[i] = sueldo;
            }

            // Calcular la suma de los sueldos usando un for clásico
            double suma = 0;
            for (int i = 0; i < numEmpleados; i++) {
                suma += sueldos[i];
            }
            System.out.println("Total con for clásico: " + suma);

            // Reinicializar la suma
            suma = 0;
            System.out.println("Suma reinicializada vale: " + suma);

            // Calcular la suma de los sueldos usando un for mejorado
            for (double sueldo : sueldos) {
                suma += sueldo;
            }
            System.out.println("Total con for mejorado: " + suma);

            // Cerrar el scanner
            scanner.close();
        }
    }




