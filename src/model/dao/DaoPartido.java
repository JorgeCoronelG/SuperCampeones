package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.dto.DtoPartido;
import model.inferfaz.Constants;
import model.inferfaz.IPartido;

/**
 *
 * @author Jorge COronel González
 */
public class DaoPartido implements IPartido, Constants{

    @Override
    public List<DtoPartido> findAll() throws Exception {
        List<DtoPartido> lista = new ArrayList<DtoPartido>();
        Class.forName(DRIVER);
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        String consulta = "SELECT * FROM PARTIDO";
        PreparedStatement pst = conn.prepareStatement(consulta);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            lista.add(new DtoPartido(
                rs.getInt("idPtd"), 
                rs.getString("arbitroPtd"), rs.getInt("jorPtd"))
            );
        }
        return lista;
    }
    
    @Override
    public DtoPartido find(DtoPartido dtoPartido) throws Exception {
        DtoPartido dto = null;
        Class.forName(DRIVER);
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        String consulta = "SELECT * FROM PARTIDO WHERE idPtd = ?";
        PreparedStatement pst = conn.prepareStatement(consulta);
        pst.setInt(1, dtoPartido.getIdPtd());
        ResultSet rs = pst.executeQuery();
        if(rs.next()){
            return dto = new DtoPartido(
                    rs.getInt("idPtd"), 
                    rs.getString("arbitroPtd"), 
                    rs.getInt("jorPtd"));
        }else{
            return dtoPartido;
        }
    }

    @Override
    public DtoPartido create(DtoPartido dtoPartido) throws Exception {
        Class.forName(DRIVER);
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        String consulta = "INSERT INTO PARTIDO VALUES(null, ?, ?)";
        PreparedStatement pst = conn.prepareStatement(consulta);
        pst.setString(1, dtoPartido.getArbitroPtd());
        pst.setInt(2, dtoPartido.getJorPtd());
        pst.executeUpdate();
        return dtoPartido;
    }
    
}