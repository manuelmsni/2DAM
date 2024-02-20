/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.psp_ud04_act2.view;

import com.mycompany.psp_ud04_act2.ejercicios.Ej2;
import com.mycompany.psp_ud04_act2.ejercicios.Ej4;
import com.mycompany.psp_ud04_act2.util.ThreadOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author manuelmsni
 */
public class Ej4VistaSevidor extends javax.swing.JFrame {
    
    private static OutputStream out;

    /**
     * Creates new form VistaEj2
     */
    public Ej4VistaSevidor() {
        initComponents();
    }
    
    public void activateServer(int portNumber, String messaje, int maxClients){
        
        OutputStream os = new ThreadOutputStream(output);
        
        Thread server = new Thread(new Ej4.Servidor(portNumber, messaje, maxClients, os));
        
        server.start();
    }
    
    public static void createClient(String host, int portNumber){
        Ej4VistaCliente c = new Ej4VistaCliente();
        c.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        input = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        nClients = new javax.swing.JSpinner();
        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        port = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        activate = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        output = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.Y_AXIS));

        jLabel1.setText("PSP SERVER");
        jPanel1.add(jLabel1);

        jPanel3.add(jPanel1);

        jPanel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel12.setLayout(new javax.swing.BoxLayout(jPanel12, javax.swing.BoxLayout.Y_AXIS));

        jLabel2.setText("CONFIG");
        jPanel4.add(jLabel2);

        jPanel12.add(jPanel4);

        jLabel4.setText("Income Messaje");
        jPanel5.add(jLabel4);

        input.setPreferredSize(new java.awt.Dimension(400, 22));
        jPanel5.add(input);

        jPanel12.add(jPanel5);

        jPanel6.setLayout(new java.awt.GridLayout(1, 2));

        jLabel5.setText("Max. Nº of Clients: ");
        jPanel7.add(jLabel5);

        nClients.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        nClients.setPreferredSize(new java.awt.Dimension(120, 22));
        jPanel7.add(nClients);

        jPanel6.add(jPanel7);

        jLabel6.setText("Port N:");
        jPanel8.add(jLabel6);

        port.setText("6000");
        port.setMinimumSize(new java.awt.Dimension(120, 22));
        port.setPreferredSize(new java.awt.Dimension(120, 22));
        jPanel8.add(port);

        jPanel6.add(jPanel8);

        jPanel12.add(jPanel6);

        activate.setText("ACTIVATE SERVER");
        activate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activateActionPerformed(evt);
            }
        });
        jPanel9.add(activate);

        jPanel12.add(jPanel9);

        jPanel3.add(jPanel12);

        getContentPane().add(jPanel3, java.awt.BorderLayout.NORTH);

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.Y_AXIS));

        jLabel3.setText("STATUS");
        jPanel10.add(jLabel3);

        jPanel2.add(jPanel10);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(520, 400));

        output.setColumns(20);
        output.setRows(5);
        output.setMinimumSize(new java.awt.Dimension(250, 20));
        output.setPreferredSize(new java.awt.Dimension(500, 400));
        jScrollPane1.setViewportView(output);

        jPanel11.add(jScrollPane1);

        jPanel2.add(jPanel11);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void activateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activateActionPerformed
        // TODO add your handling code here:
        try{
            int portNumber = Integer.valueOf(port.getText());
            int clients = ((Number)nClients.getValue()).intValue();
            String messaje = input.getText();
            if(!messaje.isBlank()){
                activateServer(portNumber, messaje, clients);
                for(int i = 0; i < clients; i++){
                    createClient("127.0.0.1", portNumber);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No has introducido un mensaje.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(null, "El puerto no es un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_activateActionPerformed

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
            java.util.logging.Logger.getLogger(Ej4VistaSevidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ej4VistaSevidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ej4VistaSevidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ej4VistaSevidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ej4VistaSevidor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton activate;
    private javax.swing.JTextField input;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner nClients;
    private javax.swing.JTextArea output;
    private javax.swing.JTextField port;
    // End of variables declaration//GEN-END:variables
}
