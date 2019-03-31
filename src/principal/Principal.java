package principal;

import controller.usuarios.CtlUsuarios;
import view.login.FrmLogin;

/**
 *
 * @author Jorge Coronel González
 */
public class Principal {
    
    public static void main(String[] args){
        FrmLogin frmLogin = new FrmLogin();
        CtlUsuarios ctlUsuarios = new CtlUsuarios(frmLogin);
        frmLogin.setControlador(ctlUsuarios);
        frmLogin.setVisible(true);
    }
    
}