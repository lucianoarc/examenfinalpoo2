
package Models;


public class Clientes {
    
    protected String rut;
    protected String nombre;
    protected String direccion;
    protected String comuna;
    protected String correo;
    protected  int telefono;

    public Clientes(String rut, String nombre, String direccion, String comuna, String correo, int telefono) {
        this.rut = rut;
        this.nombre = nombre;
        this.direccion = direccion;
        this.comuna = comuna;
        this.correo = correo;
        this.telefono = telefono;
    }

    public Clientes() {
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
   @Override
    public String toString(){
        return "rut:" + rut + "nombre" + nombre + "direccion:" + direccion + "comuna:" + comuna + "correo:" + correo + "telefono:" + telefono;
    }
    
}
