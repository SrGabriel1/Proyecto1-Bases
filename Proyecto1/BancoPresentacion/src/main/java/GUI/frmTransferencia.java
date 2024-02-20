/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import com.mycompany.bancodominio.Cliente;
import com.mycompany.bancodominio.Cuenta;
import com.mycompany.banconegocio.Controlador.Control;
import com.mycompany.bancopersistencia.DTOS.TransferenciaDTO;
import com.mycompany.bancopersistencia.excepciones.persistenciaException;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author yohan
 */
public class frmTransferencia extends javax.swing.JFrame {

    Control controlador = new Control();
    Cliente cliente;
    List<Cuenta> listaCuentas;

    /**
     * Creates new form frmTransferencia
     */
    public frmTransferencia() {
        initComponents();
    }

    public frmTransferencia(Cliente cliente) {
        initComponents();
        this.cliente = cliente;
        textCuentaDestino.setBackground(new java.awt.Color(0, 0, 0, 1));
        textConcepto.setBackground(new java.awt.Color(0, 0, 0, 1));
        textMontoEnviar.setBackground(new java.awt.Color(0, 0, 0, 1));
        textSaldoCuenta.setBackground(new java.awt.Color(0, 0, 0, 1));
        try {
            listaCuentas = new ArrayList<>(controlador.mostrarCuentasDeCliente(cliente.getIdCliente()));
        } catch (persistenciaException ex) {
            Logger.getLogger(frmDepositar.class.getName()).log(Level.SEVERE, null, ex);
        }
        cargarListaCuentas();
    }

