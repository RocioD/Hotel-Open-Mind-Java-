
package proyectohotel.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import proyectohotel.modelo.clienteVO.ClienteVO;
import proyectohotel.modelo.consumoVO.ConsumoVO;
import proyectohotel.modelo.ingreso.IngresoVO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import proyectohotel.modelo.ingreso.productosVO;

public class DBManagerDAO {
    private String url;
    private String user;
    private String pass;
    private Connection con;
    private static DBManagerDAO manager;
    
    private DBManagerDAO() {
        url = "jdbc:mysql://localhost:3307/das?useSSL=false";
        user = "root";
        pass="system";
        con=null;
        
    }
    
    public static DBManagerDAO obtenerInstancia() {
        if(manager==null) {
            manager = new DBManagerDAO();
        }
        return manager;
    }
    
    private boolean conectar() {
        try {
            con = DriverManager.getConnection(url, user, pass);
            return true;
        } catch (SQLException ex) {
            System.out.println("Error al conectar: [" + ex.getMessage() + "]");
        }
        return false;
    }
    
    private void desconectar() {
        if (con != null) {
            try {
                if (!con.isClosed()) {
                    con.close();       
                }
            } catch (SQLException ex) {
                System.out.println("Error al desconectar: [" + ex.getMessage() + "]");
            }
        }
    }

    
    public boolean existeCliente(String rut) {
        //'12032889-4'
        if (conectar()) {
            try {
               Statement st = con.createStatement();
               String sql = "Select rut from clientes where rut = '"+ rut + "'";
               ResultSet result = st.executeQuery(sql);
               boolean existe=(result.next());
               desconectar();
               return existe;
            } catch (SQLException ex) {
                System.out.println("Error al consultar : [" + ex.getMessage() + "]");
            }
            desconectar();
        }
        return false;
    }
    
     public boolean insertarCliente(ClienteVO nuevo) {
        if (conectar()) {
            try {
               Statement st = con.createStatement();
               String sql = "insert into clientes values (" + nuevo.toString() + ")"; //lanza automaticamente el toString 
               System.out.println("Insertando [" + sql + "]");
               int rowsAffected = st.executeUpdate(sql);
               desconectar();
               return (rowsAffected == 1);
            } catch (SQLException ex) {
                System.out.println("Error al insertar : [" + ex.getMessage() + "]");
            }
            desconectar();
        }
        return false;
    }
     
     public String cliente(String rut) {
         String cliente = "";
         if (this.conectar()) {
            try {
                Statement st = con.createStatement();
                String sql = "select * from clientes where\n" 
                        + "rut='" + rut+ "'";
                ResultSet result = st.executeQuery(sql);
                if(result.next()) {
                    cliente = result.getString("rut") + "#" 
                            + result.getString("nombres") + "#"
                            + result.getString("apellido_paterno") + "#"
                            + result.getString("apellido_materno") + "#"
                            + result.getString("sexo") + "#"
                            + result.getString("fecha_nacimiento") + "#"
                            + result.getString("nacionalidad");         
                    return cliente;
                } else {
                    System.out.println("No hay cliente con el rut: " + rut);
                }
                this.desconectar();
            } catch (SQLException ex) {
                System.out.println("No se pudo conectar");
            }
        }
         return cliente;
     }
     public boolean habitacionDisponible(String habitacion) {
         boolean disponible = false;
         if (conectar()) {
            try {
               Statement st = con.createStatement();
               String sql = "Select estado from habitaciones where habitacion = '"+ habitacion + "'";
               ResultSet result = st.executeQuery(sql);
               if(result.next()) {
                   disponible= (result.getInt("estado")==0);
               }
               desconectar();
               return disponible;
            } catch (SQLException ex) {
                System.out.println("Error al consultar : [" + ex.getMessage() + "]");
            }
            desconectar();
        }
        return false;
     }
     
     public String listaHabitacionesDisponibles() {
         String disponibles = "";
         if (conectar()) {
            try {
               Statement st = con.createStatement();
               String sql = "Select habitacion from habitaciones where estado = 0";
               ResultSet result = st.executeQuery(sql);
               while(result.next()) {
                   disponibles = disponibles + result.getString("habitacion") + "-";
               }
               desconectar();
               return disponibles;
            } catch (SQLException ex) {
                System.out.println("Error al consultar : [" + ex.getMessage() + "]");
            }
            desconectar();
        }
        return disponibles;
     }
     
