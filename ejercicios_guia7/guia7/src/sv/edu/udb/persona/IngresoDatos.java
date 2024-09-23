package sv.edu.udb.persona;

import java.sql.*;
import javax.swing.JOptionPane;
import sv.edu.udb.util.MatchDate;
import sv.edu.udb.util.MatchTelephone;

public class IngresoDatos {
    private int id;
    private String ids;
    private String nombre;
    private int edad;
    private String edads;
    private String telefono;
    private String sexo;
    private int idocupacion;
    private String idocupacions;
    private String fechanac;
    private Connection conexion;
    private ResultSet rs;
    private Statement s;

    public IngresoDatos() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost/personabdd", "root", "345617");
            s = conexion.createStatement();
            ingreso();
            s.executeUpdate("INSERT INTO persona VALUES (" + id + ", '" + nombre + "', " + edad + ", '" + telefono + "', '" + sexo + "', " + idocupacion + ", '" + fechanac + "')");
            JOptionPane.showMessageDialog(null, "Persona Ingresada Correctamente");
        } catch (ClassNotFoundException e1) {
            System.out.println("ERROR: No encuentro el driver de la BD: " + e1.getMessage());
            System.exit(0);
        } catch (SQLException e2) {
            System.out.println("ERROR: Fallo en SQL: " + e2.getMessage());
            System.exit(0);
        }
    }

    public void ObtenerOcupacion() throws SQLException {
        rs = s.executeQuery("SELECT COUNT(*) FROM ocupaciones");
        int tamanio = 0;
        if (rs.next()) {
            tamanio = rs.getInt(1);
        }
        String[] options2 = new String[tamanio];
        int contador = 0;
        rs = s.executeQuery("SELECT * FROM ocupaciones");
        while (rs.next()) {
            options2[contador] = rs.getString("Ocupacion");
            contador++;
        }
        idocupacions = (String) JOptionPane.showInputDialog(null, "Seleccione una ocupacion", "Ocupacion persona", JOptionPane.QUESTION_MESSAGE, null, options2, options2[0]);
        rs = s.executeQuery("SELECT id_ocupacion FROM ocupaciones WHERE ocupacion = '" + idocupacions + "'");
        if (rs.next()) {
            idocupacion = rs.getInt(1);
        }
    }

    public void ingreso() throws SQLException {
        ids = JOptionPane.showInputDialog("Ingrese el ID");
        id = Integer.parseInt(ids);
        nombre = JOptionPane.showInputDialog("Ingrese el Nombre");
        edads = JOptionPane.showInputDialog("Ingrese la edad");
        edad = Integer.parseInt(edads);
        telefono = JOptionPane.showInputDialog("Ingrese su Telefono");
        while (!MatchTelephone.compareTelephone(telefono)) {
            JOptionPane.showMessageDialog(null, "Numero de Telefono invalido");
            telefono = JOptionPane.showInputDialog("Ingrese su Telefono");
        }
        String[] options = {"Femenino", "Masculino"};
        sexo = (String) JOptionPane.showInputDialog(null, "¿Ingrese el sexo?", "Sexo persona", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        ObtenerOcupacion();
        fechanac = JOptionPane.showInputDialog("Ingrese la fecha de nacimiento");
        while (!MatchDate.compareDate(fechanac)) {
            JOptionPane.showMessageDialog(null, "Formato fecha invalido");
            fechanac = JOptionPane.showInputDialog("Ingrese la fecha de nacimiento");
        }
    }

    public void mostrardatos() throws SQLException {
        rs = s.executeQuery("SELECT * FROM persona");
        while (rs.next()) {
            JOptionPane.showMessageDialog(null, "ID: " + rs.getString("id_persona") + "\nNombre: " + rs.getString("nombre_persona") + "\nEdad: " + rs.getInt("edad_persona") + "\nTelefono: " + rs.getString("telefono_persona"));
        }
    }

    public void cierreconexion() throws SQLException {
        if (conexion != null) {
            conexion.close();
        }
    }
}
