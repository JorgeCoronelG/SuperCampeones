package model.business;

import java.util.ArrayList;
import java.util.List;
import model.dao.DaoEquipo;
import model.dao.DaoPartidoEquipo;
import model.dto.DtoEquipo;
import model.dto.DtoPartidoEquipo;

/**
 *
 * @author Jorge Coronel González
 */
public class BnsPartidoEquipo {
    
    private DaoPartidoEquipo daoPartidoEquipo;
    private DaoEquipo daoEquipo;

    public BnsPartidoEquipo() {
        daoPartidoEquipo = new DaoPartidoEquipo();
        daoEquipo = new DaoEquipo();
    }
    
    public List<DtoEquipo> equiposDisponibles(DtoPartidoEquipo dtoPartidoEquipo) throws Exception{
        if(dtoPartidoEquipo == null){
            throw new Exception("Faltan datos");
        }else{
            return daoEquipo.getEquiposExcepto(daoPartidoEquipo.getPartidosEquipo(dtoPartidoEquipo));
        }
    }
    
}