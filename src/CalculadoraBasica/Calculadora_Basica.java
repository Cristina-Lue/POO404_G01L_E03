package CalculadoraBasica;

public class Calculadora_Basica {
    public static double suma(double x, double y) {
        return x + y;
    }

    public static double resta(double x, double y) {
        return x - y;
    }

    public static double multiplicacion(double x, double y) {
        return x * y;
    }

    public static double division(double x, double y) {
        if (y == 0) {
            throw new IllegalArgumentException("Error: No se puede dividir entre cero.");
        }
        return x / y;
    }

    public static void main(String[] args) {
        double Valor1 = 80;
        double Valor2 = 2;

        System.out.println("Suma: " + suma(Valor1, Valor2));
        System.out.println("Resta: " + resta(Valor1, Valor2));
        System.out.println("Multiplicación: " + multiplicacion(Valor1, Valor2));
        System.out.println("División: " + division(Valor1, Valor2));
    }

}
