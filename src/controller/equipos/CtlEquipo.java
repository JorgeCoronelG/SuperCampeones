/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.equipos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.business.BnsEquipo;
import model.dto.DtoEquipo;
import model.dto.DtoUsuario;
import view.equipo.FrmEquipo;
import view.equipo.PanelEquipo;

/**
 *
 * @author Lalo
 */
public class CtlEquipo implements ActionListener{


    private PanelEquipo pnlEquipo;
    private FrmEquipo frmEquipo;
    private BnsEquipo mdlEquipo;

    
    public CtlEquipo(PanelEquipo pnlEquipo, BnsEquipo mdlEquipo) {
        this.pnlEquipo = pnlEquipo;
        this.mdlEquipo = mdlEquipo;
    }
    
    public CtlEquipo(PanelEquipo pnlEquipo, FrmEquipo frmEquipo, BnsEquipo mdlEquipo) {
        this.pnlEquipo = pnlEquipo;
        this.frmEquipo = frmEquipo;
        this.mdlEquipo = mdlEquipo;
    }
    
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
             try{
            if(e.getActionCommand().equals("Buscar")){
                //Código
            }else if(e.getActionCommand().equalsIgnoreCase("Agregar")){
                frmEquipo = new FrmEquipo();
                frmEquipo.setControlador(new CtlEquipo(pnlEquipo, frmEquipo, mdlEquipo));
                frmEquipo.setTitle("Agregar equipo");
                frmEquipo.setAccion("Agregar");
                frmEquipo.setVisible(true);
            } /**else if(e.getActionCommand().equalsIgnoreCase("Editar")){
                frmUsuario = new FrmUsuario();
                frmUsuario.setControlador(new CtlUsuario(pnlUsuarios, frmUsuario, mdlUsuario));
                frmUsuario.setTitle("Editar usuario");
                frmUsuario.setAccion("Editar");
                String usuario = pnlUsuarios.obtenerDatoUsuario();
                frmUsuario.visualizarDatos(mdlUsuario.buscarUsuario(usuario),0);
                frmUsuario.setVisible(true);
            }
            else if(e.getActionCommand().equalsIgnoreCase("Borrar")){
                frmUsuario = new FrmUsuario();
                frmUsuario.setControlador(new CtlUsuario(pnlUsuarios, frmUsuario, mdlUsuario));
                frmUsuario.setTitle("Borrar usuario");
                frmUsuario.setAccion("Borrar");
                String usuario = pnlUsuarios.obtenerDatoUsuario();
                frmUsuario.visualizarDatos(mdlUsuario.buscarUsuario(usuario),1);                
                frmUsuario.setVisible(true);
            }**/else if(e.getActionCommand().equals("Aceptar")){
                if(frmEquipo.getAccion().equalsIgnoreCase("Agregar")){
                    DtoEquipo dto = frmEquipo.obtenerDatos();
                    mdlEquipo.crear(dto.getNombreEq());
                    frmEquipo.visualizarMsg("Guardado correctamente");
                    frmEquipo.dispose();
                    pnlEquipo.VisualizarInformacion(mdlEquipo.buscarTodos());
                }/**else if(frmUsuario.getAccion().equalsIgnoreCase("Editar")){                    
                    DtoUsuario dtoNuevo = frmUsuario.obtenerDatos();
                    DtoUsuario dtoActual = mdlUsuario.getDtoUsuarioUpdate();                    
                    if(mdlUsuario.actualizarUsuario(dtoActual,dtoNuevo)){
                        frmUsuario.visualizarMsg("Guardado correctamente");
                        frmUsuario.dispose();
                    }else{
                        frmUsuario.visualizarMsg("Ocurrió un error");
                        frmUsuario.dispose();
                    }
                }else if(frmUsuario.getAccion().equalsIgnoreCase("Borrar")){                    
                    DtoUsuario dto = frmUsuario.obtenerDatos();
                    DtoUsuario dtoDelete = mdlUsuario.buscarUsuario(dto.getUsuario());
                    if(mdlUsuario.borrarUsuario(dtoDelete)){
                        frmUsuario.visualizarMsg("Eliminado correctamente");
                        frmUsuario.dispose();
                    }else{
                        frmUsuario.visualizarMsg("Ocurrió un error");
                        frmUsuario.dispose();
                    }
                }**/
            }else if(e.getActionCommand().equals("Cancelar")){
                frmEquipo.dispose();
            }
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
}
