/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author jeang
 */
import java.util.ArrayList;
import Entity.Rayon;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

public class ModelRayon extends AbstractTableModel{
    private String[] nomsColonnes = {"Numéro", "Nom"};
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
    
    public void loadDatas(ArrayList<Rayon> lesRayons)
    {
        rows = new Vector<>();
        for(Rayon ray : lesRayons)
        {
            rows.add(new String[]{String.valueOf(ray.getIdRayon()),ray.getNomRayon()});
        }
        fireTableChanged(null);
    }
}
