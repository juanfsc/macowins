package Entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;

public class HistoricoVentas {
    ArrayList<Venta> ventas=new ArrayList<>();

    public void agregarVenta(Venta venta){
        ventas.add(venta);
    }
    public ArrayList<Venta> obtenerVentas(Date fechaInicio, Date fechaFin) {
        return (ArrayList<Venta>) this.ventas.stream()
                .filter(venta -> venta.getFechaVenta().after(fechaInicio) && venta.getFechaVenta().before(fechaFin))
                .collect(Collectors.toList());
    }
    public double obtenerGanancias(Date fechaInicio, Date fechaFin){
        return this.obtenerVentas(fechaInicio, fechaFin)
                .stream().mapToDouble(Venta::precioVenta).sum();
    }
}
