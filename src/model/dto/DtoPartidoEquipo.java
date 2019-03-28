package model.dto;

/**
 *
 * @author Jorge Coronel González
 */
public class DtoPartidoEquipo {
    
    private DtoPartido partido;
    private DtoEquipo equipo;
    private int golesEq;

    public DtoPartidoEquipo() {
    }

    public DtoPartidoEquipo(DtoPartido partido, DtoEquipo equipo, int golesEq) {
        this.partido = partido;
        this.equipo = equipo;
        this.golesEq = golesEq;
    }

    public DtoPartido getPartido() {
        return partido;
    }

    public void setPartido(DtoPartido partido) {
        this.partido = partido;
    }

    public DtoEquipo getEquipo() {
        return equipo;
    }

    public void setEquipo(DtoEquipo equipo) {
        this.equipo = equipo;
    }

    public int getGolesEq() {
        return golesEq;
    }

    public void setGolesEq(int golesEq) {
        this.golesEq = golesEq;
    }
    
}