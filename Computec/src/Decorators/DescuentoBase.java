
package Decorators;


public class DescuentoBase implements Descuento {
    @Override
    public double aplicarDescuento(double precio) {
        return precio;  // No aplica descuento, devuelve el precio original
    }
}
