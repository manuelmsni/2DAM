/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testhibernate20.coltroller.persistence;

import com.mycompany.testhibernate20.model.Genre;
import com.mycompany.testhibernate20.model.Person;
import jakarta.persistence.Persistence;
import java.util.List;

/**
 *
 * @author Vespertino
 */
public class MainController {
    
    private PersonJpaController personController;
    private GenreJpaController genreController;
    
    private static MainController instance;
    
    public static MainController getInstance(){
        if( instance == null ) instance = new MainController();
        return instance;
    }
    
    public MainController(){
        personController = new PersonJpaController(Persistence.createEntityManagerFactory("testHibernate"));
        genreController = new GenreJpaController(Persistence.createEntityManagerFactory("testHibernate"));
    }
    
    public void addPerson(Person p){
        personController.create(p);
    }
    
    public void addGenre(Genre g){
        genreController.create(g);
    }
    
    public List<Genre> getGenres(){
        return genreController.findGenreEntities();
    }
}
