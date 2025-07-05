package monedas.api.aplicacion.presentacion;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import monedas.api.dominio.entidades.*;
import monedas.api.dominio.DTOs.*;
import monedas.api.core.servicios.*;

@RestController
@RequestMapping("/api/monedas")
public class MonedaControlador {
    private IMonedaServicio servicio;

    public MonedaControlador(IMonedaServicio servicio) {
        this.servicio = servicio;
    }

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<Moneda> listar() {
        return servicio.listar();
    }

    @RequestMapping(value = "/obtener/{id}", method = RequestMethod.GET)
    public Moneda obtener(@PathVariable long id) {
        return servicio.obtener(id);
    }

    @RequestMapping(value = "/buscar/{nombre}", method = RequestMethod.GET)
    public List<Moneda> buscar(@PathVariable String nombre) {
        return servicio.buscar(nombre);
    }

    @RequestMapping(value = "/buscarporpais/{nombre}", method = RequestMethod.GET)
    public Moneda buscarPorPais(@PathVariable String nombre) {
        return servicio.buscarPorPais(nombre);
    }

    @RequestMapping(value = "/agregar", method = RequestMethod.POST)
    public Moneda crear(@RequestBody Moneda moneda) {
        return servicio.agregar(moneda);
    }

    @RequestMapping(value = "/modificar", method = RequestMethod.PUT)
    public Moneda actualizar(@RequestBody Moneda moneda) {
        return servicio.modificar(moneda);
    }

    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
    public boolean eliminar(@PathVariable long id) {
        return servicio.eliminar(id);
    }

    @RequestMapping(value = "/listarporperiodo", method = RequestMethod.GET)
    public List<CambioMoneda> listarPorPeriodo(@RequestBody PeriodoDto periodo) {
        System.out.println(
                "periodo=" + periodo.getDesde() + " " + periodo.getHasta() + " idmoneda=" + periodo.getIdMoneda());

        return servicio.listarPorPeriodo(periodo.getIdMoneda(), periodo.getDesde(), periodo.getHasta());
    }

}
