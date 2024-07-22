package InformacionBasica;
import javax.swing.JOptionPane;
public class Informacion {
    public static void main(String[] args) {
        String nombres = JOptionPane.showInputDialog("Ingrese sus nombres:");

        // Solicitar apellidos
        String apellidos = JOptionPane.showInputDialog("Ingrese sus apellidos:");

        // Solicitar edad
        String edadStr = JOptionPane.showInputDialog("Ingrese su edad:");
        int edad = Integer.parseInt(edadStr);

        // Solicitar carrera
        String carrera = JOptionPane.showInputDialog("Ingrese su carrera:");

        // Mostrar la información ingresada
        String mensaje = String.format(
                "Información ingresada:\nNombres: %s\nApellidos: %s\nEdad: %d\nCarrera: %s",
                nombres, apellidos, edad, carrera
        );
        JOptionPane.showMessageDialog(null, mensaje, "Información Básica", JOptionPane.INFORMATION_MESSAGE);

        System.exit(0);
    }
}
