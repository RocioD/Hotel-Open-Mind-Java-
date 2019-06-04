package proyectohotel.controlador;

import java.util.Enumeration;
import java.util.Random;
import proyectohotel.modelo.DBManagerDAO;
import proyectohotel.modelo.clienteVO.ClienteVO;
import proyectohotel.modelo.consumoVO.ConsumoVO;
import proyectohotel.modelo.consumoVO.ListaConsumoVO;
import proyectohotel.modelo.ingreso.IngresoVO;
import proyectohotel.modelo.ingreso.productosVO;
import java.util.ArrayList;
import proyectohotel.modelo.DBManagerDAO;

public class Controlador {

    private DBManagerDAO dbManager;

    public Controlador() {

        dbManager = DBManagerDAO.obtenerInstancia();
    }

    public boolean existeCliente(String rut) {
        boolean resultado = false;
        resultado = dbManager.existeCliente(rut);
        return resultado;
    }

    public boolean insertarCliente(ClienteVO nuevo) {
        boolean resultado = false;
        resultado = dbManager.insertarCliente(nuevo);
        return resultado;
    }

    public ClienteVO cliente(String rut) {
        String cliente = dbManager.cliente(rut);
        String[] datos = cliente.split("#");
        ClienteVO clienteVO = new ClienteVO(datos[0], datos[1], datos[2], datos[3], datos[4].charAt(0), datos[5], datos[6]);
        return clienteVO;
    }

    public boolean habitacionDisponible(String habitacion) {
        boolean disponible = false;
        disponible = dbManager.habitacionDisponible(habitacion);
        return disponible;
    }

    public boolean generarIngreso(IngresoVO nuevo) {
        boolean disponible = false;
        disponible = dbManager.generarIngreso(nuevo);
        return disponible;
    }

    public ClienteVO[] clientesAmor() {
        String clienteAmor = dbManager.clienteAmor();
        String ruts[] = clienteAmor.split("#");
        ClienteVO[] clientes = new ClienteVO[ruts.length];
        for (int i = 0; i < ruts.length; i++) {
            clientes[i] = cliente(ruts[i]);
        }
        return clientes;

    }

    public boolean esClienteAmor(String rut) {
        ClienteVO[] clientesAmor = clientesAmor();
        for (int i = 0; i < clientesAmor.length; i++) {
            if (clientesAmor[i].getRut().compareTo(rut) == 0) {
                return true;
            }
        }
        return false;
    }

    public int numeroVisitasTolal(String rut) {
        return dbManager.numeroVisitasTotal(rut);
    }

    public String registros(String rut) {
        return dbManager.registros(rut);
    }

    public String habitacionFavorita(String rut) {
        return dbManager.habitacionFavorita(rut);
    }

    public String habitacionMasUtilizada() {
        return dbManager.habitacionMasUtilizada();
    }

    public String habitacionMenosUtilizada() {
        return dbManager.habitacionMenosUtilizada();
    }

    public String habitacionConMasClientesPromedio() {
        return dbManager.habitacionConMasClientesPromedio();
    }

    public String habitacionesYClientesPromedio() {
        return dbManager.habitacionesYClientesPromedio();
    }

    public String clientesHabitacion(String habitacion) {
        return dbManager.clientesHabitacion(habitacion);
    }

    public String[] listaHabitacionesDisponibles() {
        String lista = dbManager.listaHabitacionesDisponibles();
        if (lista.compareTo("") != 0) {
            return lista.split("-");
        }
        String mensaje[] = new String[1];
        mensaje[0] = "No hay habitaciones disponibles";
        return mensaje;
    }

    public String[] listaHabitacionesOcupadas() {
        String lista = dbManager.listaHabitacionesOcupadas();
        if (lista.compareTo("") != 0) {
            return lista.split("-");
        }
        String mensaje[] = new String[1];
        mensaje[0] = "No hay habitaciones ocupadas";
        return mensaje;
    }

    public String[] listaProductos() {
        String lista = dbManager.getProductos();
        if (lista.compareTo("") != 0) {
            return lista.split("#");
        }
        String mensaje[] = new String[1];
        mensaje[0] = "No hay productos";
        return mensaje;
    }

    public String productosPorHabitacion(String habitacion) {
        return dbManager.productosPorHabitacion(habitacion);
    }

    public int valorProducto(int codigo_producto) {
        return dbManager.valorProducto(codigo_producto);
    }

    public String nombreProducto(int codigo_producto) {
        return dbManager.nombreProducto(codigo_producto);
    }

