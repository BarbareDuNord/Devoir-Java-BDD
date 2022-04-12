/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import Entity.Employe;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author jeang
 */
public class ModelEmploye extends AbstractTableModel {
    private String[] nomsColonnes = {"Numéro", "Prénom","Date","Temps"};
    private Vector<String[]> rows;

    @Override
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public int getColumnCount() {
        return nomsColonnes.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return rows.get(rowIndex)[columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return nomsColonnes[column]; 
    }
    
    public void loadDatas(ArrayList<Employe> lesEmployes)
    {
        rows = new Vector<>();
        for(Employe emp : lesEmployes)
        {
            rows.add(new String[]{String.valueOf(emp.getIdEmploye()),emp.getNomEmploye()});
        }
        fireTableChanged(null);
    }
}
