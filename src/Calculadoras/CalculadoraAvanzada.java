package Calculadoras;

public class CalculadoraAvanzada {

    // Método para potencia
    public double potencia(double base, double exponente) {
        return Math.pow(base, exponente);
    }

    // Método para opuesto
    public double opuesto(double numero) {
        return -numero;
    }

    // Método para factorial
    public int factorial(int numero) {
        if (numero < 0) {
            throw new IllegalArgumentException("El factorial no está definido para números negativos");
        }
        int factorial = 1;
        for (int i = 1; i <= numero; i++) {
            factorial *= i;
        }
        return factorial;
    }
}

