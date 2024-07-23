import javax.swing.JOptionPane;
public class Parte3com {
    public class InformacionBasica {
        public static void main(String[] args) {
            // Solicitar los nombres
            String nombres = JOptionPane.showInputDialog("Ingrese sus nombres:");
            if (nombres == null || nombres.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Los nombres no pueden estar vacíos.", "Error", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }

            // Solicitar los apellidos
            String apellidos = JOptionPane.showInputDialog("Ingrese sus apellidos:");
            if (apellidos == null || apellidos.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Los apellidos no pueden estar vacíos.", "Error", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }

            // Solicitar la edad
            String edadStr = JOptionPane.showInputDialog("Ingrese su edad:");
            if (edadStr == null || edadStr.trim().isEmpty() || !edadStr.matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "La edad debe ser un número positivo.", "Error", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
            int edad = Integer.parseInt(edadStr); // Convertir la edad a entero

            // Solicitar la carrera
            String carrera = JOptionPane.showInputDialog("Ingrese su carrera:");
            if (carrera == null || carrera.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "La carrera no puede estar vacía.", "Error", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }

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
