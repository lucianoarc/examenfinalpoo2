
package Decorators;


public class Descuento20PorCiento implements Descuento {
    private Descuento descuentoBase;

    public Descuento20PorCiento(Descuento descuentoBase) {
        this.descuentoBase = descuentoBase;
    }

    @Override
    public double aplicarDescuento(double precio) {
        double precioConDescuento = descuentoBase.aplicarDescuento(precio);
        return precioConDescuento * 0.80;  // Aplica un 20% de descuento
    }
}