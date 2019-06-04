
package proyectohotel;

import proyectohotel.controlador.Controlador;
import proyectohotel.modelo.DBManagerDAO;
import proyectohotel.modelo.clienteVO.ClienteVO;
import proyectohotel.vista.VentInformesDeSistema;
import proyectohotel.vista.VentanaIngresoClientes;
import proyectohotel.vista.VentanaInicio;


public class Laucher {

    public static void main(String[] args) {
        
        VentanaInicio v2 = new VentanaInicio();
        Controlador controlador = new Controlador();
        System.out.println(controlador.cliente("13158123-4"));
     
    }
    
}
