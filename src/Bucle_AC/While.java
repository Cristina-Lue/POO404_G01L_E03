package Bucle_AC;
import javax.swing.*;

public class While {
    public static void main(String[] args)
    {
        String leer = JOptionPane.showInputDialog("Ingrese el número de empleados:");
        int empleados = Integer.parseInt(leer);

        double sueldo, mayor = 0, menor = 10000;
        int i = 1, contador = 0;

        while (i <= empleados) {
            leer = JOptionPane.showInputDialog("Ingrese el sueldo del empleado " + i + ":");
            sueldo = Double.parseDouble(leer);

            // Verificar que el sueldo no sea negativo
            while (sueldo < 0) {
                leer = JOptionPane.showInputDialog("Error: El sueldo no puede ser negativo. Ingrese el sueldo del empleado " + i + " :");
                sueldo = Double.parseDouble(leer);
            }


            if (sueldo > 300) {
                contador++;
            }
            if (sueldo > mayor) {
                mayor = sueldo;
            }
            if (sueldo < menor) {
                menor = sueldo;
            }

            i++;
        }

        // resultados
        JOptionPane.showMessageDialog(null, "El sueldo mayor es de $: " + mayor +
                "\nEl sueldo menor es de $: " + menor +
                "\n" + contador + " empleados tienen un sueldo mayor de $300");
    }
}

