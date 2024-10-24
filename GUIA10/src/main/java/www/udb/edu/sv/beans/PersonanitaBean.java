package www.udb.edu.sv.beans;

public class PersonanitaBean {
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private String nombre;

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    private int edad;
    public String getTipo() {
        if (edad < 40)return "joven";
        return "no joven";
    }
    public boolean getJoven() {
        if (edad < 40){
            return true;
        }
        return false;
    }
}