    public int codigoProductoMasVendido() {
        return dbManager.codigoProductoMasVendido();
    }

    public int codigoProductoMenosVendido() {
        return dbManager.codigoProductoMenosVendido();
    }

    public String informeProducto(int codigo_producto) {
        String informe = "Producto: " + nombreProducto(codigo_producto)
                + "  Codigo: " + codigo_producto + "\n\nDonde más se vende: \n" + habitacionDondeMasSeVende(codigo_producto)
                + "\n\nDonde menos se vende: \n" + habitacionDondeMenosSeVende(codigo_producto);
        return informe;
    }

    public String habitacionDondeMasSeVende(int codigo_producto) {
        return dbManager.habitacionDondeMasSeVende(codigo_producto);
    }

    public String habitacionDondeMenosSeVende(int codigo_producto) {
        return dbManager.habitacionDondeMenosSeVende(codigo_producto);
    }

    public String productosPorNumeroOrden(int numero_orden) {
        return dbManager.productosPorNumeroOrden(numero_orden);
    }

    public int dineroPorUsoHabitacionPorUnaOrden(int numero_orden) {
        return dbManager.dineroPorUsoHabitacionPorUnaOrden(numero_orden);
    }

    public String informeGastosPorRut(String rut) {
        String registros[] = registros(rut).split("\n");
        String gastos = "";
        String productos[];
        int sum = 0;
        for (int i = 0; i < (registros.length); i++) {
            String partes[] = registros[i].split("  -  ");
            int numero_orden = Integer.parseInt(partes[0]);
            int totalHabitacion = dineroPorUsoHabitacionPorUnaOrden(numero_orden);
            if (productosPorNumeroOrden(numero_orden).compareTo("") != 0) {
                productos = productosPorNumeroOrden(numero_orden).split("\n");
                gastos = gastos + registros[i] + "\nConsumo:\n";
                sum = 0;
                for (int j = 0; j < productos.length; j++) {
                    String partes2[] = productos[j].split("#");// codigo, cantidad
                    int codigo = Integer.parseInt(partes2[0]);
                    String nombre = nombreProducto(codigo);
                    int precioTotal = valorProducto(codigo) * Integer.parseInt(partes2[1]);
                    gastos = gastos + "Producto código: " + codigo + " " + nombre + " Cantidad: " + partes2[1] + " Total gastado: $" + precioTotal + "\n";
                    sum = sum + precioTotal;
                }

                gastos = gastos + "Total utilizado en productos: $" + sum + "\nDinero por arriendo de habitación: $"
                        + totalHabitacion + "\nTotal utilizado en estadía: $"
                        + (totalHabitacion + sum) + "\n\n";
            } else {
                gastos = gastos + registros[i] + "\nConsumo:\n" + "No hay productos consumidos \n"
                        + "Dinero por arriendo de habitación: $" + totalHabitacion + "\n";
            }
        }
        return gastos;
    }

    public String informeGastosPorUnaOrden(int numero_orden) {
        if (productosPorNumeroOrden(numero_orden).compareTo("") != 0) {
            String productos[] = productosPorNumeroOrden(numero_orden).split("\n");
            String gastos = "";
            int sum = 0;
            for (int i = 0; i < productos.length; i++) {
                String partes[] = productos[i].split("#");// codigo, cantidad
                int codigo = Integer.parseInt(partes[0]);
                String nombre = nombreProducto(codigo);
                int precioTotal = valorProducto(codigo) * Integer.parseInt(partes[1]);
                gastos = gastos + "Producto código: " + codigo + " " + nombre + " Cantidad: " + partes[1] + " Total gastado: $" + precioTotal + "\n";
                sum = sum + precioTotal;
            }
            gastos = gastos + "Total utilizado en productos: $" + sum + "\nDinero por arriendo de habitación: $"
                    + dineroPorUsoHabitacionPorUnaOrden(numero_orden) + "\nTotal utilizado en estadía: $"
                    + (dineroPorUsoHabitacionPorUnaOrden(numero_orden) + sum);
            return gastos;
        }
        return "No hay productos consumidos \nDinero por arriendo de habitación: $"
                + dineroPorUsoHabitacionPorUnaOrden(numero_orden);
    }

