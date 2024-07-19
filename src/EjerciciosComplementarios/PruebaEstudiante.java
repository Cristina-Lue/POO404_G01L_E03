package EjerciciosComplementarios;

public class PruebaEstudiante {
    public static void main(String[] args) {
        // Crear instancia de Estudiante
        Estudiante estudiante = new Estudiante("Juan", "Pérez", 20);

        // Ingresar las materias
        estudiante.ingresarMaterias();

        // Mostrar toda la información del estudiante
        estudiante.mostrarInformacion();
    }
}