     public String listaHabitacionesOcupadas() {
         String ocupadas = "";
         if (conectar()) {
            try {
               Statement st = con.createStatement();
               String sql = "Select habitacion from habitaciones where estado = 1";
               ResultSet result = st.executeQuery(sql);
               while(result.next()) {
                   ocupadas = ocupadas + result.getString("habitacion") + "-";
               }
               desconectar();
               return ocupadas;
            } catch (SQLException ex) {
                System.out.println("Error al consultar : [" + ex.getMessage() + "]");
            }
            desconectar();
        }
        return ocupadas;
     }
    
     public boolean ocuparHabitacion(String habitacion) {
         if (conectar()) {
            try {
                Statement st = con.createStatement();
                String sql = "update habitaciones set estado=1 where habitacion = '" + habitacion + "'";
                int rowsAffected = st.executeUpdate(sql);
                desconectar();
                return (rowsAffected == 1);
            } catch (SQLException ex) {
                System.out.println("Error al ocupar : [" + ex.getMessage() + "]");
            }
            desconectar();
        }
        return false;
     }
     
     public boolean desocuparHabitacion(String habitacion) {
         if (conectar()) {
            try {
                Statement st = con.createStatement();
                String sql = "update habitaciones set estado=0 where habitacion = '" + habitacion + "'";
                int rowsAffected = st.executeUpdate(sql);
                desconectar();
                return (rowsAffected == 1);
            } catch (SQLException ex) {
                System.out.println("Error al desocupar : [" + ex.getMessage() + "]");
            }
            desconectar();
        }
        return false;
     }
     
     public int precioJornada(String habitacion) {
         int precio=0;
         if (conectar()) {
            try {
               Statement st = con.createStatement();
               String sql = "Select valor_jornada from habitaciones where habitacion = '" + habitacion + "'";
               ResultSet result = st.executeQuery(sql);
               if (result.next()) {
                   precio = result.getInt("valor_jornada");
               }
               desconectar();
               return precio;
            } catch (SQLException ex) {
                System.out.println("Error al consultar : [" + ex.getMessage() + "]");
            }
            desconectar();
        }
        return precio;
     }
     
     public int precioMomento(String habitacion) {
         int precio=0;
         if (conectar()) {
            try {
               Statement st = con.createStatement();
               String sql = "Select valor_momento from habitaciones where habitacion = '" + habitacion + "'";
               ResultSet result = st.executeQuery(sql);
               if (result.next()) {
                   precio = result.getInt("valor_momento");
               }
               desconectar();
               return precio;
            } catch (SQLException ex) {
                System.out.println("Error al consultar : [" + ex.getMessage() + "]");
            }
            desconectar();
        }
        return precio;
     }
     
     public String clienteAmor() {
        String clienteAmor = "";
        int maxVisitas = 0;
        
        if (conectar()) {
            try {
               Statement st = con.createStatement();
               String sql = "select rut, count(*) AS C from historico group by rut \n" 
                       + "order by C desc limit 1";
               ResultSet result = st.executeQuery(sql);
               if (result.next()) {
                   maxVisitas = result.getInt("C");
               }
               st = con.createStatement();
               sql = "Select rut, count(*) AS C from historico group by rut having C=" + maxVisitas;
               result = st.executeQuery(sql);
               while (result.next()) {
                   clienteAmor = clienteAmor + result.getString("rut") + "#";
               }
               desconectar();
               return clienteAmor;
            } catch (SQLException ex) {
                System.out.println("Error al consultar : [" + ex.getMessage() + "]");
            }
            desconectar();
        } 
        return clienteAmor;
     }
     
     public boolean generarIngreso(IngresoVO nuevo) {   
         if (conectar()) {
            try {
               Statement st = con.createStatement();
               String sql = "insert into Ingresos (Habitacion,Cantidad_Personas,"
                       + "Modalidad,Costo_Habitacion,Fecha_Hora_Ingreso) values (" + nuevo.toString() + ")"; 
               System.out.println("Insertando [" + sql + "]");
               int rowsAffected = st.executeUpdate(sql);
               desconectar();
               return (rowsAffected == 1);
            } catch (SQLException ex) {
                System.out.println("Error al ingresar orden : [" + ex.getMessage() + "]");
            }
            desconectar();
        }
        return false;
     }
     
