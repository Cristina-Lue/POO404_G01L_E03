package Ejercicio3;

public class Empresa {
        public static void main(String[] args) {
            Empleado emp1 = new Empleado("Stefany Carbajal", 3000);
            Gerente ger1 = new Gerente("Lucia Hernandez", 5000, 2000);
            Desarrollador dev1 = new Desarrollador("Aslly Hernandez", 1000, 500);
                
            System.out.println("Información del Empleado:");
            emp1.mostrarInfo();
            System.out.println();

            System.out.println("Información del Gerente:");
            ger1.mostrarInfo();
            System.out.println();
                
            System.out.println("Información del desarrollador:");
              dev1.mostrarInfo();
                
        }
}
