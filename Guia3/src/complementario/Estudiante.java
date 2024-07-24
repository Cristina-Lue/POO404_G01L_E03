package complementario;
import java.util.Scanner;
public class Estudiante {
    public class Estudiante {
        private String nombre;
        private String carnet;
        private String direccion;
        private String telefono;
        private String[] materias;

        // Constructor para inicializar los datos personales del estudiante
        public Estudiante(String nombre, String carnet, String direccion, String telefono) {
            this.nombre = nombre;
            this.carnet = carnet;
            this.direccion = direccion;
            this.telefono = telefono;
            this.materias = new String[5]; // Inicializar el arreglo de materias
        }

        // Método para ingresar las materias que cursa el estudiante
        public void ingresarMaterias() {
            Scanner scanner = new Scanner(System.in);
            for (int i = 0; i < 5; i++) {
                System.out.print("Ingrese la materia " + (i + 1) + ": ");
                materias[i] = scanner.nextLine();
            }
        }

        // Método para mostrar toda la información del estudiante
        public void mostrarInformacion() {
            System.out.println("Nombre: " + nombre);
            System.out.println("Carnet: " + carnet);
            System.out.println("Dirección: " + direccion);
            System.out.println("Teléfono: " + telefono);
            System.out.println("Materias:");
            for (String materia : materias) {
                System.out.println(" - " + materia);
            }
        }
    }

}
