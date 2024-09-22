package sv.edu.udb.guia08_poo_hb221258;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "RegistrarPersona", urlPatterns = {"/RegistrarPersona"})
public class RegistrarPersona extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            String nombre = request.getParameter("nombre");
            int edad = Integer.parseInt(request.getParameter("edad"));
            String sexo = request.getParameter("sexo");
            String fecha = request.getParameter("fecha");
            int idocupacion = Integer.parseInt(request.getParameter("ocupacion"));
            String usuario = request.getParameter("usuario");
            String password = request.getParameter("password");
            String ocupacion = "";

            Connection connection = null;
            PreparedStatement pstmtInsert = null;
            PreparedStatement pstmtSelect = null;
            ResultSet rs = null;

            try {
                Conexion con = new Conexion();
                connection = con.getConnection(); // Asegúrate de que este método esté implementado

                // Inserción en la tabla persona
                String insertQuery = "INSERT INTO persona (nombre_persona, edad_persona, sexo_persona, id_ocupacion, fecha_nac, usuario, contrasenia) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?)";
                pstmtInsert = connection.prepareStatement(insertQuery);
                pstmtInsert.setString(1, nombre);
                pstmtInsert.setInt(2, edad);
                pstmtInsert.setString(3, sexo);
                pstmtInsert.setInt(4, idocupacion);
                pstmtInsert.setString(5, fecha);
                pstmtInsert.setString(6, usuario);
                pstmtInsert.setString(7, password);
                pstmtInsert.executeUpdate();

                // Consulta para obtener ocupación
                String selectQuery = "SELECT ocupacion FROM ocupaciones WHERE id_ocupacion = ?";
                pstmtSelect = connection.prepareStatement(selectQuery);
                pstmtSelect.setInt(1, idocupacion);
                rs = pstmtSelect.executeQuery();

                if (rs.next()) {
                    ocupacion = rs.getString("ocupacion");
                }

                // Generación de respuesta HTML
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Registro " + usuario + "</title>");
                out.println("<link rel='stylesheet' href='css/bootstrap.min.css'>");
                out.println("<link rel='stylesheet' href='css/estilo.css' >");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1 class='text-center'>Usted ha registrado un usuario exitosamente</h1>");
                out.println("<section class='container text-center'>");
                out.println("<h3>Nombre: </h3>" + nombre);
                out.println("<h3>Edad: </h3>" + edad);
                out.println("<h3>Sexo: </h3>" + sexo);
                out.println("<h3>Ocupación: </h3>" + ocupacion);
                out.println("<h3>Fecha de nacimiento: </h3>" + fecha);
                out.println("<br><a class='btn btn-light' href='login.jsp'>Volver</a>");
                out.println("</section>");
                out.println("</body>");
                out.println("</html>");
            } catch (SQLException e) {
                e.printStackTrace();
                out.println("<h3>Error en la base de datos. Intente más tarde.</h3>");
            } finally {
                // Cerrar recursos
                if (rs != null) try { rs.close(); } catch (SQLException ignored) {}
                if (pstmtInsert != null) try { pstmtInsert.close(); } catch (SQLException ignored) {}
                if (pstmtSelect != null) try { pstmtSelect.close(); } catch (SQLException ignored) {}
                if (connection != null) try { connection.close(); } catch (SQLException ignored) {}
            }
        }
    }
}
