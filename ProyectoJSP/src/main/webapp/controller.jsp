<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ include file="conexion.jsp" %>
<html>
<head>
    <title>Gestión de Sesión</title>
</head>
<body>
<h1>Generando sesión</h1>
<%
    // Obtener la sesión actual o crear una si no existe
    HttpSession session_actual = request.getSession(true);

    // Obtener el parámetro "operacion" desde el request
    String operacion = request.getParameter("operacion");

    // Verificar si "operacion" no es nulo antes de continuar
    if (operacion != null) {
        out.println("Operación recibida: " + operacion);  // Esto es solo para debug

        if (operacion.equals("salir")) {
            session_actual.setAttribute("USER", null);
            session_actual.setAttribute("NAME", null);
            response.sendRedirect("login.html");
        } else if (operacion.equals("logueo")) {
            String usuario = request.getParameter("usuario");
            String password = request.getParameter("password");

            try {
                st = conexion.prepareStatement("SELECT COUNT(usuario), nombre_persona FROM persona WHERE usuario = ? AND contrasenia = SHA2(?, 256)");
                st.setString(1, usuario);
                st.setString(2, password);
                rs = st.executeQuery();
                rs.next();

                if (rs.getInt(1) == 1) {  // Solo una coincidencia es permitida
                    session_actual.setAttribute("USER", usuario);
                    session_actual.setAttribute("NAME", rs.getString(2));
                    response.sendRedirect("principal.jsp");
                } else {
                    response.sendRedirect("login.html");
                }

                // Cerrar recursos
                rs.close();
                st.close();
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (operacion.equals("insertar")) {
            String nombre = request.getParameter("nombre");
            int edad = Integer.parseInt(request.getParameter("edad"));
            String sexo = request.getParameter("sexo");
            String fecha = request.getParameter("fecha");
            int idocupacion = Integer.parseInt(request.getParameter("ocupacion"));
            String usuario = request.getParameter("usuario");
            String password = request.getParameter("password");

            try {
                st = conexion.prepareStatement("INSERT INTO persona (nombre_persona, edad_persona, sexo_persona, id_ocupacion, fecha_nac, usuario, contrasenia) VALUES (?, ?, ?, ?, ?, ?, SHA2(?, 256))");
                st.setString(1, nombre);
                st.setInt(2, edad);
                st.setString(3, sexo);
                st.setInt(4, idocupacion);
                st.setString(5, fecha);
                st.setString(6, usuario);
                st.setString(7, password);
                st.executeUpdate();

                // Cerrar recursos
                st.close();
                conexion.close();
                response.sendRedirect("principal.jsp?exito=si");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (operacion.equals("modificar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            String nombre = request.getParameter("nombre");
            int edad = Integer.parseInt(request.getParameter("edad"));
            String sexo = request.getParameter("sexo");
            String fecha = request.getParameter("fecha");
            int idocupacion = Integer.parseInt(request.getParameter("ocupacion"));
            String usuario = request.getParameter("usuario");

            try {
                st = conexion.prepareStatement("UPDATE persona SET nombre_persona = ?, edad_persona = ?, sexo_persona = ?, id_ocupacion = ?, fecha_nac = ?, usuario = ? WHERE id_persona = ?");
                st.setString(1, nombre);
                st.setInt(2, edad);
                st.setString(3, sexo);
                st.setInt(4, idocupacion);
                st.setString(5, fecha);
                st.setString(6, usuario);
                st.setInt(7, id);
                st.executeUpdate();

                // Cerrar recursos
                st.close();
                conexion.close();
                response.sendRedirect("principal.jsp?exito=si");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (operacion.equals("eliminar")) {
            int id = Integer.parseInt(request.getParameter("id"));

            try {
                st = conexion.prepareStatement("DELETE FROM persona WHERE id_persona = ?");
                st.setInt(1, id);
                st.executeUpdate();

                // Cerrar recursos
                st.close();
                conexion.close();
                response.sendRedirect("principal.jsp?exito=si");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    } else {
        out.println("No se recibió ninguna operación.");
    }
%>
</body>
</html>
