
package proyectohotel.modelo.consumoVO;

import java.util.Enumeration;
import java.util.Hashtable;
import proyectohotel.controlador.Controlador;
import proyectohotel.modelo.ingreso.IngresoVO;

public class ListaConsumoVO {
    private Hashtable< String , ConsumoVO> consumos; //String numero_orden + - + codigo_producto
    private Controlador controlador;
    
    public ListaConsumoVO () {
        Hashtable< String, ConsumoVO> consumos = new Hashtable<String, ConsumoVO>();
        controlador = new Controlador();
        
    } 
    
    public boolean agregarConsumo (ConsumoVO nuevo) {
        String key = nuevo.getNumero_orden() + "-" + nuevo.getCodigo_producto();
        if (tieneElementos()) {
            if (consumos.containsKey(key)) {
                int total = nuevo.getCantidad_pedida() + (consumos.get(key)).getCantidad_pedida();
                nuevo.setCantidad_pedida(total);
                consumos.replace(key, nuevo);
            }
        } else {
            consumos.put(key, nuevo);    
        }
        return consumos.containsKey(key);
    }
    
    
    public void recorrer() {
        Enumeration e = consumos.keys();
        Object clave;
        Object valor;
        while( e.hasMoreElements() ){
        clave = e.nextElement();
        valor = consumos.get( clave );
        }
    }
    
    public void grabarConsumos() {
        Enumeration e = consumos.keys();
        Object clave;
        ConsumoVO valor;
        while( e.hasMoreElements() ){
        clave = e.nextElement();
        valor = consumos.get(clave);
        controlador.ingresarPedido(valor);
        controlador.actualizarStock(valor.getCodigo_producto(), valor.getCantidad_pedida());
        }
    }
    public void limpiar() {
        consumos.clear();
    }
    
    public boolean tieneElementos() {
        return !consumos.isEmpty();
    }
    
}
