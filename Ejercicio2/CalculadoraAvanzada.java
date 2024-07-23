package Ejercicio2;

public class CalculadoraAvanzada {
    public double potencia(double base, double exponente) {
        return Math.pow(base, exponente);
    }

    public double opuesto(double numero) {
        return -numero;
    }

    public int factorial(int numero) {
        if (numero < 0) {
            throw new IllegalArgumentException("El número debe ser no negativo.");
        }
        int resultado = 1;
        for (int i = 1; i <= numero; i++) {
            resultado *= i;
        }
        return resultado;
    }

    public static void main(String[] args) {
        CalculadoraAvanzada cavanzada = new CalculadoraAvanzada();
        System.out.println("Potencia: " + cavanzada.potencia(2, 3));
        System.out.println("Opuesto: " + cavanzada.opuesto(5));
        System.out.println("Factorial: " + cavanzada.factorial(5));
    }
}
