import javax.swing.JOptionPane;

// Clase Profesor que hereda de Empleado
class Profesor extends Empleado {
    private int sueldo;

    // Método para mostrar los datos del profesor (incluyendo sueldo)
    public void mostrar2() {
        mostrarDatos(); // Método heredado de Empleado
        JOptionPane.showMessageDialog(null, "Sueldo: " + sueldo);
    }

    // Método para ingresar los datos del profesor (incluyendo sueldo)
    public void ingreso2() {
        ingresoDatos(); // Método heredado de Empleado
        String s = JOptionPane.showInputDialog("Ingrese el sueldo");
        sueldo = Integer.parseInt(s);
    }
}
