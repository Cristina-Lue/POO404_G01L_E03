package Map_AC;

public class Estudiante {
    private String carnet;
    private String nombre;
    private String apellido;

    public Estudiante(String carnet, String nombre, String apellido) {
        this.carnet = carnet;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getCarnet() {
        return carnet;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    @Override
    public String toString() {
        return "Carnet: " + carnet + ", Nombre: " + nombre + ", Apellido: " + apellido;
    }
}