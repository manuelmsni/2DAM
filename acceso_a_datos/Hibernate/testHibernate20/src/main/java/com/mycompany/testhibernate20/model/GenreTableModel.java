/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testhibernate20.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Vespertino
 */
public class GenreTableModel extends AbstractTableModel{
    
    private static String[] columns = {"id","Name"};
    
    private List<Genre> genres;
    
    public GenreTableModel(){
        genres = new ArrayList<>();
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public int getRowCount() {
        return genres.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Genre selected = genres.get(rowIndex);
        switch(columnIndex){
            case 0:
                return selected.getId();
            case 1:
                return selected.getName();
            default:
                return "Not found";
        }
    }
    
    public boolean addGenre(Genre g){
        if(g == null || genres == null) return false;
        if(genres.contains(g)) return false;
    }
}

