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
public class PersonTableModel extends AbstractTableModel{
    
    private static String[] columns = {"id","Name","Genre"};
    
    private List<Person> persons;
    
    public PersonTableModel(){
        persons = new ArrayList<>();
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public int getRowCount() {
        return persons.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Person selected = persons.get(rowIndex);
        switch(columnIndex){
            case 0:
                return selected.getId();
            case 1:
                return selected.getName();
            case 2:
                return selected.getGenre().getName();
            default:
                return "Not found";
        }
    }
}
