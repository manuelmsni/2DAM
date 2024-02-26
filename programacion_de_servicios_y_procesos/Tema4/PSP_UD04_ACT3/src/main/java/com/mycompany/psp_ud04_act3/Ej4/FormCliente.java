/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.psp_ud04_act3.Ej4;

/**
 *
 * @author manuelmsni
 */
public class FormCliente extends javax.swing.JFrame {

    /**
     * Creates new form FormCliente
     */
    public FormCliente() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        puerto = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jTextField3 = new javax.swing.JTextField();
        host = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        enviar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jTextField5 = new javax.swing.JTextField();
        nombre = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jTextField7 = new javax.swing.JTextField();
        apellidos = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jTextField9 = new javax.swing.JTextField();
        edad = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jTextField11 = new javax.swing.JTextField();
        sexo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setMinimumSize(new java.awt.Dimension(155, 90));
        jPanel1.setPreferredSize(new java.awt.Dimension(234, 85));
        jPanel1.setLayout(new java.awt.GridLayout(2, 1));

        jPanel4.setLayout(new java.awt.BorderLayout());

        jTextField1.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextField1.setText("Puerto:");
        jTextField1.setPreferredSize(new java.awt.Dimension(80, 22));
        jPanel4.add(jTextField1, java.awt.BorderLayout.WEST);

        puerto.setPreferredSize(new java.awt.Dimension(150, 22));
        jPanel4.add(puerto, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel4);

        jPanel5.setLayout(new java.awt.BorderLayout());

        jTextField3.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextField3.setText("Host:");
        jTextField3.setPreferredSize(new java.awt.Dimension(80, 22));
        jPanel5.add(jTextField3, java.awt.BorderLayout.WEST);

        host.setPreferredSize(new java.awt.Dimension(150, 22));
        jPanel5.add(host, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel5);

        getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);

        enviar.setText("Enviar");
        enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarActionPerformed(evt);
            }
        });
        jPanel3.add(enviar);

        getContentPane().add(jPanel3, java.awt.BorderLayout.SOUTH);

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setMinimumSize(new java.awt.Dimension(200, 0));
        jPanel2.setName(""); // NOI18N
        jPanel2.setPreferredSize(new java.awt.Dimension(200, 0));
        jPanel2.setLayout(new java.awt.GridLayout(5, 1));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DATOS PERSONALES");
        jLabel1.setPreferredSize(new java.awt.Dimension(200, 16));
        jPanel2.add(jLabel1);

        jPanel6.setLayout(new java.awt.BorderLayout());

        jTextField5.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextField5.setText("Nombre:");
        jTextField5.setPreferredSize(new java.awt.Dimension(80, 22));
        jPanel6.add(jTextField5, java.awt.BorderLayout.WEST);

        nombre.setPreferredSize(new java.awt.Dimension(150, 22));
        jPanel6.add(nombre, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel6);

        jPanel7.setLayout(new java.awt.BorderLayout());

        jTextField7.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextField7.setText("Apellidos:");
        jTextField7.setPreferredSize(new java.awt.Dimension(80, 22));
        jPanel7.add(jTextField7, java.awt.BorderLayout.WEST);

        apellidos.setPreferredSize(new java.awt.Dimension(150, 22));
        jPanel7.add(apellidos, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel7);

        jPanel8.setLayout(new java.awt.BorderLayout());

        jTextField9.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextField9.setText("Edad:");
        jTextField9.setPreferredSize(new java.awt.Dimension(80, 22));
        jPanel8.add(jTextField9, java.awt.BorderLayout.WEST);

        edad.setPreferredSize(new java.awt.Dimension(150, 22));
        jPanel8.add(edad, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel8);

        jPanel9.setLayout(new java.awt.BorderLayout());

        jTextField11.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextField11.setText("Sexo");
        jTextField11.setPreferredSize(new java.awt.Dimension(80, 22));
        jPanel9.add(jTextField11, java.awt.BorderLayout.WEST);

        sexo.setPreferredSize(new java.awt.Dimension(150, 22));
        jPanel9.add(sexo, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel9);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void enviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarActionPerformed
        // Recoger datos del formulario
        String nombreStr = nombre.getText();
        String apellidosStr = apellidos.getText();
        int edadInt = Integer.parseInt(edad.getText()); // Asegúrate de manejar NumberFormatException
        String sexoStr = sexo.getText();
        Persona persona = new Persona(nombreStr, apellidosStr, edadInt, sexoStr);

        // Datos del servidor
        String hostStr = host.getText();
        int puertoInt = Integer.parseInt(puerto.getText()); // Igualmente, manejar NumberFormatException

        // Crear y usar el cliente para enviar el objeto
        Cliente cliente = new Cliente(hostStr, puertoInt);
        cliente.enviarDatos(persona);
    }//GEN-LAST:event_enviarActionPerformed

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
            java.util.logging.Logger.getLogger(FormCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellidos;
    private javax.swing.JTextField edad;
    private javax.swing.JButton enviar;
    private javax.swing.JTextField host;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField puerto;
    private javax.swing.JTextField sexo;
    // End of variables declaration//GEN-END:variables
}