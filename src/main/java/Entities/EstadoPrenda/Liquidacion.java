package Entities.EstadoPrenda;

import Entities.Exceptions.PorcentajeInvalidoException;

public class Liquidacion implements EstadoPrenda {
    double porcetajeDescuento=0.5;

    public Liquidacion(){
        this.porcetajeDescuento = 0.5;
    }

    public double modificarPrecio(double precio) {
        return precio*(1-porcetajeDescuento);
    }

    public void setPorcetajeDescuento(double porcetajeDescuento) throws PorcentajeInvalidoException{
        if(porcetajeDescuento>1 || porcetajeDescuento<0){
            throw new PorcentajeInvalidoException();
        }
        this.porcetajeDescuento = porcetajeDescuento;
    }
}

