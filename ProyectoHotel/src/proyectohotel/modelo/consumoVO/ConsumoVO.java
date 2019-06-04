
package proyectohotel.modelo.consumoVO;

public class ConsumoVO {
    private int codigo_producto;
    private int cantidad_pedida;
    private int numero_orden;

    public ConsumoVO(int codigo_producto, int cantidad_pedida, int numero_orden) {
        this.codigo_producto = codigo_producto;
        this.cantidad_pedida = cantidad_pedida;
        this.numero_orden = numero_orden;
    }

    public int getCodigo_producto() {
        return codigo_producto;
    }

    public int getCantidad_pedida() {
        return cantidad_pedida;
    }

    public int getNumero_orden() {
        return numero_orden;
    }

    public void setCodigo_producto(int codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    public void setCantidad_pedida(int cantidad_pedida) {
        this.cantidad_pedida = cantidad_pedida;
    }

    public void setNumero_orden(int numero_orden) {
        this.numero_orden = numero_orden;
    }

    @Override
    public String toString() {
        return  codigo_producto + ", " + cantidad_pedida + ", " + numero_orden;
    }
    
    
}
