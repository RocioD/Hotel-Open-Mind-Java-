package proyectohotel.modelo.clienteVO;

public class ClienteVO {

    private String rut;
    private String nombres;
    private String apellido_paterno;
    private String apellido_materno;
    private char sexo;
    private String fecha_nacimiento;
    private String nacionalidad;

    public ClienteVO(String rut, String nombres, String apellido_paterno, String apellido_materno, char sexo, String fecha_nacimiento, String nacionalidad) {
        this.rut = rut;
        this.nombres = nombres;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.sexo = sexo;
        this.fecha_nacimiento = fecha_nacimiento;
        this.nacionalidad = nacionalidad;
    }

    public ClienteVO() {
    }

    public String getRut() {
        return rut;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public char getSexo() {
        return sexo;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    @Override
    public String toString() {
        return "'" + rut + "', '" + nombres + "', '" + apellido_paterno + "', '" + apellido_materno + "', '" + sexo + "', '" + fecha_nacimiento + "', '" + nacionalidad + "'";
    }

    public String toStringModificaciones() {
        return "ClienteVO{" + "rut=" + rut + ", nombres=" + nombres + ", apellido_paterno=" + apellido_paterno + ", apellido_materno=" + apellido_materno + ", sexo=" + sexo + ", fecha_nacimiento=" + fecha_nacimiento + ", nacionalidad=" + nacionalidad + '}';
    }

    public String toStringInforme() {
        return "Rut: " + rut + "\nNombres: " + nombres + "\nApellido paterno: " + apellido_paterno + "\nApellido materno: "
                + apellido_materno + "\nSexo: " + sexo + "\nFecha de nacimiento: " + fecha_nacimiento + "\nNacionalidad: " + nacionalidad + "\n";
    }
}