     public boolean generarHistorico(int numero_orden, String rut) {
         if (conectar()) {
            try {
               Statement st = con.createStatement();
               String sql = "insert into Historico  values (" + numero_orden + ",'" + rut + "')"; 
               System.out.println("Insertando [" + sql + "]");
               int rowsAffected = st.executeUpdate(sql);
               desconectar();
               return (rowsAffected == 1);
            } catch (SQLException ex) {
                System.out.println("Error al ingresar orden : [" + ex.getMessage() + "]");
            }
            desconectar();
        }
        return false;
     }
     
     public int getNumeroOrden(String habitacion, String fecha_hora_ingreso) {
         int numero_orden = 0;
        
         if (conectar()) {
            try {
               Statement st = con.createStatement();
               String sql = "select numero_orden from ingresos where habitacion= '"  
                       + habitacion + "' and fecha_hora_ingreso= '" + fecha_hora_ingreso + "'";
               ResultSet result = st.executeQuery(sql);
               if (result.next()) {
                   numero_orden = result.getInt("numero_orden");
               }
               desconectar();
               return numero_orden;
            } catch (SQLException ex) {
                System.out.println("Error al consultar : [" + ex.getMessage() + "]");
            }
            desconectar();
        } 
        return numero_orden;
     }
     
     public int getUltimoNumeroOrden(String habitacion) {
         int numero_orden = 0;
        
         if (conectar()) {
            try {
               Statement st = con.createStatement();
               String sql = "select numero_orden, habitacion from ingresos where numero_orden in(select"
                       + " max(numero_orden) from ingresos where habitacion = '"  
                       + habitacion + "')";
               ResultSet result = st.executeQuery(sql);
               if (result.next()) {
                   numero_orden = result.getInt("numero_orden");
               }
               desconectar();
               return numero_orden;
            } catch (SQLException ex) {
                System.out.println("Error al consultar : [" + ex.getMessage() + "]");
            }
            desconectar();
        } 
        return numero_orden;
     }
     
     public boolean actualizarStock(int codigo_producto, int cantidad_pedida) {
         int stock = stockProducto(codigo_producto);
         int nuevoStock = stock - cantidad_pedida;
         if (conectar()) {
            try {
               Statement st = con.createStatement();
               String sql = " update productos set cantidad_inventario="
                       + nuevoStock + " where codigo_producto = " + codigo_producto;
               System.out.println("Insertando [" + sql + "]");
               int rowsAffected = st.executeUpdate(sql);
               desconectar();
               return (rowsAffected == 1);
            } catch (SQLException ex) {
                System.out.println("Error al insertar : [" + ex.getMessage() + "]");
            }
            desconectar();
        } 
        return false;
     }
     
     public String getProductos() {
	String producto = "";
	if(conectar()){
            try{
                 Statement st = con.createStatement ();
                 String sql = "select codigo_producto, nombre_producto from productos where Cantidad_Inventario>0";
                 ResultSet result = st.executeQuery(sql);
                 while (result.next()){
                        producto = producto +result.getInt("codigo_producto") + " "
                                + result.getString("nombre_producto") + "#";
                 }       
                desconectar();
                return producto;
                } catch (SQLException ex) {
                System.out.println("Error al consultar : [" + ex.getMessage() + "]");
                }
            desconectar();
        } 
        return producto;
     }
     
     public boolean ingresarPedido(ConsumoVO nuevo) {
         if (conectar()) {
            try {
               Statement st = con.createStatement();
               String sql = "insert into consumo values (" + nuevo.toString() + ")"; //lanza automaticamente el toString 
               System.out.println("Insertando [" + sql + "]");
               int rowsAffected = st.executeUpdate(sql);
               desconectar();
               return (rowsAffected == 1);
            } catch (SQLException ex) {
                System.out.println("Error al insertar : [" + ex.getMessage() + "]");
            }
            desconectar();
        }
        return false;
     }
     
     public int numeroVisitasTotal(String rut) {
         int visitas = 0;
         if (conectar()) {
            try {
               Statement st = con.createStatement();
               String sql = "select count(*) AS C from historico where rut = '" + rut + "'";
               ResultSet result = st.executeQuery(sql);
               if (result.next()) {
                   visitas = result.getInt("C");
               }
               desconectar();
               return visitas;
            } catch (SQLException ex) {
                System.out.println("Error al consultar : [" + ex.getMessage() + "]");
            }
            desconectar();
        } 
        return visitas;
     }
     
