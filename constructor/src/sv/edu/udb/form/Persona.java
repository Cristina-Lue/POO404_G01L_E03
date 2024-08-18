package sv.edu.udb.form;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class Persona extends JFrame{
    private JTextField txtNombre;
    private JTextField txtEdad;
    private JPasswordField txtTelefono;
    private JTextField txtId;
    private JComboBox comboBox1;
    private JButton btnObtenerDatos;
    private JButton btnLimpiar;
    private JPanel pnlPersona;
    private JLabel lblId;
    private JLabel lblNombre;
    private JLabel lblEdad;
    private JLabel lblTelefono;
    private JLabel lblbSexo;
    private JTable tblDatos;
    DefaultTableModel modelo = null;

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
    // Constructor con Pametro para inicializar el
    //JFrame creado

    public Persona(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlPersona);
        this.setMinimumSize(new Dimension(600, 500));
        this.setLocationRelativeTo(getParent());
        //Arreglo de objeto, para inicializar con vacio la tabla
        Object [][] data=null;
        //Arreglo de String para crear los nombres de las columnas
        String[] columnas = {
                "Id","Nombre","Edad","Telefono","Sexo"
        };
        //Instancia del modelo
        modelo = new DefaultTableModel(data, columnas);
        //Seteo del modelo, el cual tendra la estructura que permitira
        //a la tabla representar los datos
        tblDatos.setModel(modelo);

        btnObtenerDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnObtenerDatos();
            }
        });
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnLimpiar();
            }
        });
    }

    private void btnObtenerDatos() {
        String id;
        String nombres;
        String edad;
        String telefono;
        String sexo;

        id = txtId.getText();
        nombres = txtNombre.getText();
        edad = txtEdad.getText();
        telefono = txtTelefono.getText();
        sexo = comboBox1.getSelectedItem().toString();

        JOptionPane.showMessageDialog(null,"Datos Obtenidos: \n ID: " +id+
                "\n nombres: "+ nombres+"\n Edad: "+edad+"\n Telefono: "+telefono+
                "\n Sexo: "+ sexo);

        Object[] newRow={id,
            nombres,
            edad,
            telefono,
            sexo};

        modelo.addRow(newRow);
    }

    @Override
    protected void processMouseEvent(MouseEvent e) {
        super.processMouseEvent(e);
    }

    private void btnLimpiar() {
        txtId.setText("");
        txtNombre.setText("");
        txtEdad.setText("");
        txtTelefono.setText("");
        comboBox1.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        JFrame frame = new Persona("Ingreso de Datos");
        frame.setVisible(true);
    }
}
