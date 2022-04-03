package Entities.MedioPago;

public class Tarjeta implements MedioPago{
    private double coeficienteFijo = 0.5;
    private Integer cantidadCuotas;
    private double porcentajeValor = 0.01;

    public Tarjeta(double coeficienteFijo, Integer cantidadCuotas){
        this.coeficienteFijo = coeficienteFijo;
        this.cantidadCuotas = cantidadCuotas;
    }
    public double obtenerRecargo(double precio){
        return precio*(100-this.porcentajeValor) + this.cantidadCuotas*this.coeficienteFijo;
    }
}
