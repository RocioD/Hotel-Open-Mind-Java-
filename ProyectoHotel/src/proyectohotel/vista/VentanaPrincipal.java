
package proyectohotel.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.MenuSelectionManager;
import proyectohotel.vista.opciones.Habitaciones;

public class VentanaPrincipal implements ActionListener{
    private JFrame ventana;
    private JMenuBar menu;
    private MenuSelectionManager selec;
    private JMenuItem item1;
    private JMenuItem item2;
    private JOptionPane prueba;
    private JButton[] opciones;
    private Habitaciones habitaciones;
    
    public VentanaPrincipal() {
        habitaciones = new Habitaciones();
        ventana = new JFrame("Prueba");
        ventana.setBounds(200, 200, 300, 300);
        JPanel panel = new JPanel();
        menu = new JMenuBar();
        item1 = new JMenuItem("Habitación 1");
        item1.addActionListener(this);
        item2 = new JMenuItem("Habitación 2");
        item2.addActionListener(this);
        
        /*int seleccion;
        
        opciones = new JButton[10];
        opciones[0] = new JButton("Habitación lunar"); //(, , , LoveChair,
        opciones[1] = new JButton("Parque de diversiones");
        opciones[2] = new JButton("Túnel subterráneo");
        opciones[3] = new JButton("Habitación lunar");
        opciones[4] = new JButton("Habitación lunar");
        opciones[5] = new JButton("Habitación lunar");
        opciones[6] = new JButton("Habitación lunar");
        opciones[7] = new JButton("Habitación lunar");
        opciones[8] = new JButton("Habitación lunar");
        opciones[9] = new JButton("Habitación lunar");
        
        
        prueba = (JOptionPane) JOptionPane.showInputDialog(null,"Selecciona habitación", "Elegir",JOptionPane.QUESTION_MESSAGE,null,opciones, opciones[0]);
        prueba.setBounds(30, 50, 200, 30); // Configure
      
        */

        //JDialog dialog = prueba.createDialog(opciones[0], "Seleccione ");
        //dialog.show();
        //Object selectedValue = prueba.getValue();
             
     //If there is an array of option buttons:
        //for(int counter = 0, maxCounter = opciones.length;
          //  counter < maxCounter; counter++) {
            //if(opciones[counter].equals(selectedValue))
              //  seleccion = counter;
            //}
        
        
        
        menu.add(item1);
        menu.add(item2);
        panel.add(menu);
        ventana.add(panel);
        ventana.setVisible(true);
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
