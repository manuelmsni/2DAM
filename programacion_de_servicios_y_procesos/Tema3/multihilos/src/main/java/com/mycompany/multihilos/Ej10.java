/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.multihilos;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author manuelmsni
 */
public class Ej10 {
    
    public static void main(String[] args){
        JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int seleccion = fileChooser.showOpenDialog(null);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            String directorioSeleccionado = fileChooser.getSelectedFile().getPath();

            new ListarDirectorio(directorioSeleccionado).start();
        } else {
            System.out.println("Selección cancelada!");
        }
    }
    
    public static class ListarDirectorio extends Thread {
        
        private String rutaDirectorio;
        
        private File directorio;
        
        private List<String> archivos;
        
        private Object lock;
        
        private int lastHash;
        
        public ListarDirectorio(String rutaDirectorio){
            this.rutaDirectorio = rutaDirectorio;
            lastHash = 0;
            directorio = new File(rutaDirectorio);
            lock = new Object();
        }
        
        @Override
        public void run(){
            if (!directorio.isDirectory()) return;
            while(!isInterrupted()){
                synchronized(lock){
                    updateContent();
                    int tempHash = hashCode();
                    if(lastHash != tempHash){
                        lastHash = tempHash;
                        System.out.println(toString());
                    }
                    try {
                        sleep(3000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Ej10.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        
        private void updateContent(){
            archivos = Arrays.asList(directorio.list());
        }
        
        public String toString(){
            StringBuilder sb = new StringBuilder();
            sb.append(rutaDirectorio + System.getProperty("line.separator"));
            archivos.forEach(f->{sb.append(" | - " + f + System.getProperty("line.separator"));});
            return sb.toString();
        }
        
        @Override
        public int hashCode(){
            return archivos.hashCode();
        }
    }
}
