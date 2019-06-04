
package proyectohotel.vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import proyectohotel.controlador.Controlador;
import proyectohotel.modelo.consumoVO.ConsumoVO;
import proyectohotel.modelo.consumoVO.ListaConsumoVO;

public class VentanaPedidosALaHabitacion implements ActionListener {
     private ConsumoVO consumo;
     private Controlador controlador;
     private ListaConsumoVO lista;
     private JFrame ventanapedidosalahabitacion ;
     private JLabel titulo;
     private JLabel textoproducto; 
     private JLabel textocantidad;
     private JLabel textototal;
     private JLabel textohabitacion;
     private JLabel verificar;
     private JLabel verificar2;
     private JComboBox producto;
     private JTextField cantidad;
     private JTextField total;
     private JComboBox habitacion;
     private JButton botonAgregarotro; 
     private JButton botonCalcular;
     private JButton botonTerminarPedido;
     private JTextArea visualizar;
     private int codigo_producto;
     private boolean calculo;
     private int precio;
     private int cantidadPr;
     private String texto;
     
    public VentanaPedidosALaHabitacion() {
        controlador = new Controlador();
        lista = new ListaConsumoVO();
        init();
        initComponentes();
        ventanapedidosalahabitacion.setVisible(true);
    }
    private void init() {
        ventanapedidosalahabitacion = new JFrame("Pedidos a la Habitacion");
        ventanapedidosalahabitacion.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        ventanapedidosalahabitacion.setBounds(150, 20, 800, 700);
        ventanapedidosalahabitacion.setResizable(false);
    }
    private void initComponentes() {
        JPanel panel = new JPanel(null);
        panel.setBackground(new Color(230,150,220));
        
        titulo = new JLabel("Pedidos a la Habitacion");
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        textoproducto = new JLabel("Producto: ");
        letra (textoproducto);
        textocantidad = new JLabel("Cantidad: ");
        letra(textocantidad);
        verificar = new JLabel("");
        letra(verificar);
        textototal = new JLabel("Total: ");
        letra(textototal);
        textohabitacion = new JLabel("Habitacion:");
        letra(textohabitacion);
        verificar2 = new JLabel("");
        letra(verificar2);
        producto = new JComboBox(controlador.listaProductos());
        calculo = false;
        texto = "";
        
        cantidad = new JTextField(10);
        letra(cantidad);
        total = new JTextField(10);
        letra(total);
        habitacion = new JComboBox(controlador.listaHabitacionesOcupadas());

        visualizar =new JTextArea();
        botonAgregarotro = new JButton("Agregar");
        botonAgregarotro.addActionListener(this);
        botonCalcular = new JButton("Calcular");
        botonCalcular.addActionListener(this);
        botonTerminarPedido = new JButton("Terminar pedido");
        
        panel.add(titulo);      
        titulo.setBounds(300, 20, 300, 30);
   
        panel.add(textoproducto);
        textoproducto.setBounds(20, 80, 150, 25);
        panel.add(producto);
        producto.setBounds(170, 80, 250, 25);
        panel.add(textocantidad);
        textocantidad.setBounds(20, 120, 150, 25);
        panel.add(cantidad);
        cantidad.setBounds(170, 120, 200, 25);
        panel.add(verificar);
        verificar.setBounds(380, 120, 220, 25);
        panel.add(botonCalcular);
        botonCalcular.setBounds(600, 120, 100, 25);
        panel.add(textototal);
        textototal.setBounds(20, 160, 160, 25);
        panel.add(total);
        total.setBounds(170, 160, 200, 25);
        panel.add(textohabitacion);
        textohabitacion.setBounds(20, 200, 160, 25);
        panel.add(habitacion);
        habitacion.setBounds(170, 200, 200, 25);
        panel.add(botonAgregarotro);
        botonAgregarotro.setBounds(20, 240, 150, 25);
        panel.add(visualizar);
        visualizar.setBounds(20, 280, 700, 200);
        panel.add(botonTerminarPedido);
        botonTerminarPedido.setBounds(400, 500, 150, 30);
        panel.add(verificar2);
        verificar2.setBounds(380, 530, 220, 25);
        
        ventanapedidosalahabitacion.add(panel);
         
         
 }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonCalcular) {
            verificar.setText("");
            if (cantidad.getText().compareTo("")==0) {
                verificar.setText("Ingrese cantidad");
            } else {
                String[] partes = ((String)producto.getSelectedItem()).split(" ");
                codigo_producto = Integer.parseInt(partes[0]);
                if (controlador.verificarCantidadPedida(cantidad.getText(), codigo_producto)) {
                    cantidadPr = Integer.parseInt(cantidad.getText());
                    precio = controlador.valorProducto(codigo_producto)*cantidadPr;
                    total.setText(precio + "");
                    calculo = true;
                }
            }
        }
        if (e.getSource() == botonAgregarotro) {
            if (calculo) {
                int numero_orden = controlador.getUltimoNumeroOrden((String)habitacion.getSelectedItem());
                consumo = new ConsumoVO(codigo_producto, cantidadPr, numero_orden);
                    
                if (lista.agregarConsumo(consumo)) {
                    String[] partes = ((String)producto.getSelectedItem()).split(" ");
                    codigo_producto = Integer.parseInt(partes[0]);
                    cantidadPr = Integer.parseInt(cantidad.getText());
                    precio = controlador.valorProducto(codigo_producto)*cantidadPr;
                    texto = texto + (String)producto.getSelectedItem() + "  Cantidad: "
                                + cantidadPr + " Valor: " + precio + "\n";
                    visualizar.setText(texto);
                    cantidad.setText("");
                    calculo=false;
                }
            }
            
        }
        if (e.getSource() == botonTerminarPedido) {
            verificar.setText("");
            if (lista.tieneElementos()) {
                lista.grabarConsumos();
                verificar2.setText("Pedido Ingresado");
                texto="";
                calculo=false;
                cantidad.setText("");
                lista.limpiar();
            }
        }
        
    }
    
    private void letra(JLabel o) {
        o.setFont(new Font("Arial",Font.LAYOUT_LEFT_TO_RIGHT, 16));
    }

    private void letra(JTextField o) {
        o.setFont(new Font("Arial",Font.LAYOUT_LEFT_TO_RIGHT, 16));
    }
    
    public void setVisible() {
        ventanapedidosalahabitacion.setVisible(true);
        cantidad.setText("");
        total.setText("");
        texto="";
        calculo=false;
    }
}
