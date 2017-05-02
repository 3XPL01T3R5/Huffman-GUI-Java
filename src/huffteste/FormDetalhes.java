/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffteste;

import ExternalResources.HuffmanProgram;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 *
 * @author lucas
 */
public class FormDetalhes extends javax.swing.JFrame {

    /**
     * Creates new form FormDetalhes
     */
    private HuffmanProgram hp;

    public FormDetalhes(HuffmanProgram hp) {
        initComponents();
        this.hp = hp;
        lblOrigin.setText(hp.getHj().getOrigin());
        lblDestination.setText(hp.getHj().getDestination());
        lblStatus.setText(hp.getHj().getStatus());
        //jProgressBar1.setValue(hp.getHj().getProgress());
        this.setProgress(hp.getHj().getProgress());
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Detalhes da Tarefa " + hp.getHj().getId());
        setProgress(hp.getHj().getProgress());
    }

    public void callForm() {
        //jProgressBar1.setValue(hp.getHj().getProgress());
        setProgress(hp.getHj().getProgress());
        lblStatus.setText(hp.getHj().getStatus());
        if (hp.isDone()) {
            btnCancel.setEnabled(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCancel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblOrigin = new javax.swing.JLabel();
        lblDestination = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblProgressBar = new javax.swing.JLabel();
        lblProgressBarBg = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(555, 290));
        setMinimumSize(new java.awt.Dimension(555, 290));
        setPreferredSize(new java.awt.Dimension(555, 290));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCancel.setBackground(new java.awt.Color(204, 204, 204));
        btnCancel.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        btnCancel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("huffteste/Bundle"); // NOI18N
        btnCancel.setText(bundle.getString("FormDetalhes.btnCancel.text")); // NOI18N
        btnCancel.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnCancel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));
        btnCancel.setOpaque(true);
        btnCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCancelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCancelMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnCancelMouseReleased(evt);
            }
        });
        getContentPane().add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, 110, 23));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Detalhes da execução");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Arquivo de entrada:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Arquivo de saída:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        lblOrigin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblOrigin.setForeground(new java.awt.Color(255, 255, 255));
        lblOrigin.setText("jLabel4");
        getContentPane().add(lblOrigin, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, -1, -1));

        lblDestination.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDestination.setForeground(new java.awt.Color(255, 255, 255));
        lblDestination.setText("jLabel5");
        getContentPane().add(lblDestination, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Status:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        lblProgressBar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/progressDetails.png"))); // NOI18N
        lblProgressBar.setText(bundle.getString("FormPrincipal.lblProgressBar.text")); // NOI18N
        getContentPane().add(lblProgressBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 167, 0, -1));

        lblProgressBarBg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/progressBarDetails.png"))); // NOI18N
        lblProgressBarBg.setText(bundle.getString("FormPrincipal.lblProgressBarBg.text")); // NOI18N
        getContentPane().add(lblProgressBarBg, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 160, 530, 42));

        lblStatus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblStatus.setForeground(new java.awt.Color(255, 255, 255));
        lblStatus.setText("jLabel5");
        getContentPane().add(lblStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, -1, -1));

        lblBackground.setBackground(new java.awt.Color(159, 20, 20));
        lblBackground.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblBackground.setForeground(new java.awt.Color(255, 255, 255));
        lblBackground.setOpaque(true);
        getContentPane().add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 320));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMouseClicked
        if (!btnCancel.isEnabled()) {
            return;
        }
        this.btnMouseClicked(btnCancel);
        if (!hp.isDone()) {
            hp.cancel(true);
            hp.setStarted(true);
        }
        btnCancel.setEnabled(false);
        this.btnCancelMouseReleased(evt);
    }//GEN-LAST:event_btnCancelMouseClicked

    private void btnCancelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMouseEntered
        if (!btnCancel.isEnabled()) {
            return;
        }
        this.btnMouseEntered(btnCancel);
        System.out.println("entered");
    }//GEN-LAST:event_btnCancelMouseEntered

    private void btnCancelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMouseExited
        this.btnMouseExited(btnCancel);
        System.out.println("exited");
    }//GEN-LAST:event_btnCancelMouseExited

    private void btnCancelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMouseReleased
        this.btnMouseExited(btnCancel);
        System.out.println("released");
    }//GEN-LAST:event_btnCancelMouseReleased

    private void btnMouseEntered(JLabel lbl) {
        Color bg = new Color(155, 155, 155);
        lbl.setBackground(bg);
    }

    private void btnMouseClicked(JLabel lbl) {
        Color bg = new Color(112, 112, 112);
        lbl.setBackground(bg);
    }

    private void btnMouseExited(JLabel lbl) {
        Color bg = new Color(204, 204, 204);
        lbl.setBackground(bg);
    }    
    
    private void setProgress(int p) {
        if (p > 100) {
            p = 100;
        }
        float percent = p / 100.0f;
        lblProgressBar.setSize((int) (percent * lblProgressBar.getIcon().getIconWidth()), lblProgressBar.getHeight());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnCancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblDestination;
    private javax.swing.JLabel lblOrigin;
    private javax.swing.JLabel lblProgressBar;
    private javax.swing.JLabel lblProgressBarBg;
    private javax.swing.JLabel lblStatus;
    // End of variables declaration//GEN-END:variables
}
