import javax.swing.JOptionPane;

public class PruebaTiempo1 {
    public static void main(String[] args) {
        String salida = "";

        // Crear instancia de Tiempo1 con valores válidos
        Tiempo1 tiempo = new Tiempo1(13, 27, 6);

        // Obtener y concatenar la hora universal y estándar a la salida
        salida += "\n\nLa hora universal después de establecerHora es: " +
                tiempo.aStringUniversal() +
                "\nLa hora estándar después de establecerHora es: " + tiempo.aStringEstandar();

        try {
            // Establecer tiempo con valores inválidos; anexar hora actualizada a salida
            tiempo.establecerHora(99, 99, 99);
            salida += "\n\nDespués de intentar ajustes inválidos: " +
                    "\nHora universal: " + tiempo.aStringUniversal() +
                    "\nHora estándar: " + tiempo.aStringEstandar();
        } catch (IllegalArgumentException e) {
            salida += "\n\nSe intentó establecer un tiempo inválido:\n" + e.getMessage();
        }

        // Mostrar salida en un mensaje de diálogo
        JOptionPane.showMessageDialog(null, salida, "Prueba de la clase Tiempo1", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
