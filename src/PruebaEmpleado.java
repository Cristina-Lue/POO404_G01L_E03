import javax.swing.JOptionPane;

public class PruebaEmpleado {
    public static void main(String[] args) {
        Empleado emp = new Empleado(); // Objeto de tipo Empleado
        Profesor pro = new Profesor(); // Objeto de tipo Profesor

        JOptionPane.showMessageDialog(null, "Clase Empleado");

        // Utilizando los métodos de Empleado
        emp.ingresoDatos();
        emp.mostrarDatos();

        JOptionPane.showMessageDialog(null, "Clase Profesor");

        // Utilizando los métodos de Profesor
        pro.ingreso2();
        pro.mostrar2();
    }
}
