package Ejercicio3;

public class Animal {
    private String nombre;
    private int edad;
    private String alimento;

    public Animal(String nombre, int edad, String alimento) {
        this.nombre = nombre;
        this.edad = edad;
        this.alimento = alimento;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getAlimento() {
        return alimento;
    }

    public void mostrarDatos() {
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

    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Color de Plumas: " + colorPlumas);
    }
}

class Perro extends Animal {
    private String colorPelaje;

    public Perro(String nombre, int edad, String alimento, String colorPelaje) {
        super(nombre, edad, alimento);
        this.colorPelaje = colorPelaje;
    }

    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Color de Pelaje: " + colorPelaje);
    }
}

class Gato extends Animal {
    private String colorOjos;

    public Gato(String nombre, int edad, String alimento, String colorOjos) {
        super(nombre, edad, alimento);
        this.colorOjos = colorOjos;
    }

    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Color de Ojos: " + colorOjos);
    }
}

class Hamster extends Animal {
    private int cantidadPulgas;

    public Hamster(String nombre, int edad, String alimento, int cantidadPulgas) {
        super(nombre, edad, alimento);
        this.cantidadPulgas = cantidadPulgas;
    }

    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Cantidad de Pulgas: " + cantidadPulgas);
    }
}
class Animales {
    public static void main(String[] args) {
        Gallo gallo = new Gallo("Pedro", 2, "Maíz", "Rojo");
        Perro perro = new Perro("Simbad", 5, "Croquetas", "Negro");
        Gato gato = new Gato("Lulu", 3, "Pescado", "Verde");
        Hamster hamster = new Hamster("Pancho", 1, "Semillas", 10);

        gallo.mostrarDatos();
        System.out.println();
        perro.mostrarDatos();
        System.out.println();
        gato.mostrarDatos();
        System.out.println();
        hamster.mostrarDatos();
    }
}
