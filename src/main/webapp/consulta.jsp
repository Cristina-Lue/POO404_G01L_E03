<%@ include file="conexion.jsp" %>
<div class="">
  <table class="table table-striped table-bordered table-hover">
    <thead>
    <tr>
      <th>Id</th>
      <th>Nombres</th>
      <th>Edad</th>
      <th>Sexo</th>
      <th>Ocupación</th>
      <th>Fecha de nacimiento</th>
      <th>Usuario</th>
      <th>Eliminar</th>
      <th>Modificar</th>
    </tr>
    </thead>
    <tbody>
    <%
      // Declarar las variables
      PreparedStatement st = null;
      ResultSet rs = null;

      try {
        // Preparar la consulta
        st = conexion.prepareStatement(
                "SELECT p.id_persona, p.nombre_persona, p.edad_persona, p.sexo_persona, " +
                        "p.id_ocupacion, p.fecha_nac, p.usuario, o.ocupacion " +
                        "FROM persona p INNER JOIN ocupaciones o ON p.id_ocupacion = o.id_ocupacion"
        );

        // Ejecutar la consulta
        rs = st.executeQuery();
        while (rs.next()) {
    %>
    <tr>
      <td><%= rs.getString("id_persona") %></td>
      <td><%= rs.getString("nombre_persona") %></td>
      <td><%= rs.getString("edad_persona") %></td>
      <td><%= rs.getString("sexo_persona") %></td>
      <td><%= rs.getString("ocupacion") %></td>
      <td><%= rs.getString("fecha_nac") %></td>
      <td><%= rs.getString("usuario") %></td>
      <td>
        <button class="btn btn-danger" onclick="alerta('<%= rs.getString("id_persona") %>')">Eliminar</button>
      </td>
      <td>
        <button class="btn btn-info" onclick="modificar(
                '<%= rs.getString("id_persona") %>',
                '<%= rs.getString("nombre_persona") %>',
                '<%= rs.getString("edad_persona") %>',
                '<%= rs.getString("sexo_persona") %>',
                '<%= rs.getString("id_ocupacion") %>',
                '<%= rs.getString("fecha_nac") %>',
                '<%= rs.getString("usuario") %>'
                )">Modificar</button>
      </td>
    </tr>
    <%
        }
      } catch (SQLException e) {
        e.printStackTrace();
      } finally {
        // Cerrar ResultSet y PreparedStatement
        if (rs != null) try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
        if (st != null) try { st.close(); } catch (SQLException e) { e.printStackTrace(); }
        if (conexion != null) try { conexion.close(); } catch (SQLException e) { e.printStackTrace(); }
      }
    %>
    </tbody>
  </table>
</div>

<script>
  function alerta(id) {
    var opcion = confirm("¿Está seguro de eliminar este registro?");
    if (opcion) {
      location.href = "controller.jsp?operacion=eliminar&id=" + id;
    }
  }

  function modificar(id, nombre, edad, sexo, ocupacion, fecha, usuario) {
    document.getElementById("idpersona").value = id;
    document.getElementById("nombre").value = nombre;
    document.getElementById("edad").value = edad;
    document.getElementById("sexo").value = sexo;
    document.getElementById("ocupacion").value = ocupacion;
    document.getElementById("fecha").value = fecha;
    document.getElementById("usuario").value = usuario;
    document.getElementById("operacion").value = "modificar";

    var hijo = document.getElementById("passhidden");
    if (hijo) { // Verifica si existe el elemento antes de intentar eliminarlo
      var padre = hijo.parentNode;
      padre.removeChild(hijo);
    }
  }
</script>
