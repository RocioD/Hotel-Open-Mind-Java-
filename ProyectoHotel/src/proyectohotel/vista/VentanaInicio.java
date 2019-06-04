package proyectohotel.vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;

public class VentanaInicio implements ActionListener {

    private JFrame ventanahotelopenmind;
    private JLabel titulo;
    private JRadioButton ingresoclientes;
    private JRadioButton ingresopedidosalahabitacion;
    private JRadioButton registrarsalida;
    private JRadioButton vercatalogoproductos;
    private JRadioButton informedelsistema;
    private JRadioButton clientedelamor;
    private JButton botonir;
    private VentanaIngresoClientes vIngreso;
    private VentanaPedidosALaHabitacion vPedidos;
    private VentanaRegistroSalida vSalida;
    private VentanaCatalogoDeProductos vCatalogo;
    private VentInformesDeSistema vInformes;
    private VentanaClienteDelAmor vAmor;

    public VentanaInicio() {
        init();
        initComponentes();
        ventanahotelopenmind.setVisible(true);
    }

    private void init() {
        ventanahotelopenmind = new JFrame("Hotel Open Mind");
        ventanahotelopenmind.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        ventanahotelopenmind.setBounds(150, 20, 800, 700);
        ventanahotelopenmind.setResizable(false);

    }

    private void initComponentes() {
        JPanel panel = new JPanel(null);
        panel.setBackground(new Color(230, 150, 220));

        titulo = new JLabel("Hotel Open Mind");
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        ingresoclientes = new JRadioButton("Ingreso Clientes");
        ingresopedidosalahabitacion = new JRadioButton("Ingreso Pedidos a la Habitacion");
        registrarsalida = new JRadioButton("Registrar Salida");
        vercatalogoproductos = new JRadioButton("Ver Catalogo de Productos");
        informedelsistema = new JRadioButton("Informe del Sistema");
        clientedelamor = new JRadioButton("Cliente del amor");
        botonir = new JButton("IR");
        botonir.addActionListener(this);

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(ingresoclientes);
        grupo.add(ingresopedidosalahabitacion);
        grupo.add(registrarsalida);
        grupo.add(vercatalogoproductos);
        grupo.add(informedelsistema);
        grupo.add(clientedelamor);

        panel.add(titulo);
        titulo.setBounds(300, 20, 400, 30);

        panel.add(ingresoclientes);
        ingresoclientes.setBounds(20, 120, 220, 25);
        panel.add(ingresopedidosalahabitacion);
        ingresopedidosalahabitacion.setBounds(20, 150, 220, 25);
        panel.add(registrarsalida);
        registrarsalida.setBounds(20, 180, 220, 25);
        panel.add(vercatalogoproductos);
        vercatalogoproductos.setBounds(20, 210, 220, 25);
        panel.add(informedelsistema);
        informedelsistema.setBounds(20, 240, 220, 25);
        panel.add(clientedelamor);
        clientedelamor.setBounds(20, 270, 220, 25);
        panel.add(botonir);
        botonir.setBounds(20, 350, 100, 25);
        ventanahotelopenmind.add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonir) {
            if (ingresoclientes.isSelected()) {
                if (vIngreso == null) {
                    vIngreso = new VentanaIngresoClientes();
                } else {
                    vIngreso.setVisible();
                }
            }

            if (ingresopedidosalahabitacion.isSelected()) {
                if (vPedidos == null) {
                    vPedidos = new VentanaPedidosALaHabitacion();
                } else {
                    vPedidos.setVisible();
                }
            }

            if (registrarsalida.isSelected()) {
                if (vSalida == null) {
                    vSalida = new VentanaRegistroSalida();
                } else {
                    vSalida.setVisible();
                }
            }

            if (vercatalogoproductos.isSelected()) {
                if (vCatalogo == null) {
                    vCatalogo = new VentanaCatalogoDeProductos();
                } else {
                    vCatalogo.setVisible();
                }
            }

            if (informedelsistema.isSelected()) {
                if (vInformes == null) {
                    vInformes = new VentInformesDeSistema();
                } else {
                    vInformes.setVisible();
                }
            }

            if (clientedelamor.isSelected()) {
                if (vAmor == null) {
                    vAmor = new VentanaClienteDelAmor();
                } else {
                    vAmor.setVisible();
                }
            }
        }
    }
}
