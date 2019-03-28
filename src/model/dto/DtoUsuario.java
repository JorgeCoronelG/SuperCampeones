package model.dto;

/**
 *
 * @author Jorge Coronel González
 */
public class DtoUsuario {
    
    private int idUs;
    private String nombreUs;
    private String passUs;
    private boolean estatus;

    public DtoUsuario() {
    }

    public DtoUsuario(int idUs, String nombreUs, String passUs, boolean estatus) {
        this.idUs = idUs;
        this.nombreUs = nombreUs;
        this.passUs = passUs;
        this.estatus = estatus;
    }

    public int getIdUs() {
        return idUs;
    }

    public void setIdUs(int idUs) {
        this.idUs = idUs;
    }

    public String getNombreUs() {
        return nombreUs;
    }

    public void setNombreUs(String nombreUs) {
        this.nombreUs = nombreUs;
    }

    public String getPassUs() {
        return passUs;
    }

    public void setPassUs(String passUs) {
        this.passUs = passUs;
    }

    public boolean isEstatus() {
        return estatus;
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }
    
}