
package Models;


public class Notebook extends Equipo{
    
    private String pantalla;
    private String usb;
    private boolean touch;

    public Notebook(String pantalla, String usb, boolean touch, String modelo, String cpu, String disco_duro, String ram, int precio) {
        super(modelo, cpu, disco_duro, ram, precio);
        this.pantalla = pantalla;
        this.usb = usb;
        this.touch = touch;
    }

    public Notebook() {
    }

    public String getPantalla() {
        return pantalla;
    }

    public void setPantalla(String pantalla) {
        this.pantalla = pantalla;
    }

    public String getUsb() {
        return usb;
    }

    public void setUsb(String usb) {
        this.usb = usb;
    }

    public boolean isTouch() {
        return touch;
    }

    public void setTouch(boolean touch) {
        this.touch = touch;
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
