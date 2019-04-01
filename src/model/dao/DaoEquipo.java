
package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.dto.DtoEquipo;
import model.inferfaz.Constants;
import model.inferfaz.IEquipo;

/**
 *
 * @author Jorge Coronel González
 */
public class DaoEquipo implements IEquipo, Constants{

    @Override
    public List<DtoEquipo> findAll() throws Exception {
        List<DtoEquipo> lista = new ArrayList<DtoEquipo>();
        Class.forName(DRIVER);
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        String consulta = "SELECT * FROM EQUIPO";
        PreparedStatement pst = conn.prepareStatement(consulta);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            lista.add(new DtoEquipo(
                rs.getInt("idEq"), 
                rs.getString("nombreEq"), 
                rs.getInt("pgEq"), 
                rs.getInt("ppEq"), 
                rs.getInt("peEq"), 
                rs.getInt("gaEq"), 
                rs.getInt("geEq"), 
                rs.getInt("difEq"), 
                rs.getInt("puntosEq"))
            );
        }
        return lista;
    }

    @Override
    public DtoEquipo find(DtoEquipo dtoEquipo) throws Exception {
        DtoEquipo dto = null;
        Class.forName(DRIVER);
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        String consulta = "SELECT * FROM EQUIPO WHERE nombreEq LIKE '?'";
        PreparedStatement pst = conn.prepareStatement(consulta);
        pst.setString(1, dtoEquipo.getNombreEq());
        ResultSet rs = pst.executeQuery();
        if(rs.next()){
            return dto = new DtoEquipo(
                rs.getInt("idEq"), 
                rs.getString("nombreEq"), 
                rs.getInt("pgEq"), 
                rs.getInt("ppEq"), 
                rs.getInt("peEq"), 
                rs.getInt("gaEq"), 
                rs.getInt("geEq"), 
                rs.getInt("difEq"), 
                rs.getInt("puntosEq")
            );
        }else{
            return dto;
        }
    }

    @Override
    public DtoEquipo create(DtoEquipo dtoEquipo) throws Exception {
        Class.forName(DRIVER);
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        String consulta = "INSERT INTO EQUIPO values(null,?,0,0,0,0,0,0,0)";
        PreparedStatement pst = conn.prepareStatement(consulta);
        pst.setString(1, dtoEquipo.getNombreEq());
        pst.executeUpdate();
        return dtoEquipo;
    }

    @Override
    public boolean delete(DtoEquipo dtoEquipo) throws Exception {
        Class.forName(DRIVER);
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        String consulta = "DELETE FROM USUARIO WHERE idEq = ?";
        PreparedStatement pst = conn.prepareStatement(consulta);
        pst.setInt(1, dtoEquipo.getIdEq());
        int result = pst.executeUpdate();
        return result >= 1;
    }

    @Override
    public boolean update(DtoEquipo dtoEquipo) throws Exception {
        Class.forName(DRIVER);
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        String consulta = "UPDATE EQUIPO SET nombreEq = '?' WHERE idEq = ?";
        PreparedStatement pst = conn.prepareStatement(consulta);
        pst.setString(1, dtoEquipo.getNombreEq());
        pst.setInt(2, dtoEquipo.getIdEq());
        int result = pst.executeUpdate();
        return result >= 1;
    }
    
}