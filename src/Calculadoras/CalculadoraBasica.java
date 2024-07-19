package Calculadoras;

public class CalculadoraBasica {

    // Método para suma
    public double suma(double numero1, double numero2) {
        return numero1 + numero2;
    }

    // Método para resta
    public double resta(double numero1, double numero2) {
        return numero1 - numero2;
    }

    // Método para multiplicación
    public double multiplicacion(double numero1, double numero2) {
        return numero1 * numero2;
    }

    // Método para división
    public double division(double numero1, double numero2) {
        if (numero2 == 0) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        }
        return numero1 / numero2;
    }
}

