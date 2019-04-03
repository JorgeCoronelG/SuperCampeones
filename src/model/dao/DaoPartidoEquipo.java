package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.dto.DtoEquipo;
import model.dto.DtoPartidoEquipo;
import model.inferfaz.Constants;
import static model.inferfaz.Constants.DRIVER;
import static model.inferfaz.Constants.PASSWORD;
import static model.inferfaz.Constants.URL;
import static model.inferfaz.Constants.USER;

/**
 *
 * @author Jorge Coronel González
 */
public class DaoPartidoEquipo implements Constants {
    
    /**
     * Método para sacar los equipos con los que se ha enfrentado algún equipo
     * @param dtoPartidoEquipo Dto con el equipo referente
     * @return Lista de partidos
     */
    public List<DtoEquipo> getPartidosEquipo(DtoPartidoEquipo dtoPartidoEquipo) throws Exception{
        List<DtoEquipo> lista = new ArrayList<DtoEquipo>();
        Class.forName(DRIVER);
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        String consulta = "SELECT idEq FROM partido_equipo INNER JOIN partido ON "
                + "partido_equipo.idPtd = partido.idPtd WHERE partido_equipo.idPtd = ?";
        PreparedStatement pst = conn.prepareStatement(consulta);
        pst.setInt(1, dtoPartidoEquipo.getEquipo().getIdEq());
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            if(rs.getInt("idEq") != dtoPartidoEquipo.getEquipo().getIdEq()){
                DtoEquipo dto = new DtoEquipo();
                dto.setIdEq(rs.getInt("idEq"));
                lista.add(dto);
            }
        }
        return lista;
    }
    
}