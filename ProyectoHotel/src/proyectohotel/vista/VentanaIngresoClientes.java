
package proyectohotel.vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import javafx.geometry.HorizontalDirection;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.text.JTextComponent;
import proyectohotel.controlador.Controlador;
import proyectohotel.modelo.clienteVO.ClienteVO;
import proyectohotel.modelo.ingreso.IngresoVO;
import proyectohotel.vista.opciones.Habitaciones;
import sun.java2d.loops.DrawLine;

public class VentanaIngresoClientes implements ActionListener{
    private Controlador controlador;
    private IngresoVO ingreso;
    private JFrame ventana;
    private JLabel titulo;
    private JLabel textoRut;
    private JLabel textoClienteAmor;
    private JLabel textoNombres;
    private JLabel textoApellidoP;
    private JLabel textoApellidoM;
    private JLabel textoSexo;
    private JLabel textoFechaN;
    private JLabel textoNacionalidad;
    private JLabel textoHabitacion;
    private JLabel textoTotalClientes;
    private JLabel textoModalidad;
    private JLabel textoJornada;
    private JLabel textoMomento;
    private JLabel textoHoraIn;
    private JLabel textoFechaIn;
    private JLabel textoDosPuntos;
    private JLabel textoSeparador1;
    private JLabel textoSeparador2;
    private JLabel textoValorPersona;
    private JLabel mensajeClienteAgregado;
    private JLabel verificacion1;
    private JLabel verificacion2;
    private JLabel verificacion3;
    private JLabel verificacion4;
    private JLabel verificacion5;
    private JLabel verificacion6;
    private JLabel verificacion7;
    private JLabel verificacion8;
    private JLabel verificacion9;
    private JLabel verificacion10;
    private JLabel verificacion11;
    private JLabel verificacion12;
    private JButton botonBuscar;
    private JButton botonAgregar;
    private JButton botonIngresar;
    private JButton botonCalcular;
    private JTextField rut;
    private JTextField clienteAmor;//parece q no lo usaremos
    private JTextField nombres;
    private JTextField apellido_paterno;
    private JTextField apellido_materno;
    private JTextField sexo;
    private JTextField fecha_nacimiento;
    private JTextField nacionalidad;
    private JTextField totalClientes;
    private JTextField hora1;
    private JTextField hora2;
    private JTextField fecha1;
    private JTextField fecha2;
    private JTextField fecha3;
    private JTextField valorPersona;
    private JRadioButton m1;
    private JRadioButton m2;
    private JComboBox mHabitaciones;
    private JSeparator separacion;
    private JSeparator separacion2;
    private ClienteVO cliente;
    private TextArea clientesIngresados;
    private int numeroDeClientes;
    private String ruts;
    private boolean calculo;
    private int costoTotal;
    private int costoRelativo;
    
    public VentanaIngresoClientes() {
        controlador = new Controlador();
        init();
        initComponentes();
        ventana.setVisible(true);
    }
    
    private void init() {
        ventana = new JFrame("Ingreso");
        ventana.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        ventana.setBounds(150, 20, 800, 700);
        ventana.setResizable(false);
    }
    
