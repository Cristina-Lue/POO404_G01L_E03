package sv.edu.udb.guia08_poo_hb221258;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "GeneraSession", urlPatterns = {"/GeneraSession"})
public class GenerarSession extends HttpServlet {
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {
        final HttpSession sessionActual = request.getSession(true);
        final String operacion = request.getParameter("operacion");

        if ("salir".equals(operacion)) {
            sessionActual.invalidate();
            response.sendRedirect("principal.jsp");
        } else if ("logueo".equals(operacion)) {
            final String usuario = request.getParameter("usuario");
            final String password = request.getParameter("password");

            try {
                Conexion con = new Conexion();
                Connection connection = con.getConnection(); // Suponiendo que tienes este método
                String sql = "SELECT COUNT(usuario) AS userCount, nombre_persona FROM persona WHERE usuario = ? AND contrasenia = ?";

                try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                    pstmt.setString(1, usuario);
                    pstmt.setString(2, password);
                    ResultSet rs = pstmt.executeQuery();

                    if (rs.next() && rs.getInt("userCount") == 1) {
                        sessionActual.setAttribute("USER", usuario);
                        sessionActual.setAttribute("NAME", rs.getString("nombre_persona"));
                        response.sendRedirect("principal.jsp");
                    } else {
                        response.sendRedirect("login.jsp");
                    }
                    rs.close();
                }
                con.cerrarConexion();
            } catch (SQLException e) {
                e.printStackTrace();
                response.sendRedirect("login.jsp"); // Redirigir en caso de error
            }
        }
    }
}
