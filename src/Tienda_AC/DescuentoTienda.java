package Tienda_AC;
import java.util.Scanner;

public class DescuentoTienda {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Monto compra

        System.out.println("Ingrese el valor de la compra: ");
        double compra = sc.nextDouble();

        //Color bolita

        System.out.println("Ingrese el color de la bolita: ");
        String bolita = sc.next().toLowerCase();

        //Descuento y total a pagar

        double descuento = 0;
        switch (bolita){
            case "roja":
                descuento = (compra * 0.10);
                compra -= descuento;

                System.out.println("Se hizo un descuento del 10%. El valor de la compra es: " + compra);
                break;
            case "verde":
                    descuento = (compra * 0.05);
                    compra -= descuento;

                    System.out.println("Se aplico un descuento del 5%. El valor de la compra es: " + compra);
                    break;
            case "blanca":

                System.out.println("No se aplico descuento. Gracias por participar");
                break;
            default:
                System.out.println("El color no es valido");
                break;
        }
        sc.close();
    }
}
