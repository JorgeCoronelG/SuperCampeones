package controller.principal;

import controller.equipos.CtlEquipo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.business.BnsEquipo;
import model.business.BnsPartido;
import view.equipo.PanelEquipo;
import view.principal.VistaPrincipal;


/**
 *
 * @author Jorge Coronel González
 */
public class CtlPrincipal implements ActionListener {
    
    private VistaPrincipal vista;
    private BnsEquipo modeloEquipo;
    private BnsPartido modeloPartido;
    

    public CtlPrincipal(VistaPrincipal vista) {
        this.vista = vista;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equalsIgnoreCase("Equipo")){
            try {
                //Hacer algo
                modeloEquipo = new BnsEquipo();
                PanelEquipo pnlEquipo = new PanelEquipo();
                CtlEquipo ctlEquipo = new CtlEquipo(pnlEquipo, modeloEquipo);        
                pnlEquipo.setControlador(ctlEquipo);
                pnlEquipo.VisualizarInformacion(modeloEquipo.buscarTodos());                
                vista.setPnlEquipo(pnlEquipo);
            } catch (Exception ex) {
                Logger.getLogger(CtlPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }/**else if(e.getActionCommand().equals("Roles")){
            try {
                modeloRol = new BnsMain();
                PanelRoles pnlRoles = new PanelRoles();
                CtlRol ctlRol = new CtlRol(pnlRoles, modeloRol);
                pnlRoles.setControlador(ctlRol);
                pnlRoles.visualizarInformacion(modeloRol.buscarTodosRol());
                vista.setPnlRoles(pnlRoles);
            } catch (Exception ex) {
                Logger.getLogger(CtlRol.class.getName()).log(Level.SEVERE, null, ex);
            }
        }**/
    }
    
}