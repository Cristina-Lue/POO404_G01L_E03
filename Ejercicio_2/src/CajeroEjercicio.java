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