    private void initComponentes() {
        JPanel panel = new JPanel(null);
        panel.setBackground(new Color(230,150,220));
        
        titulo = new JLabel("Ingreso Clientes");
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        textoRut = new JLabel("Rut:");
        letra(textoRut);
        verificacion1 = new JLabel("");
        letra(verificacion1);
        textoClienteAmor = new JLabel("");
        letra(textoClienteAmor);
        textoNombres = new JLabel("Nombres:");
        letra(textoNombres);
        verificacion2 = new JLabel("");
        letra(verificacion2);
        textoApellidoP = new JLabel("Apellido Paterno:");
        letra(textoApellidoP);
        verificacion3 = new JLabel("");
        letra(verificacion3);
        textoApellidoM = new JLabel("Apellido materno:");
        letra(textoApellidoM);
        verificacion4 = new JLabel("");
        letra(verificacion4);
        textoSexo = new JLabel("Sexo (F/M)");
        letra(textoSexo);
        verificacion5 = new JLabel("");
        letra(verificacion5);
        textoFechaN = new JLabel("Fecha Nacimiento");
        letra(textoFechaN);
        verificacion6 = new JLabel("");
        letra(verificacion6);
        textoNacionalidad = new JLabel("Nacionalidad");
        letra(textoNacionalidad);
        verificacion7 = new JLabel("");
        letra(verificacion7);
        textoHabitacion = new JLabel("Habitacion");
        letra(textoHabitacion);
        textoTotalClientes = new JLabel("N° de huéspedes");
        letra(textoTotalClientes);
        verificacion8 = new JLabel("");
        letra(verificacion8);
        textoModalidad = new JLabel("Modalidad");
        letra(textoModalidad);
        textoJornada = new JLabel("Jornada (12 H)");
        letra(textoJornada);
        verificacion9 = new JLabel("");
        letra(verificacion9);
        textoMomento = new JLabel("Momento (3 H)");
        letra(textoMomento);
        textoHoraIn = new JLabel("Hora Ingreso");
        letra(textoHoraIn);
        verificacion10 = new JLabel("");
        letra(verificacion10);
        textoFechaIn = new JLabel("Fecha Ingreso");
        letra(textoFechaIn);
        verificacion11 = new JLabel("");
        letra(verificacion11);
        textoDosPuntos = new JLabel(":");
        letra(textoDosPuntos);
        textoSeparador1 = new JLabel("/");
        letra(textoSeparador1);
        textoSeparador2 = new JLabel("/");
        letra(textoSeparador2);
        textoValorPersona = new JLabel("Valor por Persona");
        letra(textoValorPersona);
        mensajeClienteAgregado = new JLabel("");
        verificacion12 = new JLabel("");
        letra(verificacion12);
        letra(mensajeClienteAgregado);
        botonBuscar = new JButton("Buscar");
        botonBuscar.addActionListener(this);
        botonAgregar = new JButton("Agregar");
        botonAgregar.addActionListener(this);
        botonIngresar = new JButton("Ingresar");
        botonIngresar.addActionListener(this);
        botonCalcular = new JButton("Calcular");
        botonCalcular.addActionListener(this);
        rut = new JTextField(10);
        letra(rut);
        clienteAmor = new JTextField(10);//parece q no lo usaremos
        nombres = new JTextField(10);
        letra(nombres);
        apellido_paterno = new JTextField(10);
        letra(apellido_paterno);
        apellido_materno = new JTextField(10);
        letra(apellido_materno);
        sexo = new JTextField(10);
        letra(sexo);
        fecha_nacimiento = new JTextField(10);
        letra(fecha_nacimiento);
        nacionalidad = new JTextField(10);
        letra(nacionalidad);
        totalClientes = new JTextField(10);
        letra(totalClientes);
        hora1 = new JTextField(10);
        letra(hora1);
        hora2 = new JTextField(10);
        letra(hora2);
        fecha1 = new JTextField(10);
        letra(fecha1);
        fecha2 = new JTextField(10);
        letra(fecha2);
        fecha3 = new JTextField(10);
        letra(fecha3);
        valorPersona = new JTextField(10);
        letra(valorPersona);
        m1 = new JRadioButton();
        m2 = new JRadioButton();
        separacion = new JSeparator(SwingConstants.HORIZONTAL);
        separacion2 = new JSeparator(SwingConstants.HORIZONTAL);
        clientesIngresados = new TextArea();
        clientesIngresados.setFont(new Font("Arial",Font.LAYOUT_LEFT_TO_RIGHT, 16));
        ruts ="";
        numeroDeClientes = 0;
        calculo = false;
        costoTotal = 0;
        costoRelativo = 0;
        
        mHabitaciones= new JComboBox(controlador.listaHabitacionesDisponibles());
        /*
        mHabitaciones.addItem("Habitación lunar");
        mHabitaciones.addItem("Parque de diversiones");
        mHabitaciones.addItem("Túnel subterráneo");
        mHabitaciones.addItem("LoveChair");
        mHabitaciones.addItem("Cassandra");
        mHabitaciones.addItem("Vaquero");
        mHabitaciones.addItem("Egipcia");
        mHabitaciones.addItem("Kamasutra");
        mHabitaciones.addItem("Disco");
        mHabitaciones.addItem("La China");
        */
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(m1);
        grupo.add(m2);
    
        panel.add(titulo);
        titulo.setBounds(300, 20, 200, 30);
   
        panel.add(textoRut);
        textoRut.setBounds(20, 80, 150, 25);
        panel.add(rut);
        rut.setBounds(170, 80, 150, 25);
        panel.add(verificacion1);
        verificacion1.setBounds(310, 105, 250, 25);
        panel.add(botonBuscar);
        botonBuscar.setBounds(350, 80, 90, 25);
        panel.add(textoClienteAmor);
        textoClienteAmor.setBounds(150, 110, 340, 25);
        
        panel.add(separacion);
        separacion.setBounds(0, 140, 790, 1);
    
        panel.add(textoNombres);
        textoNombres.setBounds(20, 150, 150, 25);
        panel.add(nombres);
        nombres.setBounds(170, 150, 200, 25);
        panel.add(verificacion2);
        verificacion2.setBounds(370, 150, 230, 25);
        panel.add(clientesIngresados);
        clientesIngresados.setBounds(600, 150, 180, 150);
        panel.add(textoApellidoP);
        textoApellidoP.setBounds(20, 180, 160, 25);
        panel.add(apellido_paterno);
        apellido_paterno.setBounds(170, 180, 200, 25);
        panel.add(verificacion3);
        verificacion3.setBounds(370, 180, 250, 25);
        panel.add(textoApellidoM);
        textoApellidoM.setBounds(20, 210, 160, 25);
        panel.add(apellido_materno);
        apellido_materno.setBounds(170, 210, 200, 25);
        panel.add(verificacion4);
        verificacion4.setBounds(370, 210, 250, 25);
        panel.add(textoSexo);
        textoSexo.setBounds(20, 240, 150, 25);
        panel.add(sexo);
        sexo.setBounds(170, 240, 30, 25);
        panel.add(verificacion5);
        verificacion5.setBounds(230, 240, 250, 25);
        panel.add(textoFechaN);
        textoFechaN.setBounds(20, 270, 160, 25);
        panel.add(fecha_nacimiento);
        fecha_nacimiento.setBounds(170, 270, 200, 25);
        panel.add(verificacion6);
        verificacion6.setBounds(370, 270, 250, 25);
        panel.add(textoNacionalidad);
        textoNacionalidad.setBounds(20, 300, 160, 25);
        panel.add(nacionalidad);
        nacionalidad.setBounds(170, 300, 200, 25);
        panel.add(verificacion7);
        verificacion7.setBounds(370, 300, 250, 25);
        panel.add(botonAgregar);
        botonAgregar.setBounds(400, 330, 100, 25);
        
        panel.add(separacion2);
        separacion2.setBounds(0, 360, 790, 1);
        
        panel.add(textoHabitacion);
        textoHabitacion.setBounds(20, 370, 160, 25);
        panel.add(mHabitaciones);
        mHabitaciones.setBounds(170, 370, 200, 25);
        panel.add(textoTotalClientes);
        textoTotalClientes.setBounds(20, 400, 160, 25);
        panel.add(totalClientes);
        totalClientes.setBounds(170, 400, 30, 25);
        panel.add(verificacion8);
        verificacion8.setBounds(210, 400, 250, 25);
        panel.add(textoModalidad);
        textoModalidad.setBounds(20, 430, 150, 25);
        panel.add(m1);
        m1.setBounds(160, 430, 20, 20);
        panel.add(textoMomento);
        textoMomento.setBounds(190, 430, 150, 25);
        panel.add(verificacion9);
        verificacion9.setBounds(350, 430, 250, 25);
        panel.add(m2);
        m2.setBounds(160, 460, 20, 20);
        panel.add(textoJornada);
        textoJornada.setBounds(190, 460, 150, 25);
        panel.add(textoHoraIn);
        textoHoraIn.setBounds(20, 490, 160, 25);
        panel.add(hora1);
        hora1.setBounds(180, 490, 30, 25);
        panel.add(textoDosPuntos);
        textoDosPuntos.setBounds(213, 490, 10, 25);
        panel.add(hora2);
        hora2.setBounds(220, 490, 30, 25);
        panel.add(verificacion10);
        verificacion10.setBounds(260, 490, 250, 25);
        panel.add(textoFechaIn);
        textoFechaIn.setBounds(20, 520, 160, 25);
        panel.add(fecha1);
        fecha1.setBounds(180, 520, 30, 25);
        panel.add(textoSeparador1);
        textoSeparador1.setBounds(213, 520, 10, 25);
        panel.add(fecha2);
        fecha2.setBounds(220, 520, 30, 25);
        panel.add(textoSeparador2);
        textoSeparador2.setBounds(253, 520, 10, 25);
        panel.add(fecha3);
        fecha3.setBounds(260, 520, 30, 25);
        panel.add(verificacion11);
        verificacion11.setBounds(300, 520, 250, 25);
 
        panel.add(textoValorPersona);
        textoValorPersona.setBounds(450, 490, 150, 25);
        panel.add(valorPersona);
        valorPersona.setBounds(600, 490, 80, 25);
        panel.add(botonCalcular);
        botonCalcular.setBounds(470, 520, 100, 25);
        panel.add(mensajeClienteAgregado);
        mensajeClienteAgregado.setBounds(500, 330, 200, 25);
        
        
        panel.add(botonIngresar);
        botonIngresar.setBounds(550, 570, 100, 25);
        panel.add(verificacion12);
        verificacion12.setBounds(530, 600, 250, 25);
        
       // panel.add(clienteAmor);//parece q no lo usaremos
        
  
    
         ventana.add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==botonBuscar) {
            textoClienteAmor.setText("");
            verificacion1.setText("");
            mensajeClienteAgregado.setText("");
            if (controlador.verificarRut(rut.getText())) {
                if (controlador.existeCliente(rut.getText())) {
                    if (controlador.esClienteAmor(rut.getText())) {
                        textoClienteAmor.setText("Felicidades, es el cliente del Amor <3");
                    } else {
                        textoClienteAmor.setText("Cliente existente");
                    }
                    cliente = controlador.cliente(rut.getText());
                    nombres.setText(cliente.getNombres());
                    apellido_paterno.setText(cliente.getApellido_paterno());
                    apellido_materno.setText(cliente.getApellido_materno());
                    sexo.setText(cliente.getSexo()+"");
                    fecha_nacimiento.setText(cliente.getFecha_nacimiento());
                    nacionalidad.setText(cliente.getNacionalidad());
                    
                } else {
                    textoClienteAmor.setText("El cliente no existe, por favor llenar los campos");
                }
            }  else {
                verificacion1.setText("Rut incorrecto ej:12345678-9");
            }
        }
        
