package model.dto;

/**
 *
 * @author Jorge Coronel González
 */
public class DtoEquipo {
    
    private int idEq;
    private String nombreEq;
    private int pgEq;
    private int ppEq;
    private int peEq;
    private int gaEq;
    private int geEq;
    private int difEq;
    private int puntosEq;

    public DtoEquipo() {
    }

    public DtoEquipo(String nombreEq) {
        this.nombreEq = nombreEq;
    }

    public DtoEquipo(int idEq, String nombreEq, int pgEq, int ppEq, int peEq, int gaEq, int geEq, int difEq, int puntosEq) {
        this.idEq = idEq;
        this.nombreEq = nombreEq;
        this.pgEq = pgEq;
        this.ppEq = ppEq;
        this.peEq = peEq;
        this.gaEq = gaEq;
        this.geEq = geEq;
        this.difEq = difEq;
        this.puntosEq = puntosEq;
    }

    public int getIdEq() {
        return idEq;
    }

    public void setIdEq(int idEq) {
        this.idEq = idEq;
    }

    public String getNombreEq() {
        return nombreEq;
    }

    public void setNombreEq(String nombreEq) {
        this.nombreEq = nombreEq;
    }

    public int getPgEq() {
        return pgEq;
    }

    public void setPgEq(int pgEq) {
        this.pgEq = pgEq;
    }

    public int getPpEq() {
        return ppEq;
    }

    public void setPpEq(int ppEq) {
        this.ppEq = ppEq;
    }

    public int getPeEq() {
        return peEq;
    }

    public void setPeEq(int peEq) {
        this.peEq = peEq;
    }

    public int getGaEq() {
        return gaEq;
    }

    public void setGaEq(int gaEq) {
        this.gaEq = gaEq;
    }

    public int getGeEq() {
        return geEq;
    }

    public void setGeEq(int geEq) {
        this.geEq = geEq;
    }

    public int getDifEq() {
        return difEq;
    }

    public void setDifEq(int difEq) {
        this.difEq = difEq;
    }

    public int getPuntosEq() {
        return puntosEq;
    }

    public void setPuntosEq(int puntosEq) {
        this.puntosEq = puntosEq;
    }
    
}