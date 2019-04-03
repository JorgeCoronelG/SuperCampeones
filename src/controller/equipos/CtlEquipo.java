/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.equipos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
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
            if(e.getActionCommand().equalsIgnoreCase("Buscar")){                                
                frmEquipo = new FrmEquipo();
                frmEquipo.setControlador(new CtlEquipo(pnlEquipo, frmEquipo, mdlEquipo));
                String busqueda = pnlEquipo.obtenerBusqueda();                                
                List<DtoEquipo>lista = mdlEquipo.buscarFiltrando(busqueda);
                frmEquipo.dispose();                
                pnlEquipo.VisualizarInformacion(lista);                
            }else if(e.getActionCommand().equalsIgnoreCase("Agregar")){
                frmEquipo = new FrmEquipo();
                frmEquipo.setControlador(new CtlEquipo(pnlEquipo, frmEquipo, mdlEquipo));
                frmEquipo.setTitle("Agregar equipo");
                frmEquipo.setAccion("Agregar");
                frmEquipo.setVisible(true);
            } else if(e.getActionCommand().equalsIgnoreCase("Editar")){
                frmEquipo = new FrmEquipo();
                frmEquipo.setControlador(new CtlEquipo(pnlEquipo, frmEquipo, mdlEquipo));
                frmEquipo.setTitle("Editar equipo");
                frmEquipo.setAccion("Editar");
                String nombre = pnlEquipo.obtenerDatoEquipo();                
                frmEquipo.visualizarDatos(mdlEquipo.buscarEquipo(nombre),0);                
                frmEquipo.setVisible(true);
            } else if(e.getActionCommand().equalsIgnoreCase("Borrar")){
                frmEquipo = new FrmEquipo();
                frmEquipo.setControlador(new CtlEquipo(pnlEquipo, frmEquipo, mdlEquipo));
                frmEquipo.setTitle("Borrar equipo");
                frmEquipo.setAccion("Borrar");
                String equipo = pnlEquipo.obtenerDatoEquipo();
                frmEquipo.visualizarDatos(mdlEquipo.buscarEquipo(equipo),1);                
                frmEquipo.setVisible(true);
            } else if(e.getActionCommand().equals("Aceptar")){
                if(frmEquipo.getAccion().equalsIgnoreCase("Agregar")){
                    DtoEquipo dto = frmEquipo.obtenerDatos();
                    mdlEquipo.crear(dto.getNombreEq());
                    frmEquipo.visualizarMsg("Guardado correctamente");
                    frmEquipo.dispose();
                    pnlEquipo.VisualizarInformacion(mdlEquipo.buscarTodos());
                }else if(frmEquipo.getAccion().equalsIgnoreCase("Editar")){                    
                    DtoEquipo dtoNuevo = frmEquipo.obtenerDatos();
                    DtoEquipo dtoActual = mdlEquipo.getDtoEquipoUpdate();
                    if(mdlEquipo.actualizar(dtoActual,dtoNuevo)){
                        frmEquipo.visualizarMsg("Guardado correctamente");
                        frmEquipo.dispose();
                    }else{
                        frmEquipo.visualizarMsg("Ocurrió un error");
                        frmEquipo.dispose();
                    }
                }else if(frmEquipo.getAccion().equalsIgnoreCase("Borrar")){                    
                    DtoEquipo dto = frmEquipo.obtenerDatos();
                    //DtoEquipo dtoDelete = mdlUsuario.buscarUsuario(dto.getUsuario());
                    if(mdlEquipo.borrar(dto.getNombreEq())){
                        frmEquipo.visualizarMsg("Eliminado correctamente");
                            frmEquipo.dispose();
                    }else{
                        frmEquipo.visualizarMsg("Ocurrió un error");
                        frmEquipo.dispose();
                    }
                }
            }else if(e.getActionCommand().equals("Cancelar")){
                frmEquipo.dispose();
            }
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
}
