
package Decorators;


public class Descuento10PorCiento implements Descuento {
    private Descuento descuentoBase;

    public Descuento10PorCiento(Descuento descuentoBase) {
        this.descuentoBase = descuentoBase;
    }

    @Override
    public double aplicarDescuento(double precio) {
        double precioConDescuento = descuentoBase.aplicarDescuento(precio);
        return precioConDescuento * 0.90;  // Aplica un 10% de descuento
    }
}
