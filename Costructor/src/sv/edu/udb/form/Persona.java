package sv.edu.udb.form;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Persona extends JFrame {
    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtEdad;
    private JTextField txtTelefono;
    private JComboBox comboBox1;
    private JButton btnLimpiar;
    private JButton btnObtenerDatos;
    private JPanel pnlPersona;
    private JLabel lblId;
    private JLabel lblNombre;
    private JLabel lblEdad;
    private JLabel lblTelefono;
    private JLabel lblSexo;
    private JTable tblDatos;
    DefaultTableModel model=null;

    public Persona(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlPersona);
        this.setMinimumSize(new Dimension(600, 500));
        this.setLocationRelativeTo(getParent());
        //Arreglo de objeto, para inicializar con vacio la tabla
        Object [][] data=null;
        //Arreglo de string para crear los nombres de las columnas
        String[] colums= {
                "Id", "Nombres", "Edad", "Telefono", "Sexo"
        };
        //Instancia del modelo
        model= new DefaultTableModel(data, colums);
        //Seteo del modelo, el cual tendra la estructura que permitira
        //a la tabla presentar datos
        tblDatos.setModel(model);
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
        tblDatos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                tblObtenerDatos(e);
            }
        });
    }

    private void tblObtenerDatos(MouseEvent e){
        int fila = tblDatos.rowAtPoint(e.getPoint());
        int columna = tblDatos.columnAtPoint(e.getPoint());

        if ((fila > -1) && (columna > -1)){
            txtId.setText(model.getValueAt(fila, 0).toString());
            txtNombre.setText(model.getValueAt(fila, 1).toString());
            txtEdad.setText(model.getValueAt(fila, 2).toString());
            txtTelefono.setText(model.getValueAt(fila, 3).toString());
            comboBox1.setSelectedItem(model.getValueAt(fila, 4).toString());
        }
    }

    private void btnObtenerDatos(){
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

        model.addRow(newRow);

    }

    private void btnLimpiar(){
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