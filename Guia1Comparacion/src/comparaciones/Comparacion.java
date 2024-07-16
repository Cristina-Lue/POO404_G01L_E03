package comparaciones;
import javax.swing.JOptionPane;

public class Comparacion {
    public static void main(String[] args) {

        String primernumero, segundonumero, resultado;
        int numero1, numero2;
        System.out.println("Programa para usar operadores relacionales en Java");

        primernumero = JOptionPane.showInputDialog("Escriba el primer entero:");
        segundonumero = JOptionPane.showInputDialog("Escriba el segundo Entero:");

        numero1 = Integer.parseInt(primernumero);
        numero2 = Integer.parseInt(segundonumero);

        resultado = "";

        if (numero1 == numero2) {
            resultado = resultado + numero1 + "igual que " + numero2;
        }
        if (numero1 != numero2) {
            resultado= resultado + numero1 + " distinto de " + numero2;
        }
        if (numero1 < numero2) {
            resultado= resultado + "\n" + numero1 + " < " + numero2;
        }
        if (numero1 > numero2) {
            resultado= resultado + "\n" + numero1 + " > " + numero2;
        }
        if (numero1 <= numero2) {
            resultado= resultado + "\n" + numero1 + " <= " + numero2;
        }
        if (numero1 > numero2) {
            resultado= resultado + "\n" + numero1 + " >= " + numero2;

            JOptionPane.showConfirmDialog(null, resultado,
                    "Resultado de la Comparacion", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }
}