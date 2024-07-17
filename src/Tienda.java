public class Tienda {

    public static double aplicarDescuento(String colorBolita, double totalCompra) {
        double descuento = 0.0;

        switch (colorBolita.toLowerCase()) {
            case "rojo":
                descuento = 0.10;
                break;
            case "verde":
                descuento = 0.05;
                break;
            case "blanco":
                descuento = 0.0;
                break;
            default:
                System.out.println("Color de bolita no válido. No se aplicará descuento.");
                return totalCompra;
        }

        double totalConDescuento = totalCompra * (1 - descuento);
        return totalConDescuento;
    }

    public static void main(String[] args) {
        double totalCompra = 100.0; // ejemplo de total de compra
        String colorBolita = "rojo"; // ejemplo de color de bolita

        double totalConDescuento = aplicarDescuento(colorBolita, totalCompra);
        System.out.println("Total de la compra con descuento: " + totalConDescuento);
    }
}
