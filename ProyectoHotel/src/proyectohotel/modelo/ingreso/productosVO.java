package proyectohotel.modelo.ingreso;

public class productosVO {

    private Integer Codigo_Producto;
    private Integer Valor_Unitario;
    private String Nombre_Producto;
    private Integer Cantidad_Inventario;

    public Integer getCodigo_Producto() {
        return Codigo_Producto;
    }

    public Integer getValor_Unitario() {
        return Valor_Unitario;
    }

    public String getNombre_Producto() {
        return Nombre_Producto;
    }

    public Integer getCantidad_Inventario() {
        return Cantidad_Inventario;
    }

    public void setCodigo_Producto(Integer Codigo_Producto) {
        this.Codigo_Producto = Codigo_Producto;
    }

    public void setValor_Unitario(Integer Valor_Unitario) {
        this.Valor_Unitario = Valor_Unitario;
    }

    public void setNombre_Producto(String Nombre_Producto) {
        this.Nombre_Producto = Nombre_Producto;
    }

    public void setCantidad_Inventario(Integer Cantidad_Inventario) {
        this.Cantidad_Inventario = Cantidad_Inventario;
    }
}