     public String registros(String rut) {
         String registros = "";
	if(conectar()){
            try{
                 Statement st = con.createStatement ();
                 String sql = "select * from ingresos where numero_orden in\n" 
                         + " (select numero_orden from historico where rut = '" 
                         + rut + "')";
                 ResultSet result = st.executeQuery(sql);
                 while (result.next()){
                        registros = registros +result.getInt("numero_orden") + "  -  "
                                + "Habitación: " + result.getString("habitacion") + "  -  "
                                + "Personas: " + result.getInt("cantidad_personas") + "  -  "; 
                        if (result.getInt("modalidad")==1) {
                            registros = registros + "Momento  -  ";
                        } else {
                            registros = registros + "Jornada  -  ";
                        }
                        registros = registros + "Monto: " + result.getInt("costo_habitacion") + "  -  "
                                + "Fecha: " + result.getString("fecha_hora_ingreso")+ "\n";
                 }       
                desconectar();
                return registros;
                } catch (SQLException ex) {
                System.out.println("Error al consultar : [" + ex.getMessage() + "]");
                }
            desconectar();
        } 
        return registros;
     }
     
     public String habitacionFavorita(String rut) {
         String habitacion = "";
         if (conectar()) {
            try {
               Statement st = con.createStatement();
               String sql = "select habitacion, count(habitacion) AS C from ingresos where numero_orden in " 
                       + "(select numero_orden from historico where rut = '"+ rut + "') group by Habitacion \n" 
                       + "order by C desc limit 1";
               ResultSet result = st.executeQuery(sql);
               if (result.next()) {
                   habitacion = result.getString("habitacion");
               }
               desconectar();
               return habitacion;
            } catch (SQLException ex) {
                System.out.println("Error al consultar : [" + ex.getMessage() + "]");
            }
            desconectar();
        } 
        return habitacion;
     }
     
     public String habitacionMasUtilizada() {
         String habitacion = "";
         if (conectar()) {
            try {
               Statement st = con.createStatement();
               String sql = "SELECT Habitacion, COUNT(Habitacion ) C " 
                       + "FROM ingresos GROUP BY Habitacion ORDER BY C DESC" 
                       + " LIMIT 1";
               ResultSet result = st.executeQuery(sql);
               if (result.next()) {
                   habitacion = result.getString("habitacion");
               }
               desconectar();
               return habitacion;
            } catch (SQLException ex) {
                System.out.println("Error al consultar : [" + ex.getMessage() + "]");
            }
            desconectar();
        } 
        return habitacion;
     }
     
     public String habitacionMenosUtilizada() {
         String habitacion = "";
         if (conectar()) {
            try {
               Statement st = con.createStatement();
               String sql = "SELECT Habitacion, COUNT(Habitacion ) C " 
                       + "FROM ingresos GROUP BY Habitacion ORDER BY C ASC" 
                       + " LIMIT 1";
               ResultSet result = st.executeQuery(sql);
               if (result.next()) {
                   habitacion = result.getString("habitacion");
               }
               desconectar();
               return habitacion;
            } catch (SQLException ex) {
                System.out.println("Error al consultar : [" + ex.getMessage() + "]");
            }
            desconectar();
        } 
        return habitacion;
     }
     
     public String habitacionConMasClientesPromedio() {
         String habitacion = "";
         if (conectar()) {
            try {
               Statement st = con.createStatement();
               String sql = "SELECT Habitacion, avg(cantidad_personas) AS C from " 
                       + "ingresos group by habitacion order by C desc limit 1";
               ResultSet result = st.executeQuery(sql);
               if (result.next()) {
                   habitacion = result.getString("habitacion");
               }
               desconectar();
               return habitacion;
            } catch (SQLException ex) {
                System.out.println("Error al consultar : [" + ex.getMessage() + "]");
            }
            desconectar();
        } 
        return habitacion;
     }
     
      public String habitacionesYClientesPromedio() {
         String habitaciones = "";
         if (conectar()) {
            try {
               Statement st = con.createStatement();
               String sql = "SELECT Habitacion, avg(cantidad_personas) AS C from " 
                       + "ingresos group by habitacion order by C desc";
               ResultSet result = st.executeQuery(sql);
               while (result.next()) {
                   habitaciones = habitaciones + "Habitación: " + result.getString("habitacion")
                           + "  Promedio de clientes: " +  result.getDouble("C") + "\n";
               }
               desconectar();
               return habitaciones;
            } catch (SQLException ex) {
                System.out.println("Error al consultar : [" + ex.getMessage() + "]");
            }
            desconectar();
        } 
        return habitaciones;
     }
     
