package proyectohotel.vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import proyectohotel.controlador.Controlador;
import proyectohotel.modelo.ingreso.productosVO;
import proyectohotel.modelo.DBManagerDAO;

public class VentanaCatalogoDeProductos implements ActionListener {

    private JFrame ventanacatalogoDeProductos;
    private JLabel titulo;
    private JTable table;
    private JScrollPane spTable;

    public VentanaCatalogoDeProductos() {
        init();
        initComponentes();
        construirTabla();
        ventanacatalogoDeProductos.setVisible(true);
    }

    private void init() {
        ventanacatalogoDeProductos = new JFrame("Catalogo de Productos");
        ventanacatalogoDeProductos.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        ventanacatalogoDeProductos.setBounds(150, 20, 800, 700);
        ventanacatalogoDeProductos.setResizable(false);
    }

    private void initComponentes() {
        JPanel panel = new JPanel(null);
        panel.setBackground(new Color(230, 150, 220));

        titulo = new JLabel("Catalogo de Productos");
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        spTable = new JScrollPane(table);
        spTable.setBounds(20, 72, 600, 300);
        panel.add(spTable);

        panel.add(titulo);
        titulo.setBounds(300, 20, 200, 30);

        ventanacatalogoDeProductos.add(panel);
    }

    private void construirTabla() {
        String titulos[] = {"codigo", "Producto", "Valor", "Cantidad"};
        String informacion[][] = obtenerMatriz();
        table = new JTable(informacion, titulos);
        spTable.setViewportView(table);
    }

    private String[][] obtenerMatriz() {

        Controlador micontrolador = new Controlador();
        ArrayList<productosVO> miLista = micontrolador.buscarproductosConMatriz();

        String matrizInfo[][] = new String[miLista.size()][4];

        for (int i = 0; i < miLista.size(); i++) {
            matrizInfo[i][0] = miLista.get(i).getCodigo_Producto() + "";
            matrizInfo[i][1] = miLista.get(i).getNombre_Producto() + "";
            matrizInfo[i][2] = miLista.get(i).getValor_Unitario() + "";
            matrizInfo[i][3] = miLista.get(i).getCantidad_Inventario() + "";
        }

        return matrizInfo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    public void setVisible() {
        ventanacatalogoDeProductos.setVisible(true);
        construirTabla();
    }
}
