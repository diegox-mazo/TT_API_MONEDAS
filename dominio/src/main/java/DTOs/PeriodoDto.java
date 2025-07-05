package monedas.api.dominio.DTOs;

import java.util.Date;

public class PeriodoDto {
    private int idMoneda;

    private Date Desde;

    private Date Hasta;

    public PeriodoDto(int idMoneda, Date desde, Date hasta) {
        this.idMoneda = idMoneda;
        Desde = desde;
        Hasta = hasta;
    }

    public int getIdMoneda() {
        return idMoneda;
    }

    public void setIdMoneda(int idMoneda) {
        this.idMoneda = idMoneda;
    }

    public Date getDesde() {
        return Desde;
    }

    public void setDesde(Date desde) {
        Desde = desde;
    }

    public Date getHasta() {
        return Hasta;
    }

    public void setHasta(Date hasta) {
        Hasta = hasta;
    }

}
