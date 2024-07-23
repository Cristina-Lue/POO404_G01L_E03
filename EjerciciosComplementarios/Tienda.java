package EjerciciosComplementarios;
import javax.swing.JOptionPane;

public class Tienda {
    public static void main(String[] args) {

        String montoStr = JOptionPane.showInputDialog("Ingrese el monto de la compra:");
        double monto = Double.parseDouble(montoStr);
        String[] opciones = {"Roja", "Verde", "Blanca"};
        String color = (String) JOptionPane.showInputDialog(null,
                "Seleccione el color de la bolita:",
                "Descuento por Bolita",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]);
        double descuento = 0;
        String mensaje;

        switch (color) {
            case "Roja":
                descuento = 0.10;
                mensaje = "Se le aplica un 10% de descuento.";
                break;
            case "Verde":
                descuento = 0.05;
                mensaje = "Se le aplica un 5% de descuento.";
                break;
            case "Blanca":
                mensaje = "No tiene descuento. Gracias por participar.";
                break;
            default:
                mensaje = "Color de bolita no válido.";
                break;
        }
        double montoFinal = monto * (1 - descuento);

        if (descuento > 0) {
            mensaje += String.format("\nEl monto original es: $%.2f\nEl monto final con descuento es: $%.2f", monto, montoFinal);
        } else {
            mensaje += String.format("\nEl monto a pagar es: $%.2f", monto);
        }

        JOptionPane.showMessageDialog(null, mensaje, "Resultado de Descuento", JOptionPane.INFORMATION_MESSAGE);

        System.exit(0);

    }
}
