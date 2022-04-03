import Entities.EstadoPrenda.Liquidacion;
import Entities.EstadoPrenda.Nueva;
import Entities.EstadoPrenda.Promocion;
import Entities.Exceptions.PorcentajeInvalidoException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestEstadoPrenda {

    @Before
    public void init(){;
    }
    @Test(expected = PorcentajeInvalidoException.class)
    public void liquidacionThrowsException(){
        double porcentajeDescuento = 1.5;
        Liquidacion prenda =new Liquidacion();
        prenda.setPorcetajeDescuento(porcentajeDescuento);
    }
    @Test()
    public void promocionAplicaDescuento(){
        double precio = 1000;
        double descuento = 100;
        Promocion promocion =new Promocion(descuento);

        Assert.assertTrue(promocion.modificarPrecio(precio)==precio - descuento);
    }
    @Test()
    public void nuevaNoAplicaDescuento(){
        double precio = 1000;
        double descuento = 100;
        Nueva nueva =new Nueva();

        Assert.assertTrue(nueva.modificarPrecio(precio)==precio);
    }
}
