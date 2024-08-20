package Ejercicio3;

public class Empleado {
        protected String nombre;
        protected double salarioBase;

        public Empleado(String nombre, double salarioBase) {
            this.nombre = nombre;
            this.salarioBase = salarioBase;
        }

        public double calcularSalario() {
            return salarioBase;
        }

        public void mostrarInfo() {
            System.out.println("Nombre: " + nombre);
            System.out.println("Salario Base: " + salarioBase);
        }
}