    public String gastoPeriodoYTotalProductos(String habitacion) {
        int sum = 0;
        String gastos = "";
        String productos[] = productosPorHabitacion(habitacion).split("\n");
        for (int i = 0; i < productos.length; i++) {
            String partes[] = productos[i].split("#");//orden, codigo, cantidad
            int codigo = Integer.parseInt(partes[1]);
            String nombre = nombreProducto(codigo);
            int precioTotal = valorProducto(codigo) * Integer.parseInt(partes[2]);
            gastos = gastos + "Orden n°: " + partes[0] + " Producto código: "
                    + codigo + " " + nombre + " Cantidad: " + partes[2] + " Total gastado: $" + precioTotal + "\n";
            sum = sum + precioTotal;
        }
        gastos = gastos + "Total utilizado en productos: $" + sum;
        return gastos;
    }

    public int dineroTotalPorUsoHabitacion(String habitacion) {
        return dbManager.dineroTotalPorUsoHabitacion(habitacion);
    }

    public String dineroPorUsoHabitacionPorOrden(String habitacion) {
        return dbManager.dineroPorUsoHabitacionPorOrden(habitacion);
    }

    public String gastoPeriodoYTotal(String habitacion) {
        int sum = 0;
        String gastos = "";
        String productos[] = productosPorHabitacion(habitacion).split("\n");
        for (int i = 0; i < productos.length; i++) {
            String partes[] = productos[i].split("#");//orden, codigo, cantidad
            int codigo = Integer.parseInt(partes[1]);
            String nombre = nombreProducto(codigo);
            int precioTotal = valorProducto(codigo) * Integer.parseInt(partes[2]);
            gastos = gastos + "Orden n°: " + partes[0] + " Producto código: "
                    + codigo + " " + nombre + " Cantidad: " + partes[2] + " Total gastado: $" + precioTotal + "\n";
            sum = sum + precioTotal;
        }
        gastos = gastos + "Total utilizado en productos: $" + sum + "\n\nDetalle dinero por uso de habitación:\n"
                + dineroPorUsoHabitacionPorOrden(habitacion) + "\nTotal utilizado por arriendo: $"
                + dineroTotalPorUsoHabitacion(habitacion) + "\n\nTotal dinero utilizado en la habitación: $"
                + (dineroTotalPorUsoHabitacion(habitacion) + sum);
        return gastos;
    }

    public boolean ocuparHabitacion(String habitacion) {
        boolean ocupar = false;
        ocupar = dbManager.ocuparHabitacion(habitacion);
        return ocupar;
    }

    public boolean desocuparHabitacion(String habitacion) {
        boolean desocupar = false;
        desocupar = dbManager.desocuparHabitacion(habitacion);
        return desocupar;
    }

    public boolean generarHistorico(int numero_orden, String rut) {
        boolean resultado = false;
        resultado = dbManager.generarHistorico(numero_orden, rut);
        return resultado;
    }

    public boolean generarIngresoEHistorio(IngresoVO ingreso, String ruts) {
        String rut[] = ruts.split("\n");
        String habitacion = ingreso.getHabitacion();
        String fecha_hora_ingreso = ingreso.getFecha_hora_ingreso();
        boolean resultado = generarIngreso(ingreso);
        int numero_orden = getNumeroOrden(habitacion, fecha_hora_ingreso);
        for (int i = 0; i < rut.length; i++) {
            generarHistorico(numero_orden, rut[i]);
        }
        return resultado;
    }

    public int getNumeroOrden(String habitacion, String fecha_hora_ingreso) {
        return dbManager.getNumeroOrden(habitacion, fecha_hora_ingreso);
    }

    public int getUltimoNumeroOrden(String habitacion) {
        return dbManager.getUltimoNumeroOrden(habitacion);
    }

    public String registrosDeUnIngreso(String numero_orden) {
        return dbManager.registrosDeUnIngreso(numero_orden);
    }

    public boolean ingresarPedido(ConsumoVO nuevo) {
        boolean resultado = false;
        resultado = dbManager.ingresarPedido(nuevo);
        return resultado;
    }

    public boolean modificarPedido(ConsumoVO nuevo) {
        boolean resultado = false;
        resultado = dbManager.modificarPedido(nuevo);
        return resultado;
    }

    public boolean existePedido(ConsumoVO consumo) {
        int codigo_producto = consumo.getCodigo_producto();
        int numero_orden = consumo.getNumero_orden();
        boolean resultado = false;
        resultado = dbManager.existePedido(codigo_producto, numero_orden);
        return resultado;
    }

    public boolean ingresarOModificarPedido(ConsumoVO consumo) {
        if (existePedido(consumo)) {
            return modificarPedido(consumo);
        }
        return ingresarPedido(consumo);
    }

