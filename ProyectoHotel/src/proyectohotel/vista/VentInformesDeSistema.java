
package proyectohotel.vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import proyectohotel.controlador.Controlador;
import proyectohotel.modelo.clienteVO.ClienteVO;


public class VentInformesDeSistema extends JFrame implements ActionListener{
     private Controlador controlador;
     private JPanel panel;
     private JFrame vent;
     private JRadioButton buscarCliente;
     private JRadioButton habMayorRegis;
     private JRadioButton habMenorRegis;
     private JRadioButton masVendido;
     private JRadioButton menosVendido;
     private JRadioButton habMayorpasajeroprom;
     private JRadioButton promTodashabitaciones;
     private JButton buscar;
     private JTextField rutclient;
     private JLabel label1;
     private JLabel etiqueta;
     private JLabel verificacion;
     private TextArea textMensajes;
    
        
        
 
     public VentInformesDeSistema() {
         controlador = new Controlador();
    
        initVentana();
        initComponentes();
        vent.setVisible(true);
        
     }

        
     public void initVentana(){
		
	vent=new JFrame("INFORMES DE SISTEMA");
        vent.setLocationRelativeTo(null);
	vent.setBounds(150, 20, 800, 700);
        vent.setResizable(false);
	vent.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); 
    }
        
     public void initComponentes() {
	panel=new JPanel(null);
        etiqueta = new JLabel("Informes de Sistema");
        label1= new JLabel("RUT: ");
        letra(label1);
        rutclient = new JTextField(15);
        letra(rutclient);
        verificacion = new JLabel("");
        letra(verificacion);
        rutclient.setFont(new Font("Arial", Font.BOLD, 17));
        panel.setBackground(new Color(230,150,220));
	buscarCliente=new JRadioButton("Búsqueda de cliente");
        habMayorRegis=new JRadioButton("Habitación con mayor registro de utilización");
	habMenorRegis=new JRadioButton("Habitación con menor registro de utilización");
	masVendido=new JRadioButton("Informe de producto más vendido");
        menosVendido = new JRadioButton("Informe de producto menos vendido");
        habMayorpasajeroprom = new JRadioButton("Habitación con mayor cantidad de clientes promedio");
        promTodashabitaciones = new JRadioButton("Promedio de pasajeros por habiatación");
        buscar=new JButton("Buscar");
        buscar.addActionListener(this);
        textMensajes = new TextArea();
        
		
         ButtonGroup grupo1 = new ButtonGroup();
         grupo1.add(buscarCliente);
         
         grupo1.add(habMayorRegis);
         grupo1.add(habMenorRegis);
         grupo1.add(masVendido);
         grupo1.add(menosVendido);
         grupo1.add(habMayorpasajeroprom);
         grupo1.add(promTodashabitaciones);
                
                
          panel.add(etiqueta);
          etiqueta.setBounds(300, 20, 200, 30);
          panel.add(buscarCliente);
          buscarCliente.setBounds(20, 120, 380, 25);
          panel.add(label1);
          label1.setBounds(500, 120, 150, 25);  
          panel.add(rutclient);
          rutclient.setBounds(550, 120, 130, 25);
	  panel.add(habMayorRegis);
          habMayorRegis.setBounds(20, 150, 380, 25);
          panel.add(verificacion);
          verificacion.setBounds(520, 150, 220, 25);
	  panel.add(habMenorRegis);
          habMenorRegis.setBounds(20, 180, 380, 25);
	  panel.add(masVendido);
          masVendido.setBounds(20, 210, 380, 25);
          panel.add(menosVendido);
          menosVendido.setBounds(20, 240, 380, 25);
          panel.add(habMayorpasajeroprom);
          habMayorpasajeroprom.setBounds(20, 270, 380, 25);
          panel.add(promTodashabitaciones);
          promTodashabitaciones.setBounds(20, 300, 380, 25);
          panel.add(buscar);
          buscar.setBounds(550, 300, 100, 25);
          panel.add(textMensajes);
	  textMensajes.setBounds(20, 340, 700, 320);
                
                
          vent.add(panel);
		
                
		
    }
        
    private void letra(JTextField o) {
        o.setFont(new Font("Arial",Font.LAYOUT_LEFT_TO_RIGHT, 16));
    }
    
    private void letra(JLabel o) {
        o.setFont(new Font("Arial",Font.LAYOUT_LEFT_TO_RIGHT, 16));
    }
     
    public void setVisible() {
        vent.setVisible(true);
        textMensajes.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buscar) {
            textMensajes.setText("");
            verificacion.setText("");
            if (buscarCliente.isSelected()) {
                if (controlador.verificarRut(rutclient.getText())) {     
                    String rutBuscar = rutclient.getText();
                    ClienteVO cliente = controlador.cliente(rutBuscar);
                    textMensajes.setText(cliente.toStringInforme());
                    String registros = "\nRegistros: \n" + controlador.registros(rutBuscar);
                    String consumo = "\nConsumo\n";
                    textMensajes.setText(textMensajes.getText() + registros);
                } else {
                    verificacion.setText("Ingrese rut de la forma 12345678-9");
                }
            }
            
            if (habMayorRegis.isSelected()) {
                String habitacion = controlador.habitacionMasUtilizada();
                String texto = "Nombre: " + habitacion + "\nClientes que la utilizaron:\n" 
                    + controlador.clientesHabitacion(habitacion)+ "\nConsumo: \n" + controlador.gastoPeriodoYTotal(habitacion);
                
                textMensajes.setText(texto);
            }
            
            if (habMenorRegis.isSelected()) {
                String habitacion = controlador.habitacionMenosUtilizada();
                String texto = "Nombre: " + habitacion + "\nClientes que la utilizaron:\n" 
                    + controlador.clientesHabitacion(habitacion)+ "\nConsumo: \n" + controlador.gastoPeriodoYTotal(habitacion);
                
                textMensajes.setText(texto);
            }
            
            if (masVendido.isSelected()) {
                int codigo_producto = controlador.codigoProductoMasVendido();
                textMensajes.setText(controlador.informeProducto(codigo_producto));       
            }
            
            if (menosVendido.isSelected()) {
                int codigo_producto = controlador.codigoProductoMenosVendido();
                textMensajes.setText(controlador.informeProducto(codigo_producto));
            }
            
            if (habMayorpasajeroprom.isSelected()) {
                String habitacion = controlador.habitacionConMasClientesPromedio();
                String texto = "Nombre: " + habitacion + "\nClientes que la utilizaron:\n" 
                    + controlador.clientesHabitacion(habitacion)+ "\nConsumo: \n" + controlador.gastoPeriodoYTotal(habitacion);
                textMensajes.setText(texto);
            }
            
            if (promTodashabitaciones.isSelected()) {
                textMensajes.setText(controlador.habitacionesYClientesPromedio());
            }
            
        }
    }
         
}

