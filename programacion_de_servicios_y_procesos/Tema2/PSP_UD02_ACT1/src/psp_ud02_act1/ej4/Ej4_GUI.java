/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package psp_ud02_act1.ej4;

import psp_ud02_act1.ej3.*;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Vespertino
 */
public class Ej4_GUI extends javax.swing.JFrame {

    /**
     * Creates new form ej1_GUI
     */
    public Ej4_GUI() {
        initComponents();
        initCustom();
    }
    private void initCustom(){
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            initWindows();
        } else if (os.contains("nix") || os.contains("nux")) {
            initLinux();
        }
        initAppButton();
    }
    
    private void initAppButton(){
        appButton.addActionListener((ActionEvent e) -> {
            try {
                ProcessBuilder pb = new ProcessBuilder("java", "-jar", "Output.jar");
                pb.start();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }
    
    private void initWindows(){
        initNotepadButtonWin();
        initChromeButtonWin();
        
        initCommandButtonWin();
    }
    
    private void initLinux(){
        initNotepadButtonLinux();
        initChromeButtonLinux();
        initCommandButtonLinux();
    }
    private void initNotepadButtonWin(){
        notepadButton.addActionListener((ActionEvent e) -> {
            try {
                ProcessBuilder pb = new ProcessBuilder("notepad");
                pb.start();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }
    
    private void initChromeButtonWin(){
        chromeButton.addActionListener((ActionEvent e) -> {
            try {
                ProcessBuilder pb = new ProcessBuilder("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
                pb.start();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }
    
    private void initCommandButtonWin() {
        commandButton.addActionListener((ActionEvent e) -> {
            String command = JOptionPane.showInputDialog("Ingrese el comando:");
            System.out.println(command);
            if (command != null) {
                if(!command.isBlank()){
                    executeCommand("cmd", "/c",command);
                    return;
                }
            }
            executeCommand("cmd", "/c","dir","C:"); // Comando por defecto: listar contenido de la carpeta C:
        });
    }
    
    private void initNotepadButtonLinux() {
        notepadButton.addActionListener((ActionEvent e) -> {
            try {
                ProcessBuilder pb = new ProcessBuilder("gedit");
                pb.start();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }

    private void initChromeButtonLinux() {
        chromeButton.addActionListener((ActionEvent e) -> {
            try {
                ProcessBuilder pb = new ProcessBuilder("google-chrome");
                pb.start();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }

    private void initCommandButtonLinux() {
        commandButton.addActionListener((ActionEvent e) -> {
            String command = JOptionPane.showInputDialog("Ingrese el comando:");
            System.out.println(command);
            if (command != null && !command.isBlank()) {
                executeCommand("sh", "-c", command);
            } else {
                executeCommand("sh", "-c", "ls");
            }
        });
    }
    
    private void executeCommand(String... command) {
        Scanner scanner = null;
        BufferedWriter writer = null;
        try {
            ProcessBuilder pb = new ProcessBuilder(command);
            pb.redirectErrorStream(true);
            Process process = pb.start();

            // Leer la salida del proceso
            InputStream inputStream = process.getInputStream();
            scanner = new Scanner(new InputStreamReader(inputStream));
            StringBuilder output = new StringBuilder();
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                output.append(line).append("\n");
            }

            // Guardar la salida en un archivo
            String outputPath = "outputEj3.txt";
            try{
                writer = new BufferedWriter(new FileWriter(outputPath));
                writer.write(output.toString());
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            // Notificar que la ejecución ha terminado
            JOptionPane.showMessageDialog(this, "Comando ejecutado.\nLa salida se ha guardado en " + outputPath);
            
            
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally{
            try {
                scanner.close();
                writer.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        notepadButton = new javax.swing.JButton();
        chromeButton = new javax.swing.JButton();
        appButton = new javax.swing.JButton();
        commandButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(400, 100));

        panelPrincipal.setBackground(new java.awt.Color(255, 153, 255));
        panelPrincipal.setMaximumSize(this.getSize()
        );
        panelPrincipal.setPreferredSize(this.getSize()
        );
        panelPrincipal.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 10));

        notepadButton.setText("Notepad");
        panelPrincipal.add(notepadButton);

        chromeButton.setText("Chrome");
        panelPrincipal.add(chromeButton);

        appButton.setText("App");
        panelPrincipal.add(appButton);

        commandButton.setText("Comando");
        panelPrincipal.add(commandButton);

        getContentPane().add(panelPrincipal, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Ej4_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ej4_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ej4_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ej4_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Ej4_GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton appButton;
    private javax.swing.JButton chromeButton;
    private javax.swing.JButton commandButton;
    private javax.swing.JButton notepadButton;
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables
}
