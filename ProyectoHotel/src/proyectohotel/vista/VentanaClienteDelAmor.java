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
import proyectohotel.modelo.clienteVO.ClienteVO;

public class VentanaClienteDelAmor implements ActionListener {

    private Controlador controlador;
    private ClienteVO[] clientesAmor;
    private JFrame ventanaclienteamor;
    private JLabel titulo;
    private JLabel textoRut;
    private JLabel textoNombre;
    private JLabel textosexo;
    private JLabel textofechanacimiento;
    private JLabel textonacionalidad;
    private JLabel textonvisitas;
    private JLabel textohfavorita;
    private JLabel textoregistros;
    private JLabel mensajeclientedelamor;
    private JTextArea registro;
    private JComboBox rut;
    private JTextField nombre;
    private JTextField sexo;
    private JTextField fechanacimiento;
    private JTextField nacionalidad;
    private JTextField nvisitas;
    private JTextField hfavorita;

    private JButton mostrar;

    public VentanaClienteDelAmor() {
        controlador = new Controlador();
        init();
        initComponentes();
        ventanaclienteamor.setVisible(true);
    }

    private void init() {
        ventanaclienteamor = new JFrame("Cliente del Amor");
        ventanaclienteamor.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        ventanaclienteamor.setBounds(150, 20, 800, 700);
        ventanaclienteamor.setResizable(false);
    }

    private void initComponentes() {
        JPanel panel = new JPanel(null);
        panel.setBackground(new Color(230, 150, 220));

        titulo = new JLabel("Cliente del Amor");
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        textoRut = new JLabel("Rut:");
        letra(textoRut);
        textoNombre = new JLabel("Nombre:");
        letra(textoNombre);
        textosexo = new JLabel("Sexo F/M:");
        letra(textosexo);
        textofechanacimiento = new JLabel("Fecha nacimiento:");
        letra(textofechanacimiento);
        textonacionalidad = new JLabel("Nacionalidad:");
        letra(textonacionalidad);
        textonvisitas = new JLabel("Numero de visitas:");
        letra(textonvisitas);
        textohfavorita = new JLabel("Habitación Favorita");
        letra(textohfavorita);
        textoregistros = new JLabel("Registros");
        letra(textoregistros);
        mostrar = new JButton("Mostrar");
        mostrar.addActionListener(this);

        rut = new JComboBox();
        actualizarRut();

        nombre = new JTextField(10);
        letra(nombre);
        sexo = new JTextField(10);
        letra(sexo);
        fechanacimiento = new JTextField(10);
        letra(fechanacimiento);
        nacionalidad = new JTextField(10);
        letra(nacionalidad);
        nvisitas = new JTextField(10);
        letra(nvisitas);
        hfavorita = new JTextField(10);
        letra(hfavorita);
        registro = new JTextArea();
        registro.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 16));

        panel.add(titulo);
        titulo.setBounds(300, 20, 200, 30);

        panel.add(textoRut);
        textoRut.setBounds(20, 80, 150, 25);
        panel.add(rut);
        rut.setBounds(170, 80, 150, 25);
        panel.add(mostrar);
        mostrar.setBounds(340, 100, 120, 25);
        panel.add(textoNombre);
        textoNombre.setBounds(20, 150, 150, 25);
        panel.add(nombre);
        nombre.setBounds(170, 150, 400, 25);
        panel.add(textosexo);
        textosexo.setBounds(20, 180, 150, 25);
        panel.add(sexo);
        sexo.setBounds(170, 180, 400, 25);
        panel.add(textofechanacimiento);
        textofechanacimiento.setBounds(20, 210, 150, 25);
        panel.add(fechanacimiento);
        fechanacimiento.setBounds(170, 210, 400, 25);
        panel.add(textonacionalidad);
        textonacionalidad.setBounds(20, 240, 150, 25);
        panel.add(nacionalidad);
        nacionalidad.setBounds(170, 240, 400, 25);
        panel.add(textonvisitas);
        textonvisitas.setBounds(20, 270, 160, 25);
        panel.add(nvisitas);
        nvisitas.setBounds(170, 270, 200, 25);
        panel.add(textohfavorita);
        textohfavorita.setBounds(20, 300, 160, 25);
        panel.add(hfavorita);
        hfavorita.setBounds(170, 300, 200, 25);
        panel.add(textoregistros);
        textoregistros.setBounds(20, 330, 150, 25);
        panel.add(registro);
        registro.setBounds(20, 360, 740, 200);
        ventanaclienteamor.add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mostrar) {
            String unRut = (String) rut.getSelectedItem();
            ClienteVO cliente = controlador.cliente(unRut);
            nombre.setText(cliente.getNombres() + " " + cliente.getApellido_paterno() + " " + cliente.getApellido_materno());
            sexo.setText(cliente.getSexo() + "");
            fechanacimiento.setText(cliente.getFecha_nacimiento());
            nacionalidad.setText(cliente.getNacionalidad());
            nvisitas.setText("" + controlador.numeroVisitasTolal(unRut));
            hfavorita.setText(controlador.habitacionFavorita(unRut));
            registro.setText(controlador.registros(unRut));
        }
    }

    private void letra(JLabel o) {
        o.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 16));
    }

    private void letra(JTextField o) {
        o.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 16));
    }

    public void setVisible() {
        ventanaclienteamor.setVisible(true);
        actualizarRut();
        fechanacimiento.setText("");
        nombre.setText("");
        sexo.setText("");
        nacionalidad.setText("");
        nvisitas.setText("");
        hfavorita.setText("");
        registro.setText("");
    }

    public void actualizarRut() {
        rut.removeAllItems();
        clientesAmor = controlador.clientesAmor();
        String[] ruts = new String[clientesAmor.length];
        for (int i = 0; i < clientesAmor.length; i++) {
            ruts[i] = clientesAmor[i].getRut();
            rut.addItem(ruts[i]);
        }
    }
}
