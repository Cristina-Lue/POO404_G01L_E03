class Animal {
    protected String nombre;
    protected int edad;
    protected String alimento;

    public Animal(String nombre, int edad, String alimento) {
        this.nombre = nombre;
        this.edad = edad;
        this.alimento = alimento;
    }

    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad + " años");
        System.out.println("Alimento: " + alimento);
    }
}

class Gallo extends Animal {
    private String colorPlumas;

    public Gallo(String nombre, int edad, String alimento, String colorPlumas) {
        super(nombre, edad, alimento);
        this.colorPlumas = colorPlumas;
    }


    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Color de plumas: " + colorPlumas);
    }
}

class Perro extends Animal {
    private String colorPelaje;

    public Perro(String nombre, int edad, String alimento, String colorPelaje) {
        super(nombre, edad, alimento);
        this.colorPelaje = colorPelaje;
    }


    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Color de pelaje: " + colorPelaje);
    }
}

class Gato extends Animal {
    private String colorOjos;

    public Gato(String nombre, int edad, String alimento, String colorOjos) {
        super(nombre, edad, alimento);
        this.colorOjos = colorOjos;
    }


    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Color de ojos: " + colorOjos);
    }
}

class Hamster extends Animal {
    private int cantidadPulgas;

    public Hamster(String nombre, int edad, String alimento, int cantidadPulgas) {
        super(nombre, edad, alimento);
        this.cantidadPulgas = cantidadPulgas;
    }


    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Cantidad de pulgas: " + cantidadPulgas);
    }
}

public class Animal_Main {
    public static void main(String[] args) {
        Gallo gallo = new Gallo("Pedro", 2, "Granos", "Rojo");
        Perro perro = new Perro("Rex", 5, "Croquetas", "Marrón");
        Gato gato = new Gato("Whiskers", 3, "Pescado", "Verde");
        Hamster hamster = new Hamster("Fuzzy", 1, "Semillas", 3);

        System.out.println("Información del Gallo:");
        gallo.mostrarInfo();
        System.out.println();

        System.out.println("Información del Perro:");
        perro.mostrarInfo();
        System.out.println();

        System.out.println("Información del Gato:");
        gato.mostrarInfo();
        System.out.println();

        System.out.println("Información del Hamster:");
        hamster.mostrarInfo();
    }
}
