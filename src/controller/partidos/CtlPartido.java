/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.partidos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.business.BnsPartido;
import model.dto.DtoPartido;
import view.partido.FrmPartido;
import view.partido.PanelPartido;

/**
 *
 * @author Lalo
 */
public class CtlPartido implements ActionListener{

    private PanelPartido pnlPartido;
    private FrmPartido frmPartido;
    private BnsPartido mdlPartido;
    
    
    public CtlPartido(PanelPartido pnlPartido, BnsPartido mdlPartido) {
        this.pnlPartido = pnlPartido;
        this.mdlPartido = mdlPartido;
    }
    
    
    public CtlPartido(PanelPartido pnlPartido,FrmPartido frmPartido, BnsPartido mdlPartido) {
        this.pnlPartido = pnlPartido;
        this.frmPartido = frmPartido;
        this.mdlPartido = mdlPartido;        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
         try {             
             if (e.getActionCommand().equalsIgnoreCase("Agregar")) {                                 
                frmPartido = new FrmPartido();
                frmPartido.llenarCombo();
                frmPartido.setControlador(new CtlPartido(pnlPartido, frmPartido, mdlPartido));
                frmPartido.setTitle("Agregar partido");
                frmPartido.setAccion("Agregar");
                frmPartido.setVisible(true);                                
            } else if (e.getActionCommand().equalsIgnoreCase("Aceptar")) {
                if (frmPartido.getAccion().equalsIgnoreCase("Agregar")) {
                    DtoPartido dto = frmPartido.obtenerDatos();
                    mdlPartido.crear(dto);
                    frmPartido.visualizarMsg("Guardado correctamente");
                    frmPartido.dispose();
                    pnlPartido.VisualizarInformacion(mdlPartido.buscarTodos());
                } 
            } else if (e.getActionCommand().equals("Cancelar")) {
                frmPartido.dispose();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    }
    
    
    
    

