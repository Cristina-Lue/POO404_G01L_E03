import javax.swing.*;

public class SentenciaIF {
    public static void main(String[] args) {
        String datos;
        double sueldo, afp = 0, isss, totalre, nsueldo, renta;

        // Solicitar el sueldo del empleado
        datos = JOptionPane.showInputDialog("Ingrese el sueldo del empleado(a):");
        sueldo = Double.parseDouble(datos);

        // Calcular el descuento de AFP si el sueldo es mayor a 300
        if (sueldo > 300) {
            afp = sueldo * 0.0625;
        }

        // Mostrar el sueldo y el descuento de AFP
        JOptionPane.showMessageDialog(null, "Este empleado tiene un sueldo de " + sueldo + " y el descuento del AFP es " + afp);

        // Solicitar el sexo del empleado
        datos = (String) JOptionPane.showInputDialog(null, "Ingrese el Sexo:\nSi es Masculino (M)\nSi es Femenino (F)",
                "Sexo del Empleado", JOptionPane.QUESTION_MESSAGE, null, // Icono por defecto
                new Object[]{"M", "F"}, "F"); // Opción por defecto

        // Calcular descuentos adicionales si es de sexo Masculino
        if ("M".equals(datos)) {
            isss = sueldo * 0.03;
            renta = sueldo * 0.10;
            totalre = afp + isss + renta;
            nsueldo = sueldo - totalre;

            // Mostrar los descuentos y el nuevo sueldo
            JOptionPane.showMessageDialog(null, "A este empleado se le detiene " + isss + " en concepto de ISSS\n" +
                    "Además se le retiene: " + renta + " en concepto de Renta\n" +
                    "Lo que hace un total de " + totalre + "\n" +
                    "Y su nuevo Sueldo es de: " + nsueldo);
        }
    }
}
