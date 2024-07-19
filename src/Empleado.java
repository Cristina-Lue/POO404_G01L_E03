import javax.swing.JOptionPane;

public class Empleado {
    private String nombre;
    private String apellido;

    // Método para mostrar el contenido de los atributos
    public void mostrarDatos() {
        JOptionPane.showMessageDialog(null, nombre + " " + apellido);
    }

    // Método para cambiar los datos de los atributos
    public void ingresoDatos() {
        nombre = JOptionPane.showInputDialog("Ingrese el Nombre");
        apellido = JOptionPane.showInputDialog("Ingrese el Apellido");
    }
}
