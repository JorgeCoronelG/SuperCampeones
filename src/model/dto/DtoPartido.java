package model.dto;

/**
 *
 * @author Jorge Coronel González
 */
public class DtoPartido {
    
    private int idPtd;
    private String arbitroPtd;
    private int jorPtd;

    public DtoPartido() {
    }

    public DtoPartido(int idPtd, String arbitroPtd, int jorPtd) {
        this.idPtd = idPtd;
        this.arbitroPtd = arbitroPtd;
        this.jorPtd = jorPtd;
    }

    public int getIdPtd() {
        return idPtd;
    }

    public void setIdPtd(int idPtd) {
        this.idPtd = idPtd;
    }

    public String getArbitroPtd() {
        return arbitroPtd;
    }

    public void setArbitroPtd(String arbitroPtd) {
        this.arbitroPtd = arbitroPtd;
    }

    public int getJorPtd() {
        return jorPtd;
    }

    public void setJorPtd(int jorPtd) {
        this.jorPtd = jorPtd;
    }
    
}