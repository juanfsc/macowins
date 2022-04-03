package Entities;

import Entities.MedioPago.MedioPago;

import java.util.ArrayList;
import java.util.Date;

public class Venta {
    Date fechaVenta;
    MedioPago medioPago;
    ArrayList<PrendaVendida> prendasVendidas = new ArrayList<>();

    public Venta(Date fechaVenta, MedioPago medioPago) {
        this.fechaVenta = fechaVenta;
        this.medioPago = medioPago;
    }
    public void agregarPrenda(PrendaVendida prenda){
        prendasVendidas.add(prenda);
    }
    public double precioTotal(){
        double precioTotal= prendasVendidas.stream().mapToDouble(PrendaVendida::precioTotal).sum();
        return precioTotal;
    }
    public double precioVenta(){
        double precioTotal = this.precioTotal();
        return  precioTotal + medioPago.obtenerRecargo(precioTotal);
    }

    public Date getFechaVenta() {
        return this.fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }
}
