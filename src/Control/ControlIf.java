package Control;
import java.util.*;

public class ControlIf {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int Var1, Var2;
        System.out.print("Ingrese numero 1: ");
        Var1 = reader.nextInt();
        System.out.print("Ingrese numero 2: ");
        Var2 = reader.nextInt();
        if (Var1 == Var2) {
            System.out.print("Los numeros ingresados son iguales ");
        } else {
            System.out.println("Los numeros ingresados No son iguales ");
        }
    }
}
