import javax.swing.JOptionPane;
public class PruebaEmpleado {
    public static void main(String[] args){
        Empleado emp=new Empleado();//Objeto de tipo Empleado
        Empleado.Profesor pro=new Empleado.Profesor(); //Objeto de tipo profesor
        JOptionPane.showMessageDialog(null,"claseempleado");
//Utilizando los metodos de Empleado
        emp.ingresoDatos();
        emp.mostrarDatos();
        JOptionPane.showMessageDialog(null,"clase profesor");
//Utilizando los metodos de profesor
        pro.ingresoDatos2();
        pro.mostrar2();
    }
}
