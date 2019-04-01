package model.inferfaz;

import model.dto.DtoUsuario;

/**
 *
 * @author Lalo
 */
public interface IUsuario {

    public DtoUsuario find(DtoUsuario dtoUsuario) throws Exception;
    
}