    private void cargarListaCuentas() {
        for (int i = 0; i < listaCuentas.size(); i++) {
            comboBoxCuentaOrigen.addItem(listaCuentas.get(i).getNumeroCuenta());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonPerfil = new javax.swing.JButton();
        textConcepto = new javax.swing.JTextField();
        textCuentaDestino = new javax.swing.JTextField();
        textMontoEnviar = new javax.swing.JTextField();
        textSaldoCuenta = new javax.swing.JTextField();
        botonRegresar = new javax.swing.JButton();
        botonTranferencia = new javax.swing.JButton();
        comboBoxCuentaOrigen = new javax.swing.JComboBox<>();
        labelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1080, 773));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonPerfil.setContentAreaFilled(false);
        botonPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPerfilActionPerformed(evt);
            }
        });
        getContentPane().add(botonPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 20, 120, 120));

        textConcepto.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        textConcepto.setForeground(new java.awt.Color(102, 102, 102));
        textConcepto.setToolTipText("");
        textConcepto.setBorder(null);
        getContentPane().add(textConcepto, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 550, 450, 50));

        textCuentaDestino.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        textCuentaDestino.setForeground(new java.awt.Color(102, 102, 102));
        textCuentaDestino.setToolTipText("");
        textCuentaDestino.setBorder(null);
        getContentPane().add(textCuentaDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 330, 450, 50));

        textMontoEnviar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        textMontoEnviar.setForeground(new java.awt.Color(102, 102, 102));
        textMontoEnviar.setToolTipText("");
        textMontoEnviar.setBorder(null);
        getContentPane().add(textMontoEnviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 450, 450, 50));

        textSaldoCuenta.setEditable(false);
        textSaldoCuenta.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        textSaldoCuenta.setForeground(new java.awt.Color(102, 102, 102));
        textSaldoCuenta.setToolTipText("");
        textSaldoCuenta.setBorder(null);
        textSaldoCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textSaldoCuentaActionPerformed(evt);
            }
        });
        getContentPane().add(textSaldoCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 220, 450, 50));

        botonRegresar.setContentAreaFilled(false);
        botonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegresarActionPerformed(evt);
            }
        });
        getContentPane().add(botonRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 690, 200, 50));

        botonTranferencia.setContentAreaFilled(false);
        botonTranferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonTranferenciaActionPerformed(evt);
            }
        });
        getContentPane().add(botonTranferencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 660, 420, 70));

        comboBoxCuentaOrigen.setBackground(new java.awt.Color(153, 204, 255));
        comboBoxCuentaOrigen.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxCuentaOrigenItemStateChanged(evt);
            }
        });
        getContentPane().add(comboBoxCuentaOrigen, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, 450, 60));

        labelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Transferir Dinero.png"))); // NOI18N
        getContentPane().add(labelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, -1, 770));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPerfilActionPerformed
        frmPerfil frmPerfil = new frmPerfil(cliente);
        frmPerfil.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_botonPerfilActionPerformed

    private void botonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarActionPerformed

        frmMenuUsuario frmMenuUsuario = new frmMenuUsuario(cliente);
        frmMenuUsuario.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_botonRegresarActionPerformed
    private void botonTranferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonTranferenciaActionPerformed
        try {
            TransferenciaDTO transferencia = new TransferenciaDTO();
            transferencia.setMonto(Integer.parseInt(textMontoEnviar.getText()));
            transferencia.setCuentaOrigen((String) comboBoxCuentaOrigen.getSelectedItem());
            transferencia.setCuentaDestino(textCuentaDestino.getText());
            transferencia.setConcepto(textConcepto.getText());

            boolean validacion = controlador.transferencia(transferencia);

            if (validacion) {
                frmTransferenciaExito frmTransferenciaExito = new frmTransferenciaExito(transferencia, cliente);
                frmTransferenciaExito.setVisible(true);
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "No se logró hacer la transferencia", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botonTranferenciaActionPerformed

    private void textSaldoCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textSaldoCuentaActionPerformed
        // Obtener el valor seleccionado del ComboBox
        String seleccion = (String) comboBoxCuentaOrigen.getSelectedItem();
        // Actualizar el contenido del TextField con el valor seleccionado del ComboBox
        for (int i = 0; i < listaCuentas.size(); i++) {
            if(seleccion.equalsIgnoreCase(listaCuentas.get(i).getNumeroCuenta())){
                textSaldoCuenta.setText(String.valueOf(listaCuentas.get(i).getSaldo()));
            }
        }
    }//GEN-LAST:event_textSaldoCuentaActionPerformed

    private void comboBoxCuentaOrigenItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxCuentaOrigenItemStateChanged
        // Obtener el valor seleccionado del ComboBox
        String seleccion = (String) comboBoxCuentaOrigen.getSelectedItem();
        // Actualizar el contenido del TextField con el valor seleccionado del ComboBox
        for (int i = 0; i < listaCuentas.size(); i++) {
            if(seleccion.equalsIgnoreCase(listaCuentas.get(i).getNumeroCuenta())){
                textSaldoCuenta.setText(String.valueOf(listaCuentas.get(i).getSaldo()));
            }
        }
    }//GEN-LAST:event_comboBoxCuentaOrigenItemStateChanged

    private void cambiarSaldo(ItemEvent e){
        // Obtener el valor seleccionado del ComboBox
        String seleccion = (String) comboBoxCuentaOrigen.getSelectedItem();
        // Actualizar el contenido del TextField con el valor seleccionado del ComboBox
        for (int i = 0; i < listaCuentas.size(); i++) {
            if(seleccion.equalsIgnoreCase(listaCuentas.get(i).getNumeroCuenta())){
                textSaldoCuenta.setText(String.valueOf(listaCuentas.get(i).getSaldo()));
            }
        }
    }
    
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonPerfil;
    private javax.swing.JButton botonRegresar;
    private javax.swing.JButton botonTranferencia;
    private javax.swing.JComboBox<String> comboBoxCuentaOrigen;
    private javax.swing.JLabel labelFondo;
    private javax.swing.JTextField textConcepto;
    private javax.swing.JTextField textCuentaDestino;
    private javax.swing.JTextField textMontoEnviar;
    private javax.swing.JTextField textSaldoCuenta;
    // End of variables declaration//GEN-END:variables
}
