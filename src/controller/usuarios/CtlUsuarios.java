package controller.usuarios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.business.BnsUsuario;
import model.dto.DtoUsuario;
import view.login.FrmLogin;
import view.principal.VistaPrincipal;

/**
 *
 * @author Jorge Coronel González
 */
public class CtlUsuarios implements ActionListener {

    private FrmLogin vista;
    private BnsUsuario modeloUsuario;

    public CtlUsuarios(FrmLogin vista, BnsUsuario modeloUsuario) {
        this.vista = vista;
        this.modeloUsuario = modeloUsuario;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {

            if (e.getActionCommand().equals("Ingresar")) {
                vista.setControlador(new CtlUsuarios(vista, modeloUsuario));
                vista.setTitle("Agregar usuario");
                vista.setVisible(true);
                DtoUsuario dto = vista.obtenerDatos();
                DtoUsuario usuario = modeloUsuario.buscarUsuario(dto);
                if (usuario != null) {
                    vista.visualizarMsg("Ingreso correcto");
                    vista.dispose();
                    
                    
                } 

            }

        } catch (Exception ex) {
            vista.visualizarMsg(ex.getMessage());            
        }
    }

}
