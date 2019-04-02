package model.business;

import java.util.List;
import model.dao.DaoEquipo;
import model.dto.DtoEquipo;

/**
 *
 * @author Jorge Coronel González
 */
public class BnsEquipo {
    
    private DaoEquipo daoEquipo;

    public BnsEquipo() {
        daoEquipo = new DaoEquipo();
    }
    
    public List<DtoEquipo> buscarTodos() throws Exception{
        return daoEquipo.findAll();
    }
    
    public DtoEquipo buscarEquipo(String nombreEq) throws Exception{
        DtoEquipo dtoEquipo = null;
        if(nombreEq.isEmpty() || nombreEq == null){
            throw new Exception("Faltan datos");
        }else{
            DtoEquipo dto = new DtoEquipo();
            dto.setNombreEq(nombreEq);
            dtoEquipo = daoEquipo.find(dto);
        }
        return dtoEquipo;
    }
    
    public DtoEquipo crear(String nombreEq) throws Exception{
        DtoEquipo dtoEquipo = null;
        if(nombreEq.isEmpty() || nombreEq == null){
            throw new Exception("Faltan datos");
        }else{
            dtoEquipo = daoEquipo.create(new DtoEquipo(nombreEq));
            if(dtoEquipo == null){
                throw new Exception("Equipo no creado");
            }
        }
        return dtoEquipo;
    }
    
    public boolean actualizar(int idEq, String nombreEq) throws Exception{
        boolean result = false;
        if(nombreEq.isEmpty() || nombreEq == null || idEq == 0){
            throw new Exception("Faltan datos");
        }else{
            DtoEquipo dtoEquipo = new DtoEquipo();
            dtoEquipo.setIdEq(idEq);
            dtoEquipo.setNombreEq(nombreEq);
            result = daoEquipo.update(dtoEquipo);
        }
        return result;
    }
    
    public boolean borrar(int idEq) throws Exception{
        boolean result = false;
        if(idEq == 0){
            throw new Exception("Faltan datos");
        }else{
            DtoEquipo dtoEquipo = new DtoEquipo();
            dtoEquipo.setIdEq(idEq);
            result = daoEquipo.delete(dtoEquipo);
        }
        return result;
    }
    
}