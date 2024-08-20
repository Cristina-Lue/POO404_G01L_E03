import java.util.InputMismatchException;
import java.util.Scanner;

public class CajeroElectronico {

    static class Cuenta {
        int numeroCuenta;
        double saldo;

        Cuenta(int numeroCuenta, double saldo) {
            this.numeroCuenta = numeroCuenta;
            this.saldo = saldo;
        }
    }

    public static void main(String[] args) {
        Cuenta[] cuentas = {
                new Cuenta(1000001, 400),
                new Cuenta(1000002, 200),
                new Cuenta(1000004, 500)
        };
    }

    Scanner scanner = new Scanner(System.in);
    int numeroCuenta = leerEnteroConValidacion(scanner, "Ingrese su número de cuenta: ");
    Cuenta cuenta = buscarCuenta(cuentas, numeroCuenta);

        if(cuenta ==null)

    {
        System.out.println("Número de cuenta inválido. Por favor, intente de nuevo.");
        return;
    }

        System.out.println("Bienvenido al cajero automático!");

    boolean continuar = true;
        while(continuar)

    {
        mostrarMenu();
        int opcion = leerEnteroConValidacion(scanner, "Seleccione una opción: ");
        switch (opcion) {
            case 1:
                System.out.println("El saldo actual de la cuenta " + cuenta.numeroCuenta + " es de $" + cuenta.saldo);
                break;

            case 2:
                double retiro = leerDoubleConValidacion(scanner, "Ingrese la cantidad a retirar: ");
                if (retiro <= cuenta.saldo) {
                    cuenta.saldo -= retiro;
                    System.out.println("Retiro exitoso. El saldo actual de la cuenta " + cuenta.numeroCuenta + " es de $" + cuenta.saldo);
                } else {
                    System.out.println("Fondos insuficientes.");
                }
                break;

            case 3:
                double consignacion = leerDoubleConValidacion(scanner, "Ingrese la cantidad a consignar: ");
                cuenta.saldo += consignacion;
                System.out.println("Consignación exitosa. El saldo actual de la cuenta " + cuenta.numeroCuenta + " es de $" + cuenta.saldo);
                break;

            case 4:
                int cuentaDestino = leerEnteroConValidacion(scanner, "Ingrese el número de cuenta de destino: ");
                double transferencia = leerDoubleConValidacion(scanner, "Ingrese la cantidad a transferir: ");

                Cuenta cuentaTransferencia = buscarCuenta(cuentas, cuentaDestino);
                if (cuentaTransferencia != null && transferencia <= cuenta.saldo) {
                    cuenta.saldo -= transferencia;
                    cuentaTransferencia.saldo += transferencia;
                    System.out.println("Transferencia exitosa. El saldo actual de la cuenta " + cuenta.numeroCuenta + " es de $" + cuenta.saldo);
                } else if (cuentaTransferencia == null) {
                    System.out.println("Número de cuenta de destino inválido.");
                } else {
                    System.out.println("Fondos insuficientes.");
                }
                break;

            case 5:
                continuar = false;
                System.out.println("Gracias por usar el cajero automático. ¡Que tenga un buen día!");
                break;

            default:
                System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                break;
        }
        scanner.close();
    }
