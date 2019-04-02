package principal;

import controller.usuarios.CtlUsuarios;
import model.business.BnsUsuario;
import view.login.FrmLogin;

/**
 *
 * @author Jorge Coronel González
 */
public class Principal {
    
    public static void main(String[] args){
        FrmLogin frmLogin = new FrmLogin();
        BnsUsuario bnsUsuario = new BnsUsuario();
        CtlUsuarios ctlUsuarios = new CtlUsuarios(frmLogin,bnsUsuario);
        frmLogin.setControlador(ctlUsuarios);
        frmLogin.setVisible(true);
    }
    
}