/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import com.mycompany.bancodominio.Cliente;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class frmCrearUsuario extends javax.swing.JFrame {

    Cliente cliente = new Cliente();

    /**
     * Creates new form frmInicioSesion
     */
    public frmCrearUsuario() {
        initComponents();
        textNombre.setBackground(new java.awt.Color(0, 0, 0, 1));
        textApellidoPaterno.setBackground(new java.awt.Color(0, 0, 0, 1));
        textApellidoMaterno.setBackground(new java.awt.Color(0, 0, 0, 1));
        textFechaNacimiento.setBackground(new java.awt.Color(0, 0, 0, 1));
    }

    /**
     * Creates new form frmInicioSesion
     */
    public frmCrearUsuario(Cliente cliente) {
        initComponents();
        this.cliente = cliente;
        textNombre.setBackground(new java.awt.Color(0, 0, 0, 1));
        textNombre.setText(cliente.getNombre());
        textApellidoPaterno.setBackground(new java.awt.Color(0, 0, 0, 1));
        textApellidoPaterno.setText(cliente.getApellidoPaterno());
        textApellidoMaterno.setBackground(new java.awt.Color(0, 0, 0, 1));
        textApellidoMaterno.setText(cliente.getApellidoMaterno());
        textFechaNacimiento.setBackground(new java.awt.Color(0, 0, 0, 1));
        textFechaNacimiento.setText(cliente.getFechaNacimiento());
        textFechaNacimiento.setEditable(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonContinuar = new javax.swing.JButton();
        botonRegresar = new javax.swing.JButton();
        botonCalendario = new javax.swing.JButton();
        textNombre = new javax.swing.JTextField();
        textFechaNacimiento = new javax.swing.JTextField();
        textApellidoPaterno = new javax.swing.JTextField();
        textApellidoMaterno = new javax.swing.JTextField();
        labelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(1084, 773));
        setMinimumSize(new java.awt.Dimension(1084, 773));
        setResizable(false);
        setSize(new java.awt.Dimension(1084, 773));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonContinuar.setContentAreaFilled(false);
        botonContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonContinuarActionPerformed(evt);
            }
        });
        getContentPane().add(botonContinuar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 650, 300, 60));

        botonRegresar.setContentAreaFilled(false);
        botonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegresarActionPerformed(evt);
            }
        });
        getContentPane().add(botonRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 680, 170, 60));

        botonCalendario.setContentAreaFilled(false);
        botonCalendario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCalendarioActionPerformed(evt);
            }
        });
        getContentPane().add(botonCalendario, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 540, 60, 50));

        textNombre.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        textNombre.setForeground(new java.awt.Color(102, 102, 102));
        textNombre.setToolTipText("");
        textNombre.setBorder(null);
        textNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNombreActionPerformed(evt);
            }
        });
        getContentPane().add(textNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 140, 450, 50));

        textFechaNacimiento.setEditable(false);
        textFechaNacimiento.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        textFechaNacimiento.setForeground(new java.awt.Color(102, 102, 102));
        textFechaNacimiento.setToolTipText("");
        textFechaNacimiento.setBorder(null);
        textFechaNacimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFechaNacimientoActionPerformed(evt);
            }
        });
        getContentPane().add(textFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 540, 400, 40));

        textApellidoPaterno.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        textApellidoPaterno.setForeground(new java.awt.Color(102, 102, 102));
        textApellidoPaterno.setToolTipText("");
        textApellidoPaterno.setBorder(null);
        getContentPane().add(textApellidoPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 260, 450, 40));

        textApellidoMaterno.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        textApellidoMaterno.setForeground(new java.awt.Color(102, 102, 102));
        textApellidoMaterno.setToolTipText("");
        textApellidoMaterno.setBorder(null);
        getContentPane().add(textApellidoMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 400, 450, 40));

        labelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Crear Usuario 1.png"))); // NOI18N
        labelFondo.setText("jLabel1");
        labelFondo.setMaximumSize(new java.awt.Dimension(1080, 773));
        labelFondo.setMinimumSize(new java.awt.Dimension(1080, 773));
        labelFondo.setPreferredSize(new java.awt.Dimension(1080, 773));
        getContentPane().add(labelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 750));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonCalendarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCalendarioActionPerformed
        cliente.setNombre(textNombre.getText());
        cliente.setApellidoPaterno(textApellidoPaterno.getText());
        cliente.setApellidoMaterno(textApellidoMaterno.getText());
        cliente.setFechaNacimiento(textFechaNacimiento.getText());
        frmCalendario frmCalendario = new frmCalendario(cliente);
        frmCalendario.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_botonCalendarioActionPerformed

    private void botonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarActionPerformed
        frmInicioSesion frmInicio = new frmInicioSesion();
        frmInicio.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_botonRegresarActionPerformed

    private void botonContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonContinuarActionPerformed
        if (textNombre.getText().equalsIgnoreCase("") || textApellidoPaterno.getText().equalsIgnoreCase("") || textApellidoMaterno.getText().equalsIgnoreCase("")
                || textFechaNacimiento.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "No debe haber ningún campo vacio", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            cliente.setNombre(textNombre.getText());
            cliente.setApellidoPaterno(textApellidoPaterno.getText());
            cliente.setApellidoMaterno(textApellidoMaterno.getText());
            cliente.setFechaNacimiento(textFechaNacimiento.getText());
            frmCrearUsuario2 frmUsuario2 = new frmCrearUsuario2(cliente);
            frmUsuario2.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_botonContinuarActionPerformed

    private void textFechaNacimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFechaNacimientoActionPerformed
        textFechaNacimiento.setEditable(false);
    }//GEN-LAST:event_textFechaNacimientoActionPerformed

    private void textNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNombreActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCalendario;
    private javax.swing.JButton botonContinuar;
    private javax.swing.JButton botonRegresar;
    private javax.swing.JLabel labelFondo;
    private javax.swing.JTextField textApellidoMaterno;
    private javax.swing.JTextField textApellidoPaterno;
    private javax.swing.JTextField textFechaNacimiento;
    private javax.swing.JTextField textNombre;
    // End of variables declaration//GEN-END:variables
}
