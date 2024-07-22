package ejercicio3;
import javax.swing.JOptionPane;

public class Datos {
    public static void main(String[] args) {
        //ingreso de datos
        String nombre = JOptionPane.showInputDialog("Ingrese su nombre: ");
        String edad = JOptionPane.showInputDialog("Ingrese su edad: ");
        String sexo = JOptionPane.showInputDialog("Ingrese su sexo: ");

        String mensaje = "nombre: " + nombre + "\nedad: " + edad + "\nsexo: " + sexo;

        JOptionPane.showMessageDialog(null, mensaje, "Informacion", JOptionPane.INFORMATION_MESSAGE);
    }
}
