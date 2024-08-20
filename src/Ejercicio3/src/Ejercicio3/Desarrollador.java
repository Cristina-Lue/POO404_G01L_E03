package Ejercicio3;

public class Desarrollador extends Empleado {
        private double bonusPorProyecto;

        public Desarrollador(String nombre, double salarioBase, double bonusPorProyecto) {
            super(nombre, salarioBase);
            this.bonusPorProyecto = bonusPorProyecto;
        }

        @Override
        public double calcularSalario() {
            return salarioBase + bonusPorProyecto;
        }

        @Override
        public void mostrarInfo() {
            super.mostrarInfo();
            System.out.println("Bonus por Proyecto: " + bonusPorProyecto);
            System.out.println("Salario Total: " + calcularSalario());
        }

}
