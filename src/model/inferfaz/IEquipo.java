package model.inferfaz;

import java.util.List;
import model.dto.DtoEquipo;

/**
 *
 * @author Jorge Coronel González
 */
public interface IEquipo {
    
    public List<DtoEquipo> findAll() throws Exception;
    public List<DtoEquipo> findWanted(String busqueda) throws Exception;
    public DtoEquipo find(DtoEquipo dtoEquipo) throws Exception;
    public DtoEquipo create(DtoEquipo dtoEquipo) throws Exception;
    public boolean delete(DtoEquipo dtoEquipo) throws Exception;
    public boolean update(DtoEquipo dtoEquipo) throws Exception;
    
}
