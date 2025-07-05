package monedas.api.core.servicios;

import java.util.List;
import java.util.Date;

import monedas.api.dominio.entidades.*;

public interface IMonedaServicio {

    public List<Moneda> listar();

    public Moneda obtener(Long id);

    public List<Moneda> buscar(String nombre);

    public Moneda buscarPorPais(String nombre);

    public Moneda agregar(Moneda moneda);

    public Moneda modificar(Moneda moneda);

    public boolean eliminar(Long id);
	
	public List<CambioMoneda> listarPorPeriodo(long idMoneda, Date fecha1, Date fecha2);

}
