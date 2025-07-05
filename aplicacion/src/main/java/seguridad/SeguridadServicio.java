package monedas.api.aplicacion.seguridad;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.Claims;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class SeguridadServicio {
    public static final String SECRETO = "5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437";
    
    public String generarToken(String nombreUsuario) {
        Map<String, Object> declaraciones = new HashMap<>();
        return crearToken(declaraciones, nombreUsuario);
    }
  
    private String crearToken(Map<String, Object> declaraciones, String nombreUsuario) {
        return Jwts.builder()
                .setClaims(declaraciones)
                .setSubject(nombreUsuario)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30))
                .signWith(getClaveFirma(), SignatureAlgorithm.HS256).compact();
    }
  
    private Key getClaveFirma() {
        byte[] keyBytes= Decoders.BASE64.decode(SECRETO);
        return Keys.hmacShaKeyFor(keyBytes);
    }
  
    public String extraerNombreUsuario(String token) {
        return extrearDeclaracion(token, Claims::getSubject);
    }
  
    public Date extrearExpiracion(String token) {
        return extrearDeclaracion(token, Claims::getExpiration);
    }
  
    public <T> T extrearDeclaracion(String token, Function<Claims, T> declaracionesResolver) {
        final Claims declaraciones = extrearDeclaraciones(token);
        return declaracionesResolver.apply(declaraciones);
    }
  
    private Claims extrearDeclaraciones(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getClaveFirma())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
  
    private Boolean tokenExpirado(String token) {
        return extrearExpiracion(token).before(new Date());
    }
  
    public Boolean validarToken(String token, UserDetails userDetails) {
        final String nombreUsuario = extraerNombreUsuario(token);
        return (nombreUsuario.equals(userDetails.getUsername()) && !tokenExpirado(token));
    }

}
