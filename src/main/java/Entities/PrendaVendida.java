package Entities;

public class PrendaVendida {
    Prenda prenda;
    Integer cantidad;
    public PrendaVendida(Prenda prenda, Integer cantidad){
        this.prenda = prenda;
        this.cantidad=cantidad;
    }
    public double precioTotal(){
        return cantidad* prenda.obtenerPrecioVenta();
    }
}
