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
     * @param dtoPartidoEquipo Dto con el equipo y partido referente
     * @return Lista de partidos
     */
    public List<DtoEquipo> getPartidosEquipo(DtoPartidoEquipo dtoPartidoEquipo) throws Exception{
        List<DtoEquipo> lista = new ArrayList<DtoEquipo>();
        Class.forName(DRIVER);
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        String consulta = "SELECT partido_equipo.idEq AS idEq FROM partido_equipo INNER JOIN partido ON "
                + "partido_equipo.idPtd = partido.idPtd WHERE idEq != ? AND partido_equipo.idPtd "
                + "IN(SELECT partido_equipo.idPtd FROM partido_equipo WHERE idEq = ?)";
        PreparedStatement pst = conn.prepareStatement(consulta);
        pst.setInt(1, dtoPartidoEquipo.getEquipo().getIdEq());
        pst.setInt(2, dtoPartidoEquipo.getEquipo().getIdEq());
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            DtoEquipo dto = new DtoEquipo();
            dto.setIdEq(rs.getInt("idEq"));
            lista.add(dto);
        }
        return lista;
    }
    
    public DtoPartidoEquipo create(DtoPartidoEquipo dtoPartidoEquipo) throws Exception{
        Class.forName(DRIVER);
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        String consulta = "INSERT INTO PARTIDO_EQUIPO VALUES(?,?,?)";
        PreparedStatement pst = conn.prepareStatement(consulta);
        pst.setInt(1, dtoPartidoEquipo.getPartido().getIdPtd());
        pst.setInt(2, dtoPartidoEquipo.getEquipo().getIdEq());
        pst.setInt(3, dtoPartidoEquipo.getGolesEq());
        pst.executeUpdate();
        return dtoPartidoEquipo;
    }
    
}