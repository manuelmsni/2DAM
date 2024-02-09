/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testhibernate20.view.component;

import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Vespertino
 */
public class LabelledInputPanel extends JPanel{
    private JLabel label;
    private JTextField textField;

    public LabelledInputPanel(String labelText, String placeholderText) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // BoxLayout con orientación Y_AXIS

        label = new JLabel(labelText);
        textField = new JTextField(20);
        textField.setText(placeholderText);
        textField.setAlignmentX(LEFT_ALIGNMENT); // Alinea el texto a la izquierda

        add(label);
        add(textField);
    }
    
    public void setEnabled(boolean bool){
        textField.setEnabled(bool);
    }

}
