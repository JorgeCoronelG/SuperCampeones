package model.business;

import model.dao.DaoUsuario;
import model.dto.DtoUsuario;

/**
 *
 * @author Lalo
 */
public class BnsUsuario {
    
    private DaoUsuario daoUsuario;
    
    public BnsUsuario() {
        daoUsuario = new DaoUsuario();        
    }
    
    public DtoUsuario buscarUsuario(DtoUsuario usuario) throws Exception {
        DtoUsuario dtoUsuario = null;
        if (usuario.getNombreUs() == null || usuario.getNombreUs().isEmpty() || usuario.getPassUs() == null || usuario.getPassUs().isEmpty()) {
            throw new Exception("Datos invalidos");
        } else {
            dtoUsuario = daoUsuario.find(usuario);
            if (dtoUsuario == null) {
                throw new Exception("Usuario o contraseña incorrectos");
            }
        }
        return dtoUsuario;
    }
}