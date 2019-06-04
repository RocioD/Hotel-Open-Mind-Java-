package proyectohotel.modelo.consumoVO;

import java.util.Enumeration;
import java.util.Hashtable;
import proyectohotel.controlador.Controlador;
import proyectohotel.modelo.ingreso.IngresoVO;

public class ListaConsumoVO {

    private Hashtable consumos; //String numero_orden + - + codigo_producto
    private Controlador controlador;

    public ListaConsumoVO() {
        consumos = new Hashtable();
        controlador = new Controlador();
    }

    public boolean agregarConsumo(ConsumoVO nuevo) {
        String key = nuevo.getNumero_orden() + "-" + nuevo.getCodigo_producto();
        if (tieneElementos()) {
            if (consumos.containsKey(key)) {
                int total = nuevo.getCantidad_pedida() + ((ConsumoVO) (consumos.get(key))).getCantidad_pedida();
                nuevo.setCantidad_pedida(total);
                consumos.replace(key, nuevo);
            } else {
                consumos.put(key, nuevo);
            }
        } else {
            consumos.put(key, nuevo);
        }
        return consumos.containsKey(key);
    }

    public boolean agregarConsumoNuevo(ConsumoVO nuevo) {
        String key = nuevo.getNumero_orden() + "-" + nuevo.getCodigo_producto();
        if (tieneElementos()) {
            if (consumos.containsKey(key)) {
                controlador.actualizarStock(nuevo.getCodigo_producto(), nuevo.getCantidad_pedida());
                int total = nuevo.getCantidad_pedida() + ((ConsumoVO) (consumos.get(key))).getCantidad_pedida();
                nuevo.setCantidad_pedida(total);
                consumos.replace(key, nuevo);
            } else {
                consumos.put(key, nuevo);
                controlador.actualizarStock(nuevo.getCodigo_producto(), nuevo.getCantidad_pedida());
            }
        } else {
            consumos.put(key, nuevo);
            controlador.actualizarStock(nuevo.getCodigo_producto(), nuevo.getCantidad_pedida());
        }
        return consumos.containsKey(key);
    }

    public void recorrer() {
        Enumeration e = consumos.keys();
        Object clave;
        Object valor;
        while (e.hasMoreElements()) {
            clave = e.nextElement();
            valor = consumos.get(clave);
        }
    }

    public void grabarConsumos() {
        Enumeration e = consumos.keys();
        Object clave;
        ConsumoVO valor;
        while (e.hasMoreElements()) {
            clave = e.nextElement();
            valor = (ConsumoVO) consumos.get(clave);
            controlador.ingresarOModificarPedido(valor);
        }
    }

    public void limpiar() {
        consumos.clear();
    }

    public boolean tieneElementos() {
        return !consumos.isEmpty();
    }
}
