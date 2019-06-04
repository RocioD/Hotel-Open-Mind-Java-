/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectohotel.modelo.ingreso;

public class Ingreso {
    private int numero_orden;
    private String habitacion;
    private int cantidad_personas;
    private int modalidad; //1 para momento, 2 para jornada
    private int costo_habitacion;
    private String fecha_hora_ingreso;

    public Ingreso(int numero_orden, String habitacion, int cantidad_personas, int modalidad, int costo_habitacion, String fecha_hora_ingreso) {
        this.numero_orden = numero_orden;
        this.habitacion = habitacion;
        this.cantidad_personas = cantidad_personas;
        this.modalidad = modalidad;
        this.costo_habitacion = costo_habitacion;
        this.fecha_hora_ingreso = fecha_hora_ingreso;
    }

    public Ingreso(String habitacion, int cantidad_personas, int modalidad, int costo_habitacion, String fecha_hora_ingreso) {
        this.habitacion = habitacion;
        this.cantidad_personas = cantidad_personas;
        this.modalidad = modalidad;
        this.costo_habitacion = costo_habitacion;
        this.fecha_hora_ingreso = fecha_hora_ingreso;
    }

    public Ingreso(String habitacion, int cantidad_personas, int modalidad, String fecha_hora_ingreso) {
        this.habitacion = habitacion;
        this.cantidad_personas = cantidad_personas;
        this.modalidad = modalidad;
        this.fecha_hora_ingreso = fecha_hora_ingreso;
    }
    
    

    public int getNumero_orden() {
        return numero_orden;
    }

    public String getHabitacion() {
        return habitacion;
    }

    public int getCantidad_personas() {
        return cantidad_personas;
    }

    public int getModalidad() {
        return modalidad;
    }

    public int getCosto_habitacion() {
        return costo_habitacion;
    }

    public String getFecha_hora_ingreso() {
        return fecha_hora_ingreso;
    }

    public void setNumero_orden(int numero_orden) {
        this.numero_orden = numero_orden;
    }

    public void setHabitacion(String habitacion) {
        this.habitacion = habitacion;
    }

    public void setCantidad_personas(int cantidad_personas) {
        this.cantidad_personas = cantidad_personas;
    }

    public void setModalidad(int modalidad) {
        this.modalidad = modalidad;
    }

    public void setCosto_habitacion(int costo_habitacion) {
        this.costo_habitacion = costo_habitacion;
    }

    public void setFecha_hora_ingreso(String fecha_hora_ingreso) {
        this.fecha_hora_ingreso = fecha_hora_ingreso;
    }
    
}
