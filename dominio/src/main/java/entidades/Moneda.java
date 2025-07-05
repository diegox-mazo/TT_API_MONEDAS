package monedas.api.dominio.entidades;

import org.hibernate.annotations.GenericGenerator;
import jakarta.persistence.*;

@Entity
@Table(name="moneda")
public class Moneda {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "secuencia_moneda")
    @GenericGenerator(name = "secuencia_moneda", strategy = "increment")
    private long id;

    @Column(name = "moneda", length = 100, unique = true)
    private String nombre;

    @Column(name = "sigla", length = 5, unique = true)
    private String sigla;

    @Column(name = "simbolo", length = 5)
    private String simbolo;

    @Column(name = "emisor", length = 100)
    private String emisor;

    public Moneda() {
    }

    public Moneda(long id, String nombre, String sigla, String simbolo, String emisor) {
        this.id = id;
        this.nombre = nombre;
        this.sigla = sigla;
        this.simbolo = simbolo;
        this.emisor = emisor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getEmisor() {
        return emisor;
    }

    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }

}

