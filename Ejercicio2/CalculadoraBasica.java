package Ejercicio2;

public class CalculadoraBasica {
    public double suma(double numero1, double numero2) {
        return numero1 + numero2;
    }

    public double resta(double numero1, double numero2) {
        return numero1 - numero2;
    }

    public double multiplicacion(double numero1, double numero2) {
        return numero1 * numero2;
    }

    public double division(double numero1, double numero2) {
        if (numero2 == 0) {
            throw new ArithmeticException("No se puede dividir por cero.");
        }
        return numero1 / numero2;
    }

    public static void main(String[] args) {
        CalculadoraBasica cbasica = new CalculadoraBasica();
        System.out.println("Suma: " + cbasica.suma(5, 3));
        System.out.println("Resta: " + cbasica.resta(5, 3));
        System.out.println("Multiplicación: " + cbasica.multiplicacion(5, 3));
        System.out.println("División: " + cbasica.division(5, 3));
    }
}
