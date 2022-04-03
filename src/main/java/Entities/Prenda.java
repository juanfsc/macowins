package Entities;

import Entities.EstadoPrenda.EstadoPrenda;

public class Prenda {
    TipoPrenda tipo;
    EstadoPrenda estado;
    double precioBase;
    public Prenda(double precioBase, EstadoPrenda estado){
        this.precioBase = precioBase;
        this.estado = estado;
    }
    public double obtenerPrecioVenta(){
        return estado.modificarPrecio(this.precioBase);
    }

    public void setEstado(EstadoPrenda estado) {
        this.estado = estado;
    }
    public double getPrecioBase(){
        return this.precioBase;
    }
}
