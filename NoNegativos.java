package nonegativos;
import javax.swing.JOptionPane;

public class NoNegativos {
    public static void main(String[] args) {
        // Declara a 2 variables de tipo cadena (String)
        String primernumero;
        String segundonumero;
        // Declara a 3 variables de tipo entero (int)
        int numero1, numero2, suma;

        System.out.print("Aplicación para sumar 2 números\n");

        // Genera cuadros de diálogo para ingresar números (como String)
        primernumero = JOptionPane.showInputDialog("Digite el primer número");
        segundonumero = JOptionPane.showInputDialog("Digite el segundo número");

        // Convierte cada String a un número entero
        numero1 = Integer.parseInt(primernumero);
        numero2 = Integer.parseInt(segundonumero);

        // Verifica si alguno de los números es negativo
        if (numero1 < 0 || numero2 < 0) {
            JOptionPane.showMessageDialog(null, "No se pueden ingresar números negativos.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1); // Finaliza la aplicación con un código de error
        }

        System.out.println("Los números ingresados son " + numero1 + " y " + numero2);

    // Realiza la operación de sumar los 2 números enteros ingresados por el usuario
        suma = numero1 + numero2;

        JOptionPane.showMessageDialog(null, "La suma de " + numero1 +
                        " y " + numero2 + " es de " + suma,
                "Resultado de la suma", JOptionPane.PLAIN_MESSAGE);
        System.exit(0);
    }
}
