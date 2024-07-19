public class Animal {

    static class Gallo extends Animal {
        private String colorPlumas;

        public Gallo(String nombre, int edad, String alimento, String colorPlumas) {
            super(nombre, edad, alimento);
            this.colorPlumas = colorPlumas;
        }

        @Override
        public void mostrarDatos() {
            super.mostrarDatos();
            System.out.println("Color de plumas: " + colorPlumas);
        }
    }

    static class Perro extends Animal {
        private String colorPelaje;

        public Perro(String nombre, int edad, String alimento, String colorPelaje) {
            super(nombre, edad, alimento);
            this.colorPelaje = colorPelaje;
        }

        @Override
        public void mostrarDatos() {
            super.mostrarDatos();
            System.out.println("Color de pelaje: " + colorPelaje);
        }
    }

    static class Gato extends Animal {
        private String colorOjos;

        public Gato(String nombre, int edad, String alimento, String colorOjos) {
            super(nombre, edad, alimento);
            this.colorOjos = colorOjos;
        }

        @Override
        public void mostrarDatos() {
            super.mostrarDatos();
            System.out.println("Color de ojos: " + colorOjos);
        }
    }

    static class Hamster extends Animal {
        private int cantidadPulgas;

        public Hamster(String nombre, int edad, String alimento, int cantidadPulgas) {
            super(nombre, edad, alimento);
            this.cantidadPulgas = cantidadPulgas;
        }

        @Override
        public void mostrarDatos() {
            super.mostrarDatos();
            System.out.println("Cantidad de pulgas: " + cantidadPulgas);
        }
    }

    private String nombre;
    private int edad;
    private String alimento;

    public Animal(String nombre, int edad, String alimento) {
        this.nombre = nombre;
        this.edad = edad;
        this.alimento = alimento;
    }

    public void mostrarDatos() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Alimento: " + alimento);
    }

    public static void main(String[] args) {
        Gallo miGallo = new Gallo("Cocorico", 2, "Maíz", "Rojo");
        Perro miPerro = new Perro("Firulais", 5, "Croquetas", "Café");
        Gato miGato = new Gato("Garfield", 3, "Pescado", "Verde");
        Hamster miHamster = new Hamster("Chester", 1, "Semillas", 10);

        System.out.println("Datos del Gallo:");
        miGallo.mostrarDatos();

        System.out.println("\nDatos del Perro:");
        miPerro.mostrarDatos();

        System.out.println("\nDatos del Gato:");
        miGato.mostrarDatos();

        System.out.println("\nDatos del Hámster:");
        miHamster.mostrarDatos();
    }
}
