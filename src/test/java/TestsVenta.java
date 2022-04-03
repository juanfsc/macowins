
import Entities.EstadoPrenda.Liquidacion;
import Entities.EstadoPrenda.Nueva;
import Entities.MedioPago.Efectivo;
import Entities.MedioPago.Tarjeta;
import Entities.Prenda;
import Entities.PrendaVendida;
import Entities.Venta;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

public class TestsVenta {
    private Venta venta;
    private ArrayList<PrendaVendida> prendasVendidas = new ArrayList<>();
    @Before
    public void init(){

        Prenda prendaNueva =new Prenda(100,new Nueva());
        PrendaVendida vendidaNueva = new PrendaVendida(prendaNueva,1);
        prendasVendidas.add(vendidaNueva);
        Prenda prendaLiquidacion =new Prenda(100, new Liquidacion());
        PrendaVendida vendidaLiquidacion = new PrendaVendida(prendaLiquidacion,1);
        prendasVendidas.add(vendidaLiquidacion);
    }
    @Test
    public void ventaConEfectivoNoModificaPrecio(){
        this.venta = new Venta(new Date(),new Efectivo());
        this.prendasVendidas.stream().forEach(pv -> this.venta.agregarPrenda(pv));

        Assert.assertTrue(this.venta.precioVenta()==this.venta.precioTotal());
    }
    @Test
    public void ventaConTarjetaNoModificaPrecio(){
        this.venta = new Venta(new Date(),new Tarjeta(0,6));
        this.prendasVendidas.stream().forEach(pv -> this.venta.agregarPrenda(pv));

        Assert.assertTrue(this.venta.precioVenta()>this.venta.precioTotal());
    }


}