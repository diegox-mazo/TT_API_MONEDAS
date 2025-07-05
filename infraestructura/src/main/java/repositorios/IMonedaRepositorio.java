package monedas.api.infraestructura.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import monedas.api.dominio.entidades.*;

@Repository
public interface IMonedaRepositorio extends JpaRepository<Moneda, Long> {

    @Query("SELECT m FROM Moneda m WHERE m.nombre LIKE '%' || ?1 || '%'")
    List<Moneda> buscar(String nombre);

    @Query("SELECT m FROM Pais p JOIN p.moneda m WHERE p.nombre=?1")
    Moneda buscarPorPais(String nombre);
}
