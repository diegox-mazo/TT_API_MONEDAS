package monedas.api.aplicacion.seguridad;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import monedas.api.dominio.entidades.*;

public class UsuarioDetalles implements UserDetails {

    private String nombreUsuario;
    private String clave;
    private List<GrantedAuthority> permisos;

    public UsuarioDetalles(Usuario usuario) {
        nombreUsuario = usuario.getUsuario();
        clave = usuario.getClave();
        permisos = usuario.getRoles() != null ? Arrays.stream(usuario.getRoles().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList())
                : null;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return permisos;
    }

    @Override
    public String getPassword() {
        return clave;
    }

    @Override
    public String getUsername() {
        return nombreUsuario;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
