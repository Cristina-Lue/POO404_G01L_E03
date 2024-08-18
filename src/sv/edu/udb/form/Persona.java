package sv.edu.udb.form;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Persona extends JFrame {
    private JTextField txtNombre;
    private JTextField txtEdad;
    private JTextField txtId;
    private JTextField txtTelefono;
    private JComboBox<String> comboBox1;
    private JButton btnObtenerDatos;
    private JButton btnLimpiar;
    private JPanel pnlPersona;
    private JLabel lblId;
    private JLabel lblNombre;
    private JLabel lblEdad;
    private JLabel lblTelefono;
    private JLabel lblbSexo;
    private JTable tblDatos;
    private DefaultTableModel modelo;

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public Persona(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlPersona);
        this.setMinimumSize(new Dimension(600, 500));
        this.setLocationRelativeTo(null);

        // Arreglo de objeto, para inicializar con vacio la tabla
        Object[][] data = null;
        // Arreglo de String para crear los nombres de las columnas
        String[] columnas = {"Id", "Nombre", "Edad", "Telefono", "Sexo"};
        // Instancia del modelo
        modelo = new DefaultTableModel(data, columnas);
        // Seteo del modelo, el cual tendra la estructura que permitira
        // a la tabla representar los datos
        tblDatos.setModel(modelo);

        // Cargar datos desde el archivo CSV
        cargarDatosDesdeCSV("datos.csv");

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

    private void cargarDatosDesdeCSV(String archivoCSV) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {
            String linea;
            // Leer la primera línea (encabezados)
            br.readLine();
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                modelo.addRow(datos);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al leer el archivo CSV", "Error", JOptionPane.ERROR_MESSAGE);
        }
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

        JOptionPane.showMessageDialog(null, "Datos Obtenidos: \n ID: " + id +
                "\n nombres: " + nombres + "\n Edad: " + edad + "\n Telefono: " + telefono +
                "\n Sexo: " + sexo);

        Object[] newRow = {id, nombres, edad, telefono, sexo};
        modelo.addRow(newRow);

        // Guardar la nueva entrada en el archivo CSV
        guardarDatosEnCSV("datos.csv", newRow);
    }

    private void guardarDatosEnCSV(String archivoCSV, Object[] nuevaFila) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoCSV, true))) {
            StringBuilder sb = new StringBuilder();
            for (Object dato : nuevaFila) {
                sb.append(dato).append(",");
            }
            // Eliminar la última coma y añadir un salto de línea
            sb.setLength(sb.length() - 1);
            sb.append("\n");
            bw.write(sb.toString());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al guardar el archivo CSV", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnLimpiar() {
        txtId.setText("");
        txtNombre.setText("");
        txtEdad.setText("");
        txtTelefono.setText("");
        comboBox1.setSelectedIndex(0);
    }

    @Override
    protected void processMouseEvent(MouseEvent e) {
        super.processMouseEvent(e);
    }

    public static void main(String[] args) {
        // Verifica que la ruta del archivo CSV sea correcta
        JFrame frame = new Persona("Ingreso de Datos");
        frame.setVisible(true);
    }
}

