package Ejercicio3;

public class Empleado {
        protected String nombre;
        protected double salarioBase;

        public Empleado(String nombre, double salarioBase) {
             if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        if (salarioBase < 0) {
            throw new IllegalArgumentException("El salario base no puede ser negativo.");
        }
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