        if (e.getSource()==botonAgregar) {
            boolean sePuede=true;
            limpiarMensajes();
            if (!calculo) {
                verificacion8.setText("Calcule valor");
                sePuede = false;
            }
            
            if (cliente==null) {
                if(nombres.getText().compareTo("")==0) {
                    sePuede=false;
                    verificacion2.setText("Debe ingresar nombre");
                }
                if(apellido_paterno.getText().compareTo("")==0) {
                    sePuede=false;
                    verificacion3.setText("Debe ingresar apellido");
                }
                if(apellido_materno.getText().compareTo("")==0) {
                    sePuede=false;
                    verificacion4.setText("Debe ingresar apellido");
                }
                if(sexo.getText().compareTo("F")!=0 && sexo.getText().compareTo("M")!=0) {
                    sePuede=false;
                    verificacion5.setText("Debe ingresar F o M");
                }
                if(fecha_nacimiento.getText().compareTo("")==0) {
                    sePuede=false;
                    verificacion6.setText("Debe ingresar fecha");
                }
                if(nacionalidad.getText().compareTo("")==0) {
                    sePuede=false;
                    verificacion7.setText("Debe ingresar nacionalidad");
                }
                if (sePuede) {
                    cliente= new ClienteVO(rut.getText(), nombres.getText(), apellido_paterno.getText(), apellido_materno.getText(), sexo.getText().charAt(0), fecha_nacimiento.getText(), nacionalidad.getText());
                    if (controlador.insertarCliente(cliente)){
                        ruts = ruts + rut.getText() +"\n";
                        costoTotal = costoTotal + costoRelativo;
                        clientesIngresados.setText(ruts);
                        mensajeClienteAgregado.setText("Cliente agregado");
                        rut.setText("");
                        cliente=null;
                    } else {
                        mensajeClienteAgregado.setText("No se pudo agregar");
                    }
                }
                
            } else {
                if (calculo) {
                    ruts = ruts + rut.getText() + "\n";
                    costoTotal = costoTotal + costoRelativo;
                    clientesIngresados.setText(ruts);
                    limpiarCampos();
                    limpiarMensajes();
                    mensajeClienteAgregado.setText("Cliente agregado");
                    cliente = null;
                }
            }
        }
        
