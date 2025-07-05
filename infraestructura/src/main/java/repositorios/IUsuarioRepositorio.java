package monedas.api.infraestructura.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import monedas.api.dominio.entidades.*;

@Repository
public interface IUsuarioRepositorio extends JpaRepository<Usuario, Long>{

    @Query("SELECT u FROM Usuario u  WHERE u.nombre LIKE '%' || ?1 || '%'")
    List<Usuario> buscar(String nombre);

    @Query("SELECT u FROM Usuario u  WHERE u.usuario = ?1")
    Usuario obtener(String usuario);

    @Query("SELECT u FROM Usuario u WHERE u.usuario=?1 AND u.clave=?2")
    Usuario validarUsuario(String usuario, String clave);

}
