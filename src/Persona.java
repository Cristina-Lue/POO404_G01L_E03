import javax.swing.JOptionPane;

class Persona {
    // Atributos
    private String nombre;
    private String apellido;
    private String edad;

    // Constructor por defecto
    public Persona() {
        nombre = "Rafael";
        apellido = "Torres";
        edad = "23";
    }

    // Constructor con parámetros
    public Persona(String nombre, String apellido, String edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    // Método para ingresar datos desde JOptionPane
    public void ingresoDatos() {
        nombre = JOptionPane.showInputDialog("Ingrese el Nombre");
        apellido = JOptionPane.showInputDialog("Ingrese el Apellido");
        edad = JOptionPane.showInputDialog("Ingrese su edad");
    }

    // Método para mostrar los datos
    public void mostrarDatos() {
        System.out.println("Su nombre es: " + nombre);
        System.out.println("Su Apellido es: " + apellido);
        System.out.println("Su edad es: " + edad);
        System.out.println("****************************");
    }

    public static void main(String[] args) {
        // Instancia del objeto obj1 usando el constructor por defecto
        Persona obj1 = new Persona();
        // Instancia del objeto obj2 usando el constructor con parámetros
        Persona obj2 = new Persona("Manuel", "Valdez", "25");

        // Llamamos al método mostrarDatos de obj1
        obj1.mostrarDatos();

        // Cambiamos valores de los atributos de obj1
        obj1.ingresoDatos();

        // Llamamos al método mostrarDatos de obj1 después de cambiar los datos
        obj1.mostrarDatos();

        // Llamamos al método mostrarDatos de obj2
        obj2.mostrarDatos();

        // Ejemplo de modificación directa de un atributo y llamada a mostrarDatos
        obj1.apellido = "Sanchez";
        obj1.mostrarDatos();
    }
}