     public String clientesHabitacion(String habitacion) {
         
         String clientes = "";
         if (conectar()) {
            try {
               Statement st = con.createStatement();
               String sql = "SELECT rut from historico where Numero_Orden in (select numero_orden "
                       + "FROM ingresos where habitacion = '" + habitacion + "')";
               ResultSet result = st.executeQuery(sql);
               while (result.next()) {
                   clientes = clientes + result.getString("rut") + "\n";
               }
               desconectar();
               return clientes;
            } catch (SQLException ex) {
                System.out.println("Error al consultar : [" + ex.getMessage() + "]");
            }
            desconectar();
        } 
        return clientes;
     }
     
     public String productosPorHabitacion(String habitacion) {
         String productos = "";
         if (conectar()) {
            try {
               Statement st = con.createStatement();
               String sql = "SELECT numero_orden, codigo_producto, cantidad_pedida from consumo where numero_orden in "
                       + "(select numero_orden from ingresos where Habitacion = '" + habitacion + "')";
               ResultSet result = st.executeQuery(sql);
               while (result.next()) {
                   productos = productos + result.getInt("numero_orden") + "#"
                           + result.getInt("codigo_producto") + "#"
                           + result.getInt("cantidad_pedida") + "\n";
               }
               desconectar();
               return productos;
            } catch (SQLException ex) {
                System.out.println("Error al consultar : [" + ex.getMessage() + "]");
            }
            desconectar();
        } 
        return productos;
     }
     
     public int codigoProductoMasVendido() {
         int producto = 0;
         if (conectar()) {
            try {
               Statement st = con.createStatement();
               String sql = "select codigo_producto,  sum(cantidad_pedida) as S \n" 
                       + "from consumo group by codigo_producto order by S \n" 
                       +" desc limit 1";
               ResultSet result = st.executeQuery(sql);
               if (result.next()) {
                   producto = result.getInt("codigo_producto");
               }
               desconectar();
               return producto;
            } catch (SQLException ex) {
                System.out.println("Error al consultar : [" + ex.getMessage() + "]");
            }
            desconectar();
        } 
        return producto;
     }
     
     public String habitacionDondeMasSeVende(int codigo_producto) {
         String habitacion = "Habitación: ";
         if (conectar()) {
            try {
               Statement st = con.createStatement();
               String sql = "select I.habitacion, C.codigo_producto, \n" 
                          + " sum(cantidad_pedida) as S from ingresos I,\n"
                          + " consumo C where codigo_producto = " + codigo_producto 
                          + " and I.numero_orden = C.numero_orden group by habitacion "
                          + "order by S desc limit 1";
               ResultSet result = st.executeQuery(sql);
               if (result.next()) {
                   habitacion = habitacion + result.getString("habitacion")
                           + "  Cantidad vendida: " + result.getInt("S");
               }
               desconectar();
               return habitacion;
            } catch (SQLException ex) {
                System.out.println("Error al consultar : [" + ex.getMessage() + "]");
            }
            desconectar();
        } 
        return habitacion;
     }
     
     public String habitacionDondeMenosSeVende(int codigo_producto) {
         String habitacion = "Habitación: ";
         if (conectar()) {
            try {
               Statement st = con.createStatement();
               String sql = "select I.habitacion, C.codigo_producto, \n" 
                          + " sum(cantidad_pedida) as S from ingresos I,\n"
                          + " consumo C where codigo_producto = " + codigo_producto 
                          + " and I.numero_orden = C.numero_orden group by habitacion "
                          + "order by S asc limit 1";
               ResultSet result = st.executeQuery(sql);
               if (result.next()) {
                   habitacion = habitacion + result.getString("habitacion")
                           + "  Cantidad vendida: " + result.getInt("S");
               }
               desconectar();
               return habitacion;
            } catch (SQLException ex) {
                System.out.println("Error al consultar : [" + ex.getMessage() + "]");
            }
            desconectar();
        } 
        return habitacion;
     }
     
     public int codigoProductoMenosVendido() {
         int producto = 0;
         if (conectar()) {
            try {
               Statement st = con.createStatement();
               String sql = "select codigo_producto,  sum(cantidad_pedida) as S \n" 
                       + "from consumo group by codigo_producto order by S \n" 
                       +" asc limit 1";
               ResultSet result = st.executeQuery(sql);
               if (result.next()) {
                   producto = result.getInt("codigo_producto");
               }
               desconectar();
               return producto;
            } catch (SQLException ex) {
                System.out.println("Error al consultar : [" + ex.getMessage() + "]");
            }
            desconectar();
        } 
        return producto;
     }
     
