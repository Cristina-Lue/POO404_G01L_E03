import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

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
        // Código del menú cliente (similar al anterior)
    }

    private void menuEmpleado() {
        boolean salir = false;
        while (!salir) {
            String[] options = {"Ver pedidos pendientes", "Avanzar estado de pedido", "Agregar comentario", "Salir"};
            int opcion = JOptionPane.showOptionDialog(this, "Menú Empleado", "Opciones",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (opcion) {
                case 0:
                    verPedidosPendientes();
                    break;
                case 1:
                    avanzarEstadoPedido();
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

    private void avanzarEstadoPedido() {
        String input = JOptionPane.showInputDialog("Ingresa el número del pedido a avanzar:");
        int numeroPedido = Integer.parseInt(input);

        if (numeroPedido > 0 && numeroPedido <= pedidosPendientes.size()) {
            Pedido pedido = pedidosPendientes.get(numeroPedido - 1);
            pedido.avanzarEstado();
            JOptionPane.showMessageDialog(this, "Pedido #" + numeroPedido + " ha avanzado al estado: " + pedido.getEstado());
        } else {
            JOptionPane.showMessageDialog(this, "Número de pedido no válido.");
        }
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

    private void agregarComentario() {
        String input = JOptionPane.showInputDialog("Ingresa el número del pedido para agregar un comentario:");
        if (input == null) return;
        int numeroPedido;

        try {
            numeroPedido = Integer.parseInt(input);
            if (numeroPedido > 0 && numeroPedido <= pedidosPendientes.size()) {
                String comentario = JOptionPane.showInputDialog("Ingresa el comentario:");
                if (comentario != null && !comentario.trim().isEmpty()) {
                    Pedido pedido = pedidosPendientes.get(numeroPedido - 1);
                    pedido.agregarComentario(comentario);
                    JOptionPane.showMessageDialog(this, "Comentario agregado exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(this, "El comentario no puede estar vacío.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Número de pedido no válido.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingresa un número válido.");
        }
    }