        if (e.getSource()==botonCalcular) {
            verificacion8.setText("");
            verificacion9.setText("");
            if (!m1.isSelected() && !m2.isSelected()) {
                verificacion9.setText("Seleccione modalidad");
            }
            if (totalClientes.getText().compareTo("")==0) {
                verificacion8.setText("Ingrese cantidad de clientes");
            } else {
                if (!controlador.verificarCantidadClientes(totalClientes.getText())) {
                    verificacion8.setText("Ingrese cantidad válida");
                } else {
                    try { 
                        numeroDeClientes = Integer.parseInt(totalClientes.getText());
                    }catch (NumberFormatException nf) {                    
                    }
                    if (numeroDeClientes>0 && numeroDeClientes<20) {
                        if (m1.isSelected()) {
                            calculo = true;
                            if (controlador.esClienteAmor(rut.getText()) && controlador.premio()) {
                                valorPersona.setText("0");
                                costoRelativo = 0;
                            } else {
                                costoRelativo = controlador.valorPorPersona(numeroDeClientes, 1 ,(String)mHabitaciones.getSelectedItem());
                                valorPersona.setText("" + costoRelativo);
                            }
                        }
                            
                        if(m2.isSelected()) {
                            calculo = true;
                            if (controlador.esClienteAmor(rut.getText()) && controlador.premio()) {
                                valorPersona.setText("0");
                                costoRelativo = 0;
                            } else {
                                costoRelativo = controlador.valorPorPersona(numeroDeClientes, 2 ,(String)mHabitaciones.getSelectedItem());
                                valorPersona.setText("" + costoRelativo);   
                            }
                        }
                    }
                }
            }
        }
        
