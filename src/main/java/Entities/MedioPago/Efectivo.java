package Entities.MedioPago;

public class Efectivo implements MedioPago{
    public double obtenerRecargo(double precio){
        return precio;
    }
}
