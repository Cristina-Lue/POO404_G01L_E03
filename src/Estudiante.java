public class Estudiante {

    private String nombre;
    private String apellido;
    private int edad;
    private String[] materias;


    public Estudiante(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.materias = new String[5];
    }
    public void ingresarMateria(int indice, String materia) {
        if (indice >= 0 && indice < 5) {
            this.materias[indice] = materia;
        } else {
            System.out.println("Índice fuera de rango. Debe estar entre 0 y 4.");
        }
    }
    public void mostrarInformacion() {
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Apellido: " + this.apellido);
        System.out.println("Edad: " + this.edad);
        System.out.println("Materias:");
        for (String materia : this.materias) {
            System.out.println("- " + (materia != null ? materia : "No asignada"));
        }
    }
}