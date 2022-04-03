import Entities.EstadoPrenda.Nueva;
import Entities.EstadoPrenda.Liquidacion;
import Entities.Prenda;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import Entities.Exceptions.PorcentajeInvalidoException;
import org.junit.function.ThrowingRunnable;

public class TestsPrenda {
    private Prenda prenda;
    @Before
    public void init(){
        double precio = 1000.5;
        this.prenda = new Prenda(precio, new Nueva());
    }
    @Test
    public void prendaNuevaNoModificaPrecio(){
        Assert.assertTrue(prenda.obtenerPrecioVenta()==prenda.getPrecioBase());
    }
    @Test
    public void prendaLiquidacionModificaPrecio(){
        double porcentajeDescuento = 0.5;
        double precioFinal = prenda.getPrecioBase()*(1-porcentajeDescuento);
        Liquidacion liquidacion =new Liquidacion();
        liquidacion.setPorcetajeDescuento(porcentajeDescuento);
        prenda.setEstado(liquidacion);

        Assert.assertTrue(prenda.obtenerPrecioVenta()==precioFinal);
    }

}
