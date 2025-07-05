package monedas.api.dominio.DTOs;

public class CapitalDto {
    private String ciudad;
    private String estado;

    public CapitalDto(String ciudad, String estado) {
        this.ciudad = ciudad;
        this.estado = estado;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
