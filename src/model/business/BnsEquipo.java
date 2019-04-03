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
    private DtoEquipo dtoEquipoUpdate;

    public BnsEquipo() {
        daoEquipo = new DaoEquipo();
    }
    
    public List<DtoEquipo> buscarTodos() throws Exception{
        return daoEquipo.findAll();
    }
    
    public List<DtoEquipo> tablaGeneral() throws Exception{
        return daoEquipo.generalTable();
    }
    
    
    public List<DtoEquipo> buscarFiltrando(String busqueda) throws Exception{
        return daoEquipo.findWanted(busqueda);
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
        dtoEquipoUpdate = dtoEquipo;
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
    
    public boolean actualizar(DtoEquipo dtoActual, DtoEquipo dtoNuevo) throws Exception{
        boolean result = false;
        if(dtoNuevo.getNombreEq().isEmpty() || dtoNuevo.getNombreEq() == null){
            throw new Exception("Faltan datos");
        }else{
            DtoEquipo dtoEquipo = new DtoEquipo();
            dtoEquipo.setIdEq(dtoActual.getIdEq());
            dtoEquipo.setNombreEq(dtoNuevo.getNombreEq());
            result = daoEquipo.update(dtoEquipo);
        }
        return result;
    }
    
    public boolean borrar(String nombreEq) throws Exception{
        boolean result = false;
        if(nombreEq == null){
            throw new Exception("Faltan datos");
        }else{
            DtoEquipo dtoEquipo = new DtoEquipo();
            dtoEquipo.setNombreEq(nombreEq);
            result = daoEquipo.delete(dtoEquipo);
        }
        return result;
    }

    public DtoEquipo getDtoEquipoUpdate() {
        return dtoEquipoUpdate;
    }

    public void setDtoEquipoUpdate(DtoEquipo dtoEquipoUpdate) {
        this.dtoEquipoUpdate = dtoEquipoUpdate;
    }
    
    public boolean actualizarPartidosEquipo(DtoEquipo dtoEquipo, int resultadoPartido) throws Exception{
        boolean result = false;
        if(dtoEquipo == null || (resultadoPartido != 1 && resultadoPartido != 2 && resultadoPartido != 3)){
            throw new Exception("Faltan datos");
        }else{
            result = daoEquipo.updatePartidosEquipo(dtoEquipo, resultadoPartido);
        }
        return result;
    }
    
    public boolean actualizarPuntosEquipo(DtoEquipo dtoEquipo) throws Exception{
        boolean result = false;
        if(dtoEquipo == null){
            throw new Exception("Faltan datos");
        }else{
            DtoEquipo dto = daoEquipo.find(dtoEquipo);
            int puntos;
            puntos = dto.getPgEq() * 3;
            puntos += dto.getPeEq();
            puntos += dto.getPuntosEq();
            dto.setPuntosEq(puntos);
            result = daoEquipo.updatePuntosEquipo(dto);
        }
        return result;
    }
    
    public boolean actualizarGolesEquipo(DtoEquipo dtoEquipo, int golesFavor, int golesContra) throws Exception{
        boolean result = false;
        if(dtoEquipo == null){
            throw new Exception("Faltan datos");
        }else{
            DtoEquipo dto = daoEquipo.find(dtoEquipo);
            dto.setGaEq(dto.getGaEq() + golesFavor);
            dto.setGeEq(dto.getGeEq() + golesContra);
            dto.setDifEq(dto.getGaEq() - dto.getGeEq());
            result = daoEquipo.updateGolesEquipo(dto);
        }
        return result;
    }
    
}
