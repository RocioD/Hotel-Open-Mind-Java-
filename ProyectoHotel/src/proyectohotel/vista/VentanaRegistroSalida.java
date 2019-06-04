/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import proyectohotel.controlador.Controlador;



public class VentanaRegistroSalida implements ActionListener{
    
    private JFrame ventanaregistrosalida;
    private JLabel titulo;
    private JLabel textohabitacion;
    private JLabel textoresumen;
    private JComboBox habitacion;
    private JButton resumen;
    private JTextArea visualizarresumen;
    private Controlador controlador;
    
     public VentanaRegistroSalida() {
        init();
        initComponentes();
        ventanaregistrosalida.setVisible(true);
    }
     
      private void init() {
        ventanaregistrosalida = new JFrame("Registro de salida");
        ventanaregistrosalida.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        ventanaregistrosalida.setBounds(150, 20, 800, 700);
        ventanaregistrosalida.setResizable(false);
    }
      
      private void initComponentes() {
        JPanel panel = new JPanel(null);
        panel.setBackground(new Color(230,150,220));
        
        titulo = new JLabel("Registro de salida");
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        textohabitacion = new JLabel("Habitacion:");
        letra(textohabitacion);
        textoresumen = new JLabel("Resumen:");
        letra(textoresumen);
        habitacion = new JComboBox(controlador.listaHabitacionesOcupadas());

        resumen = new JButton("Aceptar");
        
        visualizarresumen =new JTextArea();
        
         panel.add(titulo);
        titulo.setBounds(300, 20, 200, 30);
   
        panel.add(textohabitacion);
        textohabitacion.setBounds(20, 80, 150, 25);
        panel.add(habitacion);
        habitacion.setBounds(170, 80, 200, 25);
        panel.add(textoresumen);
        textoresumen.setBounds(20, 150, 150, 25);
        panel.add(resumen);
        resumen.setBounds(170, 150, 100, 25);
        panel.add(visualizarresumen);
        visualizarresumen.setBounds(20, 280, 700, 200);
        ventanaregistrosalida.add(panel);
        
        
}

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resumen) {
            
        }
    }
    private void letra(JTextField o) {
        o.setFont(new Font("Arial",Font.LAYOUT_LEFT_TO_RIGHT, 16));
    }
    
    private void letra(JLabel o) {
        o.setFont(new Font("Arial",Font.LAYOUT_LEFT_TO_RIGHT, 16));
    }
    
    public void setVisible() {
        ventanaregistrosalida.setVisible(true);
    }
    
}
