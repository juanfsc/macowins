package Entities.EstadoPrenda;

public class Promocion implements EstadoPrenda{
    double descuento;
    public Promocion(double descuento){
        this.descuento = descuento;
    }
    public double modificarPrecio(double precio) {
        return Math.max(precio-this.descuento,0);
    }
}