     public int valorProducto(int codigo_producto) {
         int valor = 0;
         if (conectar()) {
            try {
               Statement st = con.createStatement();
               String sql = "SELECT valor_unitario from productos where codigo_producto="
                       + codigo_producto;
               ResultSet result = st.executeQuery(sql);
               if (result.next()) {
                   valor =  result.getInt("valor_unitario");
               }
               desconectar();
               return valor;
            } catch (SQLException ex) {
                System.out.println("Error al consultar : [" + ex.getMessage() + "]");
            }
            desconectar();
        } 
        return valor;
     }
     
     public String nombreProducto(int codigo_producto) {
         String nombre = "";
         if (conectar()) {
            try {
               Statement st = con.createStatement();
               String sql = "SELECT nombre_producto from productos where codigo_producto="
                       + codigo_producto;
               ResultSet result = st.executeQuery(sql);
               if (result.next()) {
                   nombre =  result.getString("nombre_producto");
               }
               desconectar();
               return nombre;
            } catch (SQLException ex) {
                System.out.println("Error al consultar : [" + ex.getMessage() + "]");
            }
            desconectar();
        } 
        return nombre;
     }
     
     public int stockProducto(int codigo_producto) {
         int stock = 0;
         if (conectar()) {
            try {
               Statement st = con.createStatement();
               String sql = "SELECT cantidad_inventario from productos where codigo_producto="
                       + codigo_producto;
               ResultSet result = st.executeQuery(sql);
               if (result.next()) {
                   stock =  result.getInt("cantidad_inventario");
               }
               desconectar();
               return stock;
            } catch (SQLException ex) {
                System.out.println("Error al consultar : [" + ex.getMessage() + "]");
            }
            desconectar();
        } 
        return stock;
     }
     
     public int dineroTotalPorUsoHabitacion(String habitacion) {
         
         int dinero = 0;
         if (conectar()) {
            try {
               Statement st = con.createStatement();
               String sql = "SELECT sum(costo_habitacion) AS C from Ingresos where habitacion = '" + habitacion + "'";
               ResultSet result = st.executeQuery(sql);
               if (result.next()) {
                   dinero =  result.getInt("C");
               }
               desconectar();
               return dinero;
            } catch (SQLException ex) {
                System.out.println("Error al consultar : [" + ex.getMessage() + "]");
            }
            desconectar();
        } 
        return dinero;
     }
     
     public String dineroPorUsoHabitacionPorOrden(String habitacion) {
         String dineroPorUso = "";
         if (conectar()) {
            try {
               Statement st = con.createStatement();
               String sql = "SELECT numero_orden, costo_habitacion from Ingresos where habitacion = '" + habitacion + "'";
               ResultSet result = st.executeQuery(sql);
               while (result.next()) {
                   dineroPorUso = dineroPorUso + "Orden: " + result.getInt("numero_orden")
                           + ", dinero recaudado por estadía: " + result.getString("costo_habitacion") + "\n";
               }
               desconectar();
               return dineroPorUso;
            } catch (SQLException ex) {
                System.out.println("Error al consultar : [" + ex.getMessage() + "]");
            }
            desconectar();
        } 
        return dineroPorUso;
     }
     
     public ArrayList<productosVO> buscarproductosConMatriz() {
        ArrayList<productosVO> miLista = new ArrayList<productosVO>();
        productosVO productos;
    
        if(conectar()){
            try{
                 Statement st = con.createStatement ();
                 String sql = "select * from productos";
                 ResultSet result = st.executeQuery(sql);
 
                while (result.next()) {
                    productos = new productosVO();
                    productos.setCodigo_Producto(Integer.parseInt(result.getString("Codigo_Producto")));
                    productos.setNombre_Producto(result.getString("Nombre_Producto"));
                    productos.setValor_Unitario(Integer.parseInt(result.getString("Valor_Unitario")));
                    productos.setCantidad_Inventario(Integer.parseInt(result.getString("Cantidad_Inventario")));
                    miLista.add(productos);
                }
                result.close();
                desconectar();
 
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "Error al consultar", "Error",
                JOptionPane.ERROR_MESSAGE);
 
            }
  
        }
       return miLista;
    }
}

