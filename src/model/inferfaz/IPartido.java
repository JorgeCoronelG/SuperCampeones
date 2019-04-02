package model.inferfaz;

import java.util.List;
import model.dto.DtoPartido;

/**
 *
 * @author Jorge Coronel González
 */
public interface IPartido {
    
    public List<DtoPartido> findAll() throws Exception;
    public DtoPartido find(DtoPartido dtoPartido) throws Exception;
    public DtoPartido create(DtoPartido dtoPartido) throws Exception;
    
}