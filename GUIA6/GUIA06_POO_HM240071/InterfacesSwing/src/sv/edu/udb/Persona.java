package sv.edu.udb;

import sv.edu.udb.datos.PersonasDatos;
import sv.edu.udb.beans.PersonaBeans;
import sv.edu.udb.datos.OcupacionesDatos;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class Persona extends JFrame {
    private JLabel lblId;
    private JLabel lblNombre;
    private JLabel lblEdad;
    private JLabel lblTelefono;
    private JLabel lblSexo;
    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtEdad;
    private JTextField txtTelefono;
    private JComboBox cmbSex;
    private JButton btnObtenerDatos;
    private JButton btnLimpiar;
    private JPanel pnlPersona;
    private JScrollPane jscroll;
    private JTable tblDatos;
    private JComboBox cmbOcupacion;
    private JTextField txtFechaNacimiento;
    private JButton btnEliminar;
    DefaultTableModel modelo = null;

    DefaultTableModel modeloDatos = null;
    PersonaBeans personaBeans = null;
    PersonasDatos personasDatos = new PersonasDatos();
    OcupacionesDatos ocupacionesDatos = new OcupacionesDatos();

    public Persona(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlPersona);
        this.setMinimumSize(new Dimension(600,350));
        this.setLocationRelativeTo(getParent());

        Object [][] data = null;
        String []colums = {
                "Id", "Nombre", "Edad", "Telefono", "Sexo"
        };

        modelo = new DefaultTableModel(data, colums);
        tblDatos.setModel(modelo);
        cmbOcupacion.setModel(ocupacionesDatos.selectOcupaciones());

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
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnEliminarDatos();
            }
        });
    }

    private void btnEliminarDatos() {
        personasDatos.delete(Integer.parseInt(txtId.getText()));
        btnLimpiar();
        modelo=personasDatos.selectPersona();
        tblDatos.setModel(modelo);
    }

    private void btnLimpiar() {
        txtId.setText("");
        txtNombre.setText("");
        txtEdad.setText("");
        txtTelefono.setText("");
        cmbSex.setSelectedIndex(0);
        cmbOcupacion.setSelectedIndex(0);
        txtFechaNacimiento.setText("");
        btnObtenerDatos.setText("Guardar");
    }

    private void btnObtenerDatos() {
        int id;
        String nombres;
        int edad;
        String telefono;
        String sexo;
        int idOcupacion;
        String fechaNacimiento;
        if (txtId.getText().isEmpty()){
            id = 0;
        }else{
            id = Integer.parseInt(txtId.getText());
        }
        nombres = txtNombre.getText();
        edad = Integer.parseInt(txtEdad.getText());
        telefono = txtTelefono.getText();
        sexo = cmbSex.getSelectedItem().toString();
        idOcupacion =
                ocupacionesDatos.getIdOcupacion(cmbOcupacion.getSelectedItem().toString());
        fechaNacimiento = txtFechaNacimiento.getText();
        personaBeans = new
                PersonaBeans(id,nombres,edad,telefono,sexo,idOcupacion,fechaNacimiento);
        if(btnObtenerDatos.getText().equals("Guardar")) {
            personasDatos.insert(personaBeans);
        }else if (btnObtenerDatos.getText().equals("Editar")) {
            personasDatos.update(personaBeans);
        }
        modelo=personasDatos.selectPersona();
        tblDatos.setModel(modelo);
    }

    private void tblObtenerDato(MouseEvent e) {
        int fila = tblDatos.rowAtPoint(e.getPoint());
        int columna = tblDatos.columnAtPoint(e.getPoint());
        if ((fila > -1) && (columna > -1)){
            txtId.setText(modelo.getValueAt(fila,0).toString());
            txtNombre.setText(modelo.getValueAt(fila,1).toString());
            txtEdad.setText(modelo.getValueAt(fila,2).toString());
            txtTelefono.setText(modelo.getValueAt(fila,3).toString());
            cmbSex.setSelectedItem(modelo.getValueAt(fila,4).toString());
            cmbOcupacion.setSelectedItem(modelo.getValueAt(fila,5).toString());
            txtFechaNacimiento.setText(modelo.getValueAt(fila,6).toString());
            btnObtenerDatos.setText("Editar");
        }
    }
    public static void main(String[] args) {
        JFrame frame = new Persona("Ingreso de Datos");
        frame.setVisible(true);
    }
}
