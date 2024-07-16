package sumanumeros;
import javax.swing.JOptionPane;


public class SumaEnteros {
    public static void main (String[] args){

        String primernumero;
        String segundonumero;

        int numero1, numero2, suma;

        System.out.println("Aplicacion para sumar 2 numeros enteros\n");

        primernumero = JOptionPane.showInputDialog("Digite el primer numero");
        segundonumero = JOptionPane.showInputDialog("Digite el segundo numero");

        numero1 = Integer.parseInt(primernumero);
        numero2 = Integer.parseInt(segundonumero);

        System.out.println("Los numero ingresados son "+numero1+ " y " + numero2);

        suma = numero1 + numero2;

        JOptionPane.showMessageDialog(null,
                "La suma de " + numero1 +" y " +numero2 +" es de " + suma, "Resultado de la suma ",JOptionPane.PLAIN_MESSAGE );
        System.exit(0);
    }

}
