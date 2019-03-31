package controller.usuarios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.login.FrmLogin;

/**
 *
 * @author Jorge Coronel González
 */
public class CtlUsuarios implements ActionListener{
    
    private FrmLogin vista;
    //private BnsUsuario modeloUsuario;

    public CtlUsuarios(FrmLogin vista) {
        this.vista = vista;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Ingresar")){
            try {
                System.out.println("Click");
            } catch (Exception ex) {
                Logger.getLogger(CtlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}