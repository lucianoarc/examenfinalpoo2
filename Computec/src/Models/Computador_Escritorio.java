
package Models;

import com.mysql.cj.util.DnsSrv;


public class Computador_Escritorio extends Equipo{
    
    private String placa_madre;
    private String fuente_poder;

    public Computador_Escritorio(String placa_madre, String fuente_poder, String modelo, String cpu, String disco_duro, String ram, int precio) {
        super(modelo, cpu, disco_duro, ram, precio);
        this.placa_madre = placa_madre;
        this.fuente_poder = fuente_poder;
    }

    public Computador_Escritorio() {
    }

    
    
    public String getPlaca_madre() {
        return placa_madre;
    }

    public void setPlaca_madre(String placa_madre) {
        this.placa_madre = placa_madre;
    }

    public String getFuente_poder() {
        return fuente_poder;
    }

    public void setFuente_poder(String fuente_poder) {
        this.fuente_poder = fuente_poder;
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
        return modelo; // Solo devuelve el modelo para el JList
    }
}
