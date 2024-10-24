package sv.edu.udb.guia07;
import java.sql.*;
public class Conexion {
    private Connection conexion = null;
    private Statement s = null;
    private ResultSet rs=null;
//    Constructor
    public Conexion() throws SQLException{
        try{
            //obtenemos el driver para mysql
            Class.forName("com.mysql.cj.jdbc.Driver");
            //se obtiene conexion con la base de datos
            conexion= DriverManager.getConnection("jdbc:mysql://localhost/personabddg7", "root","");
            //permite ejecutar sentencias sql sin parametros
            s= conexion.createStatement();
        } catch (ClassNotFoundException e1){
            //ERROR SI NO PUEDE LEER EL DRIVER DE MYSQL
            System.out.println("ERROR: No encuentro el driver de la BD: "+ e1.getMessage());
        }
    }
    //Metodo que permite obtener los valores del resulset
    public ResultSet getRs() {
        return rs;
    }
    //METODO QUE PERMITE FIJAR LA TABLA RESULTADO DE LA PREGUNTA SQL REALIZADA
    public void setRs(String consulta){
        try{
            this.rs=s.executeQuery(consulta);
        }catch (SQLException e2){
            System.out.println();
            System.out.println("ERROR:Fallo en SQL: " + e2.getMessage());
        }
    }
    //Metodo que recibe un sql como parametro que sea un udpate, insert, delete
    public void setQuery(String query) throws SQLException{
        this.s.executeUpdate(query);
    }
    //Metodo que cierra la conexion
    public void CerrarConexion() throws SQLException{
        conexion.close();
    }
}
