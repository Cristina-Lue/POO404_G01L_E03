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

        if (cuenta == null) {
        System.out.println("Número de cuenta inválido. Por favor, intente de nuevo.");
        return;
    }

        System.out.println("Bienvenido al cajero automático!");

    boolean continuar = true;
        while (continuar) {
        mostrarMenu();
        int opcion = leerEnteroConValidacion(scanner, "Seleccione una opción: ");
