package complementario;

public class CalculadoraAvanzada {
        // Método para calcular la potencia de un número
        public double potencia(double base, double exponente) {
            return Math.pow(base, exponente);
        }

        // Método para calcular el opuesto de un número
        public double opuesto(double numero) {
            return -numero;
        }

        // Método para calcular el factorial de un número
        public long factorial(int numero) {
            if (numero < 0) {
                throw new IllegalArgumentException("El factorial no está definido para números negativos");
            }
            long resultado = 1;
            for (int i = 1; i <= numero; i++) {
                resultado *= i;
            }
            return resultado;
        }

        public static void main(String[] args) {
            CalculadoraAvanzada cavanzada = new CalculadoraAvanzada();
            System.out.println("Potencia: " + cavanzada.potencia(2, 3));
            System.out.println("Opuesto: " + cavanzada.opuesto(5));
            System.out.println("Factorial: " + cavanzada.factorial(4));
        }
    }
    
