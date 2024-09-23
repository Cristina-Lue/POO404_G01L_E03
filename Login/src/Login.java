import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Login extends JFrame {
    private HashMap<String, String> usuarios;
    private HashMap<String, String> roles;
    private ArrayList<Plato> menuPlatos;
    private ArrayList<Pedido> pedidosPendientes;

    public Login() {
        usuarios = new HashMap<>();
        roles = new HashMap<>();
        menuPlatos = new ArrayList<>();
        pedidosPendientes = new ArrayList<>();
        inicializarMenuPlatos();
         setupUI();
    }
    
    private void setupUI() {
        setTitle("Sistema de Pedidos");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.LIGHT_GRAY);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));

        JButton btnRegistrar = new JButton("Registrar Usuario");
        JButton btnIniciarSesion = new JButton("Iniciar Sesión");
        JButton btnSalir = new JButton("Salir");

        panel.add(btnRegistrar);
        panel.add(btnIniciarSesion);
        panel.add(btnSalir);

        add(panel, BorderLayout.CENTER);

        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarUsuario();
            }
        });

        btnIniciarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarSesion();
            }
        });

        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void registrarUsuario() {
        JTextField nombreUsuario = new JTextField();
        JTextField contraseña = new JTextField();
        JTextField rol = new JTextField();

        Object[] message = {
                "Nombre de Usuario:", nombreUsuario,
                "Contraseña:", contraseña,
                "Rol (cliente/empleado):", rol
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Registrar Usuario", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String usuario = nombreUsuario.getText();
            String pass = contraseña.getText();
            String role = rol.getText();

            if (role.equalsIgnoreCase("cliente") || role.equalsIgnoreCase("empleado")) {
                registrarUsuario(usuario, pass, role.toLowerCase());
            } else {
                JOptionPane.showMessageDialog(null, "Rol no válido. Debe ser 'cliente' o 'empleado'.");
            }
        }
    }

    private void iniciarSesion() {
        JTextField nombreUsuario = new JTextField();
        JTextField contraseña = new JTextField();

        Object[] message = {
                "Nombre de Usuario:", nombreUsuario,
                "Contraseña:", contraseña
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Iniciar Sesión", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String usuario = nombreUsuario.getText();
            String pass = contraseña.getText();

            if (iniciarSesion(usuario, pass)) {
                String rolUsuario = obtenerRol(usuario);
                if (rolUsuario.equals("cliente")) {
                    menuCliente();
                } else {
                    menuEmpleado();
                }
            }
        }
    }

    private void menuCliente() {
        ArrayList<Plato> platosSeleccionados = new ArrayList<>();
        boolean salir = false;

        while (!salir) {
            String[] options = {
                "Ver menú de platos", 
                "Seleccionar platos", 
                "Realizar pago", 
                "Ver estado de pedidos",
                "Historial de compras",
                "Salir"
            };
            int opcion = JOptionPane.showOptionDialog(this, "Menú Cliente", "Opciones",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (opcion) {
                case 0:
                    mostrarMenuPlatos();
                    break;
                case 1:
                    seleccionarPlatos(platosSeleccionados);
                    break;
                case 2:
                    realizarPago(platosSeleccionados);
                    break;
                case 3:
                    verEstadoPedidos();
                    break;
                case 4:
                    verHistorialCompras();
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    break;
            }
        }
    }

    private void menuEmpleado() {
        boolean salir = false;
        while (!salir) {
            String[] options = {"Ver pedidos pendientes", "Despachar pedido", "Agregar comentario", "Salir"};
            int opcion = JOptionPane.showOptionDialog(this, "Menú Empleado", "Opciones",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (opcion) {
                case 0:
                    verPedidosPendientes();
                    break;
                case 1:
                    despacharPedido();
                    break;
                case 2:
                    agregarComentario();  
                    break;
                case 3:
                    salir = true;
                    break;
                default:
                    break;
            }
        }
    }

    private void mostrarMenuPlatos() {
        StringBuilder menu = new StringBuilder("--- Menú de Platos ---\n");
        for (int i = 0; i < menuPlatos.size(); i++) {
            Plato plato = menuPlatos.get(i);
            menu.append((i + 1)).append(". ").append(plato.getNombre()).append(" - $").append(plato.getPrecio()).append("\n");
        }
        JOptionPane.showMessageDialog(this, menu.toString());
    }

    private void seleccionarPlatos(ArrayList<Plato> platosSeleccionados) {
        boolean seleccionando = true;
        while (seleccionando) {
            mostrarMenuPlatos();
            String input = JOptionPane.showInputDialog("Selecciona el número del plato (0 para salir):");
            if (input == null) return;
            int seleccionPlato = Integer.parseInt(input);

            if (seleccionPlato > 0 && seleccionPlato <= menuPlatos.size()) {
                Plato plato = menuPlatos.get(seleccionPlato - 1);
                platosSeleccionados.add(plato);
                JOptionPane.showMessageDialog(this, plato.getNombre() + " ha sido añadido a tu pedido.");
            } else if (seleccionPlato == 0) {
                seleccionando = false;
            } else {
                JOptionPane.showMessageDialog(this, "Selección no válida. Intenta nuevamente.");
            }
        }
    }

    private void realizarPago(ArrayList<Plato> platosSeleccionados) {
        if (platosSeleccionados.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No has seleccionado ningún plato.");
            return;
        } 
            double total = 0;
            StringBuilder resumen = new StringBuilder("--- Resumen de tu pedido ---\n");
            for (Plato plato : platosSeleccionados) {
                resumen.append(plato.getNombre()).append(" - $").append(plato.getPrecio()).append("\n");
                total += plato.getPrecio();
            }
            resumen.append("Total a pagar: $").append(total);
            // Ofrecer opciones de pago
        String[] opcionesPago = {"Efectivo", "Tarjeta de Crédito/Débito"};
        int seleccion = JOptionPane.showOptionDialog(this, resumen.toString() + "¿Cómo deseas pagar?",
                "Método de Pago", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcionesPago, opcionesPago[0]);

        if (seleccion == JOptionPane.CLOSED_OPTION) return; 

        String metodoPago = opcionesPago[seleccion];
        JOptionPane.showMessageDialog(this, "Has seleccionado pagar con: " + metodoPago);

        // Añadir el pedido a la lista de pedidos pendientes
        pedidosPendientes.add(new Pedido(platosSeleccionados, total));
        platosSeleccionados.clear(); 
    }

    private void verPedidosPendientes() {
        if (pedidosPendientes.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay pedidos pendientes.");
        } else {
            StringBuilder pedidos = new StringBuilder("--- Pedidos Pendientes ---\n");
            for (int i = 0; i < pedidosPendientes.size(); i++) {
                Pedido pedido = pedidosPendientes.get(i);
                pedidos.append("Pedido #").append(i + 1).append(":\n");
                for (Plato plato : pedido.getPlatos()) {
                    pedidos.append(" - ").append(plato.getNombre()).append(" - $").append(plato.getPrecio()).append("\n");
                }
                pedidos.append("Total: $").append(pedido.getTotal()).append("\n");
                pedidos.append("Estado: ").append(pedido.getEstado()).append("\n");
                pedidos.append("Hora de envío: ").append(pedido.getFechaEnvio()).append("\n\n");
                if (!pedido.getComentario().isEmpty()) {
                    pedidos.append("Comentario: ").append(pedido.getComentario()).append("\n");
                }
                pedidos.append("\n");
            }
            JOptionPane.showMessageDialog(this, pedidos.toString());
        }
    }

    private void despacharPedido() {
        String input = JOptionPane.showInputDialog("Ingresa el número del pedido a despachar:");
        int numeroPedido = Integer.parseInt(input);

        if (numeroPedido > 0 && numeroPedido <= pedidosPendientes.size()) {
            Pedido pedidoDespachado = pedidosPendientes.remove(numeroPedido - 1);
            JOptionPane.showMessageDialog(this, "Pedido #" + numeroPedido + " ha sido despachado.");
        } else {
            JOptionPane.showMessageDialog(this, "Número de pedido no válido.");
        }
    }

    private void verEstadoPedidos() {
        if (pedidosPendientes.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay pedidos pendientes.");
        } else {
            StringBuilder estado = new StringBuilder("--- Estado de tus Pedidos ---\n");
            for (Pedido pedido : pedidosPendientes) {
                estado.append("Pedido con total: $").append(pedido.getTotal()).append(" - Estado: ").append(pedido.getEstado()).append("\n");
            }
            JOptionPane.showMessageDialog(this, estado.toString());
        }
}

    private void inicializarMenuPlatos() {
        menuPlatos.add(new Plato("Pizza", 8.50));
        menuPlatos.add(new Plato("Hamburguesa", 6.00));
        menuPlatos.add(new Plato("Ensalada", 4.50));
        menuPlatos.add(new Plato("Pasta", 7.00));
        menuPlatos.add(new Plato("Sopa", 5.00));
    }

    public void registrarUsuario(String nombreUsuario, String contraseña, String rol) {
        if (usuarios.containsKey(nombreUsuario)) {
            JOptionPane.showMessageDialog(null, "El nombre de usuario ya existe. Intenta con otro.");
        } else {
            usuarios.put(nombreUsuario, contraseña);
            roles.put(nombreUsuario, rol);
            JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente como " + rol + ".");
        }
    }

    public boolean iniciarSesion(String nombreUsuario, String contraseña) {
        if (usuarios.containsKey(nombreUsuario)) {
            if (usuarios.get(nombreUsuario).equals(contraseña)) {
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Contraseña incorrecta.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Usuario no encontrado.");
        }
        return false;
    }

    public String obtenerRol(String nombreUsuario) {
        return roles.get(nombreUsuario);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Login loginGUI = new Login();
            loginGUI.setVisible(true);
        });
    }

}

// Clase para representar un plato
class Plato {
    private String nombre;
    private double precio;

    public Plato(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
}

class Pedido {
    private ArrayList<Plato> platos;
    private double total;

    public Pedido(ArrayList<Plato> platos, double total) {
        this.platos = platos;
        this.total = total;
    }

    public ArrayList<Plato> getPlatos() {
        return platos;
    }

    public double getTotal() {
        return total;
    }
}
