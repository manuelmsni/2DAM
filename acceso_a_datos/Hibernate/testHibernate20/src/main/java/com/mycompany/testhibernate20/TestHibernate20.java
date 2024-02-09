/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.testhibernate20;

import com.mycompany.testhibernate20.coltroller.persistence.MainController;
import com.mycompany.testhibernate20.model.Genre;
import com.mycompany.testhibernate20.model.Person;
import com.mycompany.testhibernate20.view.MainView;

/**
 *
 * @author Vespertino
 */
public class TestHibernate20 {

    public static void main(String[] args) {
        
        MainView vista = new MainView();
        vista.setVisible(true);
        /*
        Genre g = new Genre("Non binary");
         MainController.getInstance().addGenre(g);
        Person p = new Person("Whatever", g);
        MainController.getInstance().addPerson(p);
        */
    }
}
