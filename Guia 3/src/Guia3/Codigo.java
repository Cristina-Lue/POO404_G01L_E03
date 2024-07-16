package Guia3;

public class Codigo {
    class Clase {
         int contador;
        Clase() { //Constructor
            contador++;
        }
        int getContador() { //Obtenemos el valor de contador
            return contador;
        }
    }
    public class Codig {
        public void main(String[] args) {
            Clase uno = new Clase();
            Clase dos = new Clase();
            Clase tres = new Clase();
            Clase cuatro = new Clase();
            System.out.println("Hemos declarado " + dos.getContador() + " objetos.");
        }
    }
}
