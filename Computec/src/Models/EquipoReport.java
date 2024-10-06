
package Models;

import java.util.Date;



public class EquipoReport {
    
    private String nombreCliente;
    private String telefono;
    private String correo;
    private String modeloEquipo;
    private double precio;
    private Date fechaVenta; 

    public EquipoReport(String nombreCliente, String telefono, String correo, String modeloEquipo, double precio, Date fechaVenta) {
        this.nombreCliente = nombreCliente;
        this.telefono = telefono;
        this.correo = correo;
        this.modeloEquipo = modeloEquipo;
        this.precio = precio;
        this.fechaVenta = fechaVenta;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public String getModeloEquipo() {
        return modeloEquipo;
    }

    public double getPrecio() {
        return precio;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }
    
}