    public ListaConsumoVO consumos() {
        return dbManager.consumos();
    }

    public int stockProducto(int codigo_producto) {
        return dbManager.stockProducto(codigo_producto);
    }

    public boolean actualizarStock(int codigo_producto, int cantidad_pedida) {
        boolean resultado = false;
        resultado = dbManager.actualizarStock(codigo_producto, cantidad_pedida);
        return resultado;
    }

    public int valorJornada(String habitacion) {
        return dbManager.precioJornada(habitacion);
    }

    public int valorMomento(String habitacion) {
        return dbManager.precioMomento(habitacion);
    }

    public int valorPorPersona(int numero_personas, int modalidad, String habitacion) {
        int valor = 0;
        if (modalidad == 1) { // 1 ->momento, 2 ->jornada
            if (numero_personas <= 2) {
                valor = valorMomento(habitacion);
            } else if (numero_personas < 7) {
                valor = (int) (valorMomento(habitacion) * (1 - 0.1 * (numero_personas - 2)));
            } else {
                valor = (int) (valorMomento(habitacion) * 0.5);
            }

        } else {
            if (numero_personas <= 2) {
                valor = valorJornada(habitacion);
            } else if (numero_personas < 7) {
                valor = (int) (valorJornada(habitacion) * (1 - 0.1 * (numero_personas - 2)));
            } else {
                valor = (int) (valorJornada(habitacion) * 0.5);
            }
        }
        return valor;
    }

    public boolean verificarRut(String rut) {
        int numeros;
        if (rut.length() < 9 || rut.length() > 10) {
            return false;
        }
        try {
            numeros = Integer.parseInt(rut.substring(0, (rut.length() - 2)));
        } catch (NumberFormatException ne) {
            return false;
        }
        if (rut.substring((rut.length() - 2), (rut.length() - 1)).compareTo("-") != 0) {
            return false;
        }
        if (rut.substring((rut.length() - 1), (rut.length())).compareTo("k") == 0) {
            return true;
        }
        int verificador;
        try {
            verificador = Integer.parseInt(rut.substring((rut.length() - 1), (rut.length())));
        } catch (NumberFormatException ne) {
            return false;
        }
        return true;
    }

    public boolean verificarHora(String shora, String sminuto) {
        int hora = 0;
        int minuto = 60;
        try {
            hora = Integer.parseInt(shora);
            minuto = Integer.parseInt(sminuto);
        } catch (NumberFormatException nf) {
            return false;
        }
        if (hora < 1 || hora > 24 || minuto < 0 || minuto > 59) {
            return false;
        }
        return true;
    }

    public boolean verificarFecha(String sdia, String smes, String saño) {
        int dia = 0;
        int mes = 60;
        int año = 0;
        try {
            dia = Integer.parseInt(sdia);
            mes = Integer.parseInt(smes);
            año = Integer.parseInt(saño);
        } catch (NumberFormatException nf) {
            return false;
        }
        if (año != 19) {
            return false;
        }
        if (mes < 1 || mes > 12) {
            return false;
        }
        if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
            if (dia < 1 || dia > 30) {
                return false;
            }
        }
        if (mes == 2) {
            if (dia < 1 || dia > 28) {
                return false;
            }
        }
        if (dia < 1 || dia > 31) {
            return false;
        }
        return true;
    }

    public boolean premio() {
        Random rn = new Random();
        int n = rn.nextInt(2);
        if (n == 0) {
            return false;
        }
        return true;
    }

    public boolean verificarCantidadClientes(String cantidad) {
        int numeroDeClientes = 0;
        if (cantidad.compareTo("") == 0) {
            return false;
        } else {
            try {
                numeroDeClientes = Integer.parseInt(cantidad);
            } catch (NumberFormatException nf) {
                return false;
            }
            if (numeroDeClientes < 1 || numeroDeClientes > 20) {
                return false;
            }
        }
        return true;
    }

    public boolean verificarCantidadPedida(String sCantidad, int codigo_producto) {
        int cantidad = -1;
        try {
            cantidad = Integer.parseInt(sCantidad);

        } catch (NumberFormatException nf) {
            return false;
        }
        if (cantidad < 1 || cantidad > stockProducto(codigo_producto)) {
            return false;
        }
        return true;
    }

    public ArrayList<productosVO> buscarproductosConMatriz() {
        return dbManager.buscarproductosConMatriz();
    }
}
