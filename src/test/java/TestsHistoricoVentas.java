
import Entities.EstadoPrenda.Liquidacion;
import Entities.EstadoPrenda.Nueva;
import Entities.HistoricoVentas;
import Entities.MedioPago.Efectivo;
import Entities.Prenda;
import Entities.PrendaVendida;
import Entities.Venta;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

public class TestsHistoricoVentas {
    private HistoricoVentas historico = new HistoricoVentas();
    private Venta venta = new Venta(new Date(),new Efectivo());
    private ArrayList<Venta> ventas = new ArrayList<>();
    @Before
    public void init(){
        ArrayList<PrendaVendida> prendasVendidas = new ArrayList<>();
        Prenda prendaNueva =new Prenda(100,new Nueva());
        PrendaVendida vendidaNueva = new PrendaVendida(prendaNueva,1);

        Prenda prendaLiquidacion =new Prenda(100, new Liquidacion());
        PrendaVendida vendidaLiquidacion = new PrendaVendida(prendaLiquidacion,1);

        venta.setFechaVenta(new Date(2022,3,3));
        venta.agregarPrenda(vendidaNueva);
        venta.agregarPrenda(vendidaLiquidacion);
        historico.agregarVenta(venta);
        ventas.add(venta);
    }
    @Test
    public void HistoricoVentasObtenerGanancias(){
        Assert.assertTrue(historico.obtenerGanancias(new Date(2022,3,1),new Date(2022,3,5))==venta.precioVenta());
    }
    @Test
    public void HistoricoVentasObtenerVentas(){
        Assert.assertTrue(historico.obtenerVentas(new Date(2022,3,1),new Date(2022,3,5)).equals(ventas));
    }
}

