package Calculadoras;

public class PruebaCalculadoras {
    public static void main(String[] args) {
        // Pruebas con CalculadoraBasica
        CalculadoraBasica cbasica = new CalculadoraBasica();
        System.out.println("Suma: " + cbasica.suma(10, 5));
        System.out.println("Resta: " + cbasica.resta(10, 5));
        System.out.println("Multiplicación: " + cbasica.multiplicacion(10, 5));
        System.out.println("División: " + cbasica.division(10, 5));

        // Pruebas con CalculadoraAvanzada
        CalculadoraAvanzada cavanzada = new CalculadoraAvanzada();
        System.out.println("Potencia: " + cavanzada.potencia(2, 3));
        System.out.println("Opuesto: " + cavanzada.opuesto(5));
        System.out.println("Factorial: " + cavanzada.factorial(4));
    }
}
