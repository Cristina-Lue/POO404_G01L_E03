package Control2;
import javax.swing.JOptionPane;


public class ControlIf2 {
    public static void main(String[] args) {
        String v1="";
        v1=JOptionPane.showInputDialog("Ingrese un valor");
        if(v1==null)
        {
            JOptionPane.showMessageDialog(null,"Apretaste cancelar");
        }
        else {
            JOptionPane.showMessageDialog(null,"El valor de V1 es: "+v1);
        }
    }
}