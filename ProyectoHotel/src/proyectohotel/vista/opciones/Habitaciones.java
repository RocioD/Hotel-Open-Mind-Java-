
package proyectohotel.vista.opciones;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class Habitaciones extends JFrame implements ItemListener {
    private JComboBox menu;
    private String[] opciones;
    
    public Habitaciones() {
        setSize(400, 400);
        setLayout(null);
        opciones = new String[10];
        opciones[0] = "Habitación lunar";
        opciones[1] = "Parque de diversiones";
        opciones[2] = "Túnel subterráneo";
        opciones[3] = "LoveChair";
        opciones[4] = "Cassandra";
        opciones[5] = "Vaquero";
        opciones[6] = "Egipcia";
        opciones[7] = "Kamasutra";
        opciones[8] = "Disco";
        opciones[9] = "La China";
        menu = new JComboBox(opciones);
        menu.setBounds(90, 40, 90, 20);
        menu.addItemListener(this);
        add(menu);
        setVisible(true);
    }

    
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource()==menu) {
            setTitle((String)menu.getSelectedItem());
        }
    }
    
    public static void main (String[] args) {
        new Habitaciones();
    }
            
}
