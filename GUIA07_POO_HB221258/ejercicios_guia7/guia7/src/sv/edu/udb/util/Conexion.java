package sv.edu.udb.util;
import java.sql.*;
public class Conexion
{
    private Connection conexion =null;
    private Statement s =null;
    private ResultSet rs=null;
    private String ingresoempleados="";
    public Conexion() throws SQLException{
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection ("jdbc:mysql://localhost:3306/personabdd","root", "345617");
            s = conexion.createStatement();
            System.out.println("Conexion Exitosa");
        }catch (ClassNotFoundException e1)
        {
            System.out.println("ERROR:No encuentro el driver de la BD: "+e1.getMessage());
        }
    }
    public ResultSet getRs() {
        return rs;
    }
    public void setRs(String sql)
    {
        try {
            this.rs = s.executeQuery(sql);

        }catch (SQLException e2)
        {
            System.out.println("ERROR:Fallo en SQL: "+e2.getMessage());
        }

    }
    public void setQuery(String sql) throws SQLException
    {
        this.s.executeUpdate(sql);
    }
    public void cerrarConexion() throws SQLException{
        conexion.close();
}
}
