package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.dto.DtoUsuario;
import model.inferfaz.Constants;
import model.inferfaz.IUsuario;

/**
 *
 * @author Lalo
 */
public class DaoUsuario implements IUsuario, Constants{

    @Override
    public DtoUsuario find(DtoUsuario usuario) throws Exception {
        DtoUsuario dto = null;
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        String consulta = "SELECT * FROM USUARIO WHERE nombreUs LIKE '?' AND passUs LIKE MD5(?)";
        PreparedStatement pst = conn.prepareStatement(consulta);
        pst.setString(1, usuario.getNombreUs());
        pst.setString(2, usuario.getPassUs());
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            dto = new DtoUsuario(
                    rs.getInt("idUs"),
                    rs.getString("nombreUs"),
                    rs.getString("passUs"),
                    rs.getBoolean("estatus"));
        }
        return dto;
    }
    
}