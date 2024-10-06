
package Models;


public class Equipo {
    
    protected String modelo;
    protected String cpu;
    protected String disco_duro;
    protected String ram;
    protected int precio;

    public Equipo(String modelo, String cpu, String disco_duro, String ram, int precio) {
        this.modelo = modelo;
        this.cpu = cpu;
        this.disco_duro = disco_duro;
        this.ram = ram;
        this.precio = precio;
    }

    public Equipo() {
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getDisco_duro() {
        return disco_duro;
    }

    public void setDisco_duro(String disco_duro) {
        this.disco_duro = disco_duro;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    @Override
    public String toString() {
        return modelo; // Cambia esto si quieres mostrar más información
    }
    
}
