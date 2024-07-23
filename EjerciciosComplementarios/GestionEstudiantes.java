package EjerciciosComplementarios;
import javax.swing.JOptionPane;
import java.util.HashMap;

public class GestionEstudiantes {
    public static void main(String[] args) {

        HashMap<String, String> estudiantes = new HashMap<>();

        while (true) {
            String opcion = JOptionPane.showInputDialog(
                    "Seleccione una opción:\n" +
                            "1. Ingreso de estudiante\n" +
                            "2. Ver estudiantes\n" +
                            "3. Buscar estudiante\n" +
                            "4. Salir"
            );

            if (opcion == null || opcion.equals("4")) {
                JOptionPane.showMessageDialog(null, "Saliendo de la aplicación.");
                break;
            }
            switch (opcion) {
                case "1":
                    // Ingreso de estudiante
                    String carnet = JOptionPane.showInputDialog("Ingrese el carnet del estudiante:");
                    if (carnet != null && !carnet.trim().isEmpty()) {
                        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del estudiante:");
                        if (nombre != null && !nombre.trim().isEmpty()) {
                            estudiantes.put(carnet, nombre);
                            JOptionPane.showMessageDialog(null, "Estudiante ingresado con éxito.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Nombre no válido.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Carnet no válido.");
                    }
                    break;
                case "2":
                    // Ver todos los estudiantes
                    StringBuilder listaEstudiantes = new StringBuilder("Lista de Estudiantes:\n");
                    for (String key : estudiantes.keySet()) {
                        listaEstudiantes.append("Carnet: ").append(key)
                                .append(", Nombre: ").append(estudiantes.get(key)).append("\n");
                    }
                    JOptionPane.showMessageDialog(null, listaEstudiantes.toString());
                    break;

                case "3":
                    // Buscar estudiante
                    carnet = JOptionPane.showInputDialog("Ingrese el carnet del estudiante a buscar:");
                    if (carnet != null && !carnet.trim().isEmpty()) {
                        String nombre = estudiantes.get(carnet);
                        if (nombre != null) {
                            JOptionPane.showMessageDialog(null, "Carnet: " + carnet + ", Nombre: " + nombre);
                        } else {
                            JOptionPane.showMessageDialog(null, "Estudiante no encontrado.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Carnet no válido.");
                    }
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Intente de nuevo.");
                    break;
            }

        }
    }
}