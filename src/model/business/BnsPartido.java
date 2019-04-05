package model.business;

import java.util.List;
import model.dao.DaoPartido;
import model.dto.DtoPartido;

/**
 *
 * @author Jorge Coronel González
 */
public class BnsPartido {
    
    private DaoPartido daoPartido;

    public BnsPartido() {
        daoPartido = new DaoPartido();
    }
    
    public List<DtoPartido> buscarTodos() throws Exception{
        return daoPartido.findAll();
    }
    
    public DtoPartido buscarPartido(int idPtd) throws Exception{
        DtoPartido dtoPartido = null;
        if(idPtd == 0){
            throw new Exception("Faltan datos");
        }else{
            DtoPartido dto = new DtoPartido();
            dto.setIdPtd(idPtd);
            dtoPartido = daoPartido.find(dtoPartido);
        }
        return dtoPartido;
    }
    
    public DtoPartido crear(DtoPartido dto) throws Exception{
        DtoPartido dtoPartido = null;
        if(dto.getArbitroPtd().isEmpty() || dto.getArbitroPtd() == null || dto.getJorPtd() == 0  ){
            throw new Exception("Faltan datos");
        }else{
            dtoPartido = daoPartido.create(dto);
            if(dtoPartido == null){
                throw new Exception("Partido no creado");
            }
        }
        return dtoPartido;
    }
    
}