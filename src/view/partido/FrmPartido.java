/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.partido;

import controller.partidos.CtlPartido;
import java.util.List;
import javax.swing.JOptionPane;
import model.business.BnsEquipo;
import model.dto.DtoEquipo;
import model.dto.DtoPartido;

/**
 *
 * @author Lalo
 */
public class FrmPartido extends javax.swing.JFrame {

    /**
     * Creates new form FrmPartido
     */
    private String accion;

    public FrmPartido() {
        initComponents();
        btnReiniciar.setVisible(false);
    }
    
    
    
    public DtoPartido obtenerDatos() {
        DtoPartido dto = new DtoPartido();
        dto.setIdPtd(0);        
        dto.setArbitroPtd(txtArbitro.getText());
        dto.setJorPtd(Integer.valueOf(txtJornada.getText()));
        return dto;
    }

    public List<DtoEquipo> obtenerEquipos() throws Exception {
        List<DtoEquipo> lista;
        BnsEquipo bns = new BnsEquipo();
        lista = bns.buscarTodos();
        return lista;
    }

    public void llenarCombo() throws Exception {
        List<DtoEquipo> lista = obtenerEquipos();
        for (int i = 0; i < lista.size(); i++) {
            cbxEquipos.addItem(lista.get(i).getNombreEq());
        }
    }

    public void visualizarMsg(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }

    public void setControlador(CtlPartido ctl) {
        btnAceptar.addActionListener(ctl);
        btnCancelar.addActionListener(ctl);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblLocal = new javax.swing.JLabel();
        lblVisitante = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblJornada = new javax.swing.JLabel();
        txtArbitro = new javax.swing.JTextField();
        txtJornada = new javax.swing.JTextField();
        lblEquipos = new javax.swing.JLabel();
        cbxEquipos = new javax.swing.JComboBox<>();
        btnAsignar = new javax.swing.JButton();
        btnReiniciar = new javax.swing.JButton();
        dchFecha = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAceptar.setText("Aceptar");

        btnCancelar.setText("Cancelar");

        lblLocal.setText("Local");

        lblVisitante.setText("Visitante");

        jLabel3.setText("VS");

        jLabel1.setText("Fecha");

        jLabel2.setText("Arbitro");

        lblJornada.setText("Jornada");

        lblEquipos.setText("Equipos");

        btnAsignar.setText("Asignar");
        btnAsignar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAsignarMouseClicked(evt);
            }
        });

        btnReiniciar.setText("Reiniciar");
        btnReiniciar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReiniciarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(lblJornada)
                                    .addComponent(jLabel1)
                                    .addComponent(lblEquipos))
                                .addGap(66, 66, 66))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnAceptar)
                                    .addComponent(lblLocal))
                                .addGap(6, 6, 6)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbxEquipos, 0, 97, Short.MAX_VALUE)
                                    .addComponent(txtJornada))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAsignar))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(btnReiniciar))
                            .addComponent(txtArbitro, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dchFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(60, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblVisitante)
                            .addComponent(btnCancelar))
                        .addGap(78, 78, 78))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(dchFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtArbitro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblJornada)
                    .addComponent(txtJornada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEquipos)
                    .addComponent(cbxEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAsignar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReiniciar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLocal)
                    .addComponent(jLabel3)
                    .addComponent(lblVisitante))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAsignarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAsignarMouseClicked
        if (lblLocal.getText() == "Local") {
            lblLocal.setText(cbxEquipos.getSelectedItem().toString());
            cbxEquipos.removeItem(cbxEquipos.getSelectedItem());
        } else {
            if (lblVisitante.getText() == "Visitante") {
                lblVisitante.setText(cbxEquipos.getSelectedItem().toString());
                btnAsignar.setVisible(false);
                btnReiniciar.setVisible(true);
            }
        }
    }//GEN-LAST:event_btnAsignarMouseClicked

    private void btnReiniciarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReiniciarMouseClicked
        cbxEquipos.addItem(lblLocal.getText());
        lblLocal.setText("Local");
        lblVisitante.setText("Visitante");
    }//GEN-LAST:event_btnReiniciarMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmPartido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPartido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPartido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPartido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPartido().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAsignar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnReiniciar;
    private javax.swing.JComboBox<String> cbxEquipos;
    private com.toedter.calendar.JDateChooser dchFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblEquipos;
    private javax.swing.JLabel lblJornada;
    private javax.swing.JLabel lblLocal;
    private javax.swing.JLabel lblVisitante;
    private javax.swing.JTextField txtArbitro;
    private javax.swing.JTextField txtJornada;
    // End of variables declaration//GEN-END:variables

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }
}
