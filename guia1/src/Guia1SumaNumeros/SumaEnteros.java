package Guia1SumaNumeros;
//importa el uso de la clase JOptionPane
import javax.swing.JOptionPane;//genera cuadros de dialogo para usuario
public class SumaEnteros {
    public static void main(String[] args){
        //Declaracion a 2 variables de tipo cadena (String)
        String primernumero;
        String segundonumero;
        //Declaracion a 3 variables de tipo entero (int)
        int numero1, numero2 , suma ;
        System.out.println("Aplicacion para sumar 2 numeros enteros\n");
        //genere cuadros de dialogo para ingresar numeros (como String)
        primernumero=JOptionPane.showInputDialog("Digite el primer numero ");
        segundonumero=JOptionPane.showInputDialog("Digite el segundo numero");
        //Convierte cada String a un numero entero
        numero1=Integer.parseInt(primernumero);
        numero2=Integer.parseInt(segundonumero);
        //Comprueba si algún número es negativo
        if (numero1 < 0 || numero2 < 0) {
            JOptionPane.showMessageDialog(null, "No se pueden ingresar números negativos.", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);}
        System.out.println("Los numeros son" +numero1+ "y" +numero2);
        //realiza la operacion de sumar los 2 numeros enteros ingresados por usuario
        suma=numero1 + numero2;
        //genera un cuadro de dialogo para presentar el resultado de la suma realizada
        JOptionPane.showMessageDialog(null,"La suma de" +numero1+"y"+numero2+"es de" +suma, "Resultado de la Suma",JOptionPane.PLAIN_MESSAGE);
        System.exit(0);
    }
}
