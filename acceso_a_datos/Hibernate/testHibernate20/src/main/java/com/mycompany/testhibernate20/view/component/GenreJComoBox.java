/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testhibernate20.view.component;

import com.mycompany.testhibernate20.coltroller.persistence.MainController;
import com.mycompany.testhibernate20.model.Genre;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author Vespertino
 */
public class GenreJComoBox extends JComboBox<Genre> {

    public GenreJComoBox() {
        super(new DefaultComboBoxModel<Genre>((Vector<Genre>) MainController.getInstance().getGenres()));
    }
    
}
