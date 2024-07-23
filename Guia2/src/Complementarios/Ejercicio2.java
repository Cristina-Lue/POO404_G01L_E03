package Complementarios;
import java.util.Scanner;
public class Ejercicio2 {
    public class DescuentoTienda {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Solicitar el monto total de la compra
            System.out.print("Ingrese el monto total de la compra: ");
            double montoCompra = scanner.nextDouble();

            // Solicitar el color de la bolita
            System.out.print("Ingrese el color de la bolita (rojo, verde, blanco): ");
            String colorBolita = scanner.next().toLowerCase();

            // Inicializar el descuento
            double descuento = 0.0;

            // Determinar el descuento basado en el color de la bolita
            switch (colorBolita) {
                case "rojo":
                    descuento = 0.10;
                    break;
                case "verde":
                    descuento = 0.05;
                    break;
                case "blanco":
                    descuento = 0.0;
                    break;
                default:
                    System.out.println("Color de bolita no válido.");
                    scanner.close();
                    return; // Terminar el programa si el color de la bolita no es válido
            }

            // Calcular el monto del descuento
            double montoDescuento = montoCompra * descuento;
            double montoFinal = montoCompra - montoDescuento;

            // Mostrar el resultado
            if (descuento > 0) {
                System.out.printf("Se le ha aplicado un descuento del %.0f%%.\n", descuento * 100);
                System.out.printf("Monto del descuento: $%.2f\n", montoDescuento);
            } else {
                System.out.println("No se le ha aplicado descuento. Gracias por participar.");
            }
            System.out.printf("Monto final a pagar: $%.2f\n", montoFinal);

            // Cerrar el scanner
            scanner.close();
        }
    }

}
