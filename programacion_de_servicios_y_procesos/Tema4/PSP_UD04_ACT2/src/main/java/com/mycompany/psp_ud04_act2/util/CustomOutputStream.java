/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.psp_ud04_act2.util;

import java.io.IOException;
import java.io.OutputStream;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
/**
 *
 * @author manuelmsni
 */

public class CustomOutputStream extends OutputStream {
    private JTextArea output;

    public CustomOutputStream(JTextArea output) {
        this.output = output;
    }

    @Override
    public void write(int b) throws IOException {
        SwingUtilities.invokeLater(() -> output.append(String.valueOf((char) b)));
    }
    
    public void printLine(String msg) throws IOException{
        for(Byte b :msg.getBytes()){
            write(b);
        }
        write(System.getProperty("line.separator").getBytes());
    }   
    

}