        if (e.getSource()== botonIngresar) {
            limpiarMensajes();
            boolean sePuede = true;
            String[] n = ruts.split("\n");
            if (!controlador.verificarCantidadClientes(totalClientes.getText())) {
                sePuede = false;
            } else {
                try { 
                        numeroDeClientes = Integer.parseInt(totalClientes.getText());
                        if (numeroDeClientes != n.length) {
                            verificacion12.setText("No coincide cantidad con clientes");
                            sePuede = false;
                        }
                    }catch (NumberFormatException nf) {   
                        sePuede = false;
                    }
            }
            if (!controlador.verificarHora(hora1.getText(), hora2.getText())) {
                verificacion10.setText("Hora incorrecta");
                sePuede = false;
            }
            if (!controlador.verificarFecha(fecha1.getText(), fecha2.getText(), fecha3.getText())) {
                verificacion11.setText("Fecha incorrecta");
                sePuede = false;
            }
            if (ruts.compareTo("")!=0) {
                if (sePuede) {
                    int modalidad = 0;
                    if (m1.isSelected()) {
                        modalidad = 1;
                    }
                    if (m2.isSelected()) {
                        modalidad = 2;
                    }
                    String fecha_hora_ingreso = hora1.getText() + ":" + hora2.getText() + " " + fecha1.getText() + "/" + fecha2.getText() + "/" + fecha3.getText();
                    ingreso = new IngresoVO((String)mHabitaciones.getSelectedItem(), numeroDeClientes, modalidad, costoTotal, fecha_hora_ingreso);
                    if (controlador.generarIngresoEHistorio(ingreso, ruts)) {
                        limpiarMensajes();
                        limpiarCampos();
                        verificacion12.setText("Ingreso realizado con éxito");
                        controlador.ocuparHabitacion((String)mHabitaciones.getSelectedItem());
                    } else {
                        verificacion12.setText("Ingreso no realizado");
                    }
                }
            }
            
        }
        
      
    }
    
    private void letra(JTextField o) {
        o.setFont(new Font("Arial",Font.LAYOUT_LEFT_TO_RIGHT, 16));
    }
    
    private void letra(JLabel o) {
        o.setFont(new Font("Arial",Font.LAYOUT_LEFT_TO_RIGHT, 16));
    }
    
    private void limpiarMensajes() {
        verificacion1.setText("");
        verificacion2.setText("");
        verificacion3.setText("");
        verificacion4.setText("");
        verificacion5.setText("");
        verificacion6.setText("");
        verificacion7.setText("");
        verificacion8.setText("");
        verificacion9.setText("");
        verificacion10.setText("");
        verificacion11.setText("");
        verificacion12.setText("");
        mensajeClienteAgregado.setText("");
        textoClienteAmor.setText("");
        
    }
    private void limpiarCampos() {
        rut.setText("");
        nombres.setText("");
        apellido_paterno.setText("");
        apellido_materno.setText("");
        sexo.setText("");
        fecha_nacimiento.setText("");
        nacionalidad.setText("");
        calculo=false;
        valorPersona.setText("");
    }
    
    public void setVisible() {
        ventana.setVisible(true);
        limpiarCampos();
        limpiarMensajes();
        mHabitaciones= new JComboBox(controlador.listaHabitacionesDisponibles());
        costoTotal = 0;
        ruts = "";
        totalClientes.setText("");
        fecha1.setText("");
        fecha2.setText("");
        fecha3.setText("");
        hora1.setText("");
        hora2.setText("");
        clientesIngresados.setText("");
        cliente = null;
    }
    
}
