package Ejercicio3;

public class Gerente extends Empleado {
        private double bono;

        public Gerente(String nombre, double salarioBase, double bono) {
            super(nombre, salarioBase);
            if (bono < 0) {
            throw new IllegalArgumentException("El bono no puede ser negativo.");
        }
            this.bono = bono;
        }

        @Override
        public double calcularSalario() {
            return salarioBase + bono;
        }

        @Override
        public void mostrarInfo() {
            super.mostrarInfo();
            System.out.println("Bono: " + bono);
            System.out.println("Salario Total: " + calcularSalario());
        }
}
