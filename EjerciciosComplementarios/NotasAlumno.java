package EjerciciosComplementarios;
import javax.swing.JOptionPane;

public class NotasAlumno {
    public static void main(String[] args) {
        String notaStr = JOptionPane.showInputDialog("Ingrese la nota del alumno:");

        // Convertir la nota a un valor numérico
        double nota = Double.parseDouble(notaStr);

        // Determinar el resultado según la nota ingresada
        String mensaje;
        if (nota >= 7.0) {
            mensaje = "El alumno aprobó la materia.";
        } else if (nota >= 6.50 && nota < 7.0) {
            mensaje = "El alumno tiene la posibilidad de realizar un examen de suficiencia para aprobar.";
        } else {
            mensaje = "El alumno no aprobó la materia.";
        }

        // Mostrar el mensaje
        JOptionPane.showMessageDialog(null, mensaje, "Resultado de Evaluación", JOptionPane.INFORMATION_MESSAGE);

        System.exit(0);
    }
}
