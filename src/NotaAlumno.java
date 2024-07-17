import javax.swing.*;

public class NotaAlumno {
    public static void main(String[] args) {
        String input;
        double nota;

        // Solicitar la nota del alumno
        input = JOptionPane.showInputDialog("Ingrese la nota del alumno:");
        nota = Double.parseDouble(input);

        // Verificar la nota y mostrar el mensaje correspondiente
        if (nota >= 7.0) {
            JOptionPane.showMessageDialog(null, "El alumno ha aprobado la materia.");
        } else if (nota >= 6.5 && nota < 7.0) {
            JOptionPane.showMessageDialog(null, "El alumno puede realizar un examen de suficiencia para aprobar.");
        } else {
            JOptionPane.showMessageDialog(null, "El alumno no ha aprobado la materia.");
        }
    }
}
