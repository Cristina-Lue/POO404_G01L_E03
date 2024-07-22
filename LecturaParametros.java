package usoparametros;

public class LecturaParametros {
    public static void main(String[] args) {
        if (args.length >= 2) {
            System.out.println("Parametro 1: " + args[0]);
            System.out.println("Parametro 2: " + args[1]);
        } else {
            System.out.println("Se necesitan al menos dos parámetros.");
        }
    }
}
