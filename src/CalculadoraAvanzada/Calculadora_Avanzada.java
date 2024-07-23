package CalculadoraAvanzada;

public class Calculadora_Avanzada {

    public static double potencia(double Numero1, double Expo) {
        return Math.pow(Numero1, Expo);
    }

    public static double opuesto(double numero) {
        return -numero;
    }

    public static int factorial(int numero) {
        if (numero < 0) {
            throw new IllegalArgumentException("El factorial no está definido para números negativos.");
        }
        if (numero == 0 || numero == 1) {
            return 1;
        }

        int resultado = 1;
        for (int i = 2; i <= numero; i++) {
            resultado *= i;
        }
        return resultado;
    }

    public static void main(String[] args) {
        double Numero1 = 10;
        double Expo = 2;
        double numeroOpuesto = 9;
        int numeroFactorial = 8;

        System.out.println("Potencia de su numero: " + potencia(Numero1, Expo));
        System.out.println("Opuesto de su numero: " + opuesto(numeroOpuesto));
        System.out.println("Factorial de su numero: " + factorial(numeroFactorial));
    }
}
