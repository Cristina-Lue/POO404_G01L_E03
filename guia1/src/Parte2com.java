import javax.swing.JOptionPane;
public class Parte2com {
    public class InformacionBasica {
        public static void main(String[] args) {
            // Solicitar los nombres
            String nombres = JOptionPane.showInputDialog("Ingrese sus nombres:");

            // Solicitar los apellidos
            String apellidos = JOptionPane.showInputDialog("Ingrese sus apellidos:");

            // Solicitar la edad
            String edadStr = JOptionPane.showInputDialog("Ingrese su edad:");
            int edad = Integer.parseInt(edadStr); // Convertir la edad a entero

            // Solicitar la carrera
            String carrera = JOptionPane.showInputDialog("Ingrese su carrera:");

            // Construir el mensaje con los datos ingresados
            String mensaje = "Información ingresada:\n"
                    + "Nombres: " + nombres + "\n"
                    + "Apellidos: " + apellidos + "\n"
                    + "Edad: " + edad + "\n"
                    + "Carrera: " + carrera;

            // Mostrar el mensaje en una sola caja de texto
            JOptionPane.showMessageDialog(null, mensaje, "Información Básica", JOptionPane.INFORMATION_MESSAGE);

            // Salir del programa
            System.exit(0);
        }
    }

}
