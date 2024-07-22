package InformacionBasica;
import  javax.swing.JOptionPane;

public class CajaTexto {
    public static void main(String[] args) {

        String nombres = JOptionPane.showInputDialog("Ingrese sus nombres:");

        // Solicitar apellidos
        String apellidos = JOptionPane.showInputDialog("Ingrese sus apellidos:");

        // Solicitar edad
        String edadStr = JOptionPane.showInputDialog("Ingrese su edad:");
        int edad = Integer.parseInt(edadStr);

        // Solicitar carrera
        String carrera = JOptionPane.showInputDialog("Ingrese su carrera:");

        // Crear el mensaje a mostrar con saltos de línea entre cada dato
        String mensaje = "Información ingresada:\n" +
                "Nombres: " + nombres + "\n" +
                "Apellidos: " + apellidos + "\n" +
                "Edad: " + edad + "\n" +
                "Carrera: " + carrera;

        // Mostrar la información ingresada en una sola caja de texto
        JOptionPane.showMessageDialog(null, mensaje, "Información Básica", JOptionPane.INFORMATION_MESSAGE);

        System.exit(0);
    }
}
