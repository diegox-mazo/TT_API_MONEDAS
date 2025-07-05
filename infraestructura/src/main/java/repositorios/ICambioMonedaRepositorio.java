package monedas.api.infraestructura.repositorios;

import java.util.List;
import java.util.Date;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import monedas.api.dominio.entidades.*;

@Repository
public interface ICambioMonedaRepositorio extends JpaRepository<CambioMoneda, Long> {

    @Query("SELECT cm FROM CambioMoneda cm  WHERE cm.moneda.id=?1 AND cm.fecha >= ?2 AND cm.fecha <= ?3")
    public List<CambioMoneda> listarPorPeriodo(long idMoneda, Date fecha1, Date fecha2);

}
