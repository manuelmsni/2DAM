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

public class ThreadOutputStream extends OutputStream {
    private JTextArea output;

    public ThreadOutputStream(JTextArea output) {
        this.output = output;
    }

    @Override
    public void write(int b) throws IOException {
        SwingUtilities.invokeLater(() -> output.append(String.valueOf((char) b)));
    }  
}
