package GUI;

import com.mycompany.bancodominio.Cliente;
import com.mycompany.bancodominio.Usuario;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author USER
 */
public class frmMenuUsuario extends javax.swing.JFrame {

    Cliente cliente;

    /**
     * Creates new form frmInicioSesion
     */
    public frmMenuUsuario() {
        initComponents();
    }

    /**
     * Creates new form frmInicioSesion
     * @param cliente
     */
    public frmMenuUsuario(Cliente cliente) {
        initComponents();
        this.cliente = cliente;
        labelBienvenida.setText("Bienvenido " + cliente.getNombre());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonPerfil = new javax.swing.JButton();
        labelBienvenida = new javax.swing.JLabel();
        botonTransferir = new javax.swing.JButton();
        botonDepositar = new javax.swing.JButton();
        botonHistorial = new javax.swing.JButton();
        botonRetirar = new javax.swing.JButton();
        labelFondo1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(1084, 773));
        setMinimumSize(new java.awt.Dimension(1084, 773));
        setResizable(false);
        setSize(new java.awt.Dimension(1084, 773));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonPerfil.setContentAreaFilled(false);
        botonPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPerfilActionPerformed(evt);
            }
        });
        getContentPane().add(botonPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 0, 110, 110));

        labelBienvenida.setFont(new java.awt.Font("Segoe UI", 3, 48)); // NOI18N
        labelBienvenida.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(labelBienvenida, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, 560, 80));

        botonTransferir.setContentAreaFilled(false);
        botonTransferir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonTransferirActionPerformed(evt);
            }
        });
        getContentPane().add(botonTransferir, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 150, 130));

        botonDepositar.setContentAreaFilled(false);
        botonDepositar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDepositarActionPerformed(evt);
            }
        });
        getContentPane().add(botonDepositar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 130, 150, 130));

        botonHistorial.setContentAreaFilled(false);
        botonHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonHistorialActionPerformed(evt);
            }
        });
        getContentPane().add(botonHistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, 110, 110));

        botonRetirar.setContentAreaFilled(false);
        botonRetirar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRetirarActionPerformed(evt);
            }
        });
        getContentPane().add(botonRetirar, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 140, 110, 110));

        labelFondo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Menú de Usuario.png"))); // NOI18N
        labelFondo1.setText("jLabel1");
        labelFondo1.setMaximumSize(new java.awt.Dimension(1080, 773));
        labelFondo1.setMinimumSize(new java.awt.Dimension(1080, 773));
        labelFondo1.setPreferredSize(new java.awt.Dimension(1080, 773));
        getContentPane().add(labelFondo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 720));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPerfilActionPerformed
        frmPerfil frmPerfil = new frmPerfil(cliente);
        frmPerfil.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_botonPerfilActionPerformed

    private void botonTransferirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonTransferirActionPerformed
        frmTransferencia frmtransferencial = new frmTransferencia(cliente);
        frmtransferencial.setVisible(true);
        this.setVisible(false);    }//GEN-LAST:event_botonTransferirActionPerformed

    private void botonDepositarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDepositarActionPerformed
        frmDepositar frmDepositar = new frmDepositar(cliente);
        frmDepositar.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_botonDepositarActionPerformed

    private void botonHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonHistorialActionPerformed
        
    }//GEN-LAST:event_botonHistorialActionPerformed

    private void botonRetirarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRetirarActionPerformed
        frmRetirarMenu frmRetirarMenu = new frmRetirarMenu(cliente);
        frmRetirarMenu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_botonRetirarActionPerformed

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
            java.util.logging.Logger.getLogger(frmMenuUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMenuUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMenuUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMenuUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMenuUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonDepositar;
    private javax.swing.JButton botonHistorial;
    private javax.swing.JButton botonPerfil;
    private javax.swing.JButton botonRetirar;
    private javax.swing.JButton botonTransferir;
    private javax.swing.JLabel labelBienvenida;
    private javax.swing.JLabel labelFondo1;
    // End of variables declaration//GEN-END:variables
}
