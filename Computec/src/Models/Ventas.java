
package Models;


import java.util.Date;

public class Ventas {
   
    private Clientes cliente;
    private Equipo equipo;
    private Date fechaHora;

    public Ventas(Clientes cliente, Equipo equipo, Date fechaHora) {
        this.cliente = cliente;
        this.equipo = equipo;
        this.fechaHora = fechaHora;
    }

    public Ventas() {
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }
    
    @Override
    public String toString(){
    return "Cliente: " + cliente.getNombre() + 
           "\nEquipo: " + equipo.getModelo() + 
           "\nFecha: " + fechaHora;
    }
}
