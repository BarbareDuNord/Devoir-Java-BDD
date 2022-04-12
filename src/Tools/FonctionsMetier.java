/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import Entity.Employe;
import Entity.Rayon;
import Entity.Secteur;
import Entity.Travailler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jbuffeteau
 */
public class FonctionsMetier
{
    private PreparedStatement ps;
    private ResultSet rs;
    private Connection cnx;

    public FonctionsMetier()
    {
        cnx = ConnexionBDD.getCnx();
    }
    
    public ArrayList<Secteur> GetAllSecteurs(int idSecteur, String nomSecteur)
    {
        ArrayList<Secteur> lesSecteurs = new ArrayList<>();
        try {
            Connection cnx = ConnexionBDD.getCnx();
            PreparedStatement ps = cnx.prepareStatement("SELECT numS, nomS FROM secteur");
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Secteur sec = new Secteur(rs.getInt("numS"),rs.getString("nomS"));
                lesSecteurs.add(sec);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesSecteurs;
    }
    
    public ArrayList<Employe> GetAllEmployes()
    {
        ArrayList<Employe> lesEmployes = new ArrayList<>();
        try {
            Connection cnx = ConnexionBDD.getCnx();
            PreparedStatement ps = cnx.prepareStatement("SELECT numE, prenomE FROM employe");
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Employe emp = new Employe(rs.getInt("numE"),rs.getString("prenomE"));
                lesEmployes.add(emp);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesEmployes;
    }
    
    public ArrayList<Rayon> GetAllRayonsByIdsecteur(int numSecteur)
    {
        ArrayList<Rayon> lesRayons = new ArrayList<>();
        try {
            Connection cnx = ConnexionBDD.getCnx();
            PreparedStatement ps = cnx.prepareStatement("SELECT numR, nomR FROM rayon WHERE numR = numSecteur");
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Rayon ray = new Rayon(rs.getInt("numR"), rs.getString("nomR"));
                lesRayons.add(ray);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesRayons;
    }
    
    public ArrayList<Travailler> GetAllTravailler(int numRayon)
    {
        ArrayList<Travailler> lesTravailler = new ArrayList<>();
        try {
            Connection cnx = ConnexionBDD.getCnx();
            PreparedStatement ps = cnx.prepareStatement("SELECT codeE, codeR, temps FROM travailler");
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Travailler trav = new Travailler(rs.getInt("codeE"), rs.getString("codeR"));
                lesTravailler.add(trav);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesTravailler;
    }
    
    public int GetIdEmployeByNom(String nomEmploye)
    {
        ArrayList<Travailler> lesTravailler = new ArrayList<>();
        try {
            Connection cnx = ConnexionBDD.getCnx();
            PreparedStatement ps = cnx.prepareStatement("SELECT codeE, codeR, temps FROM travailler");
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Travailler trav = new Travailler(rs.getInt("codeE"), rs.getString("codeR"));
                lesTravailler.add(trav);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesTravailler;
    }
    
    public int TotalHeuresRayon(int numRayon)
    {
        ArrayList<Rayon> lesTravailler = new ArrayList<>();
        try {
            Connection cnx = ConnexionBDD.getCnx();
            PreparedStatement ps = cnx.prepareStatement("SELECT codeE, codeR, temps FROM travailler");
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Employe emp = new Employe(rs.getInt("codeE"), rs.getString("prenomE"));
                Travailler trav = new Travailler(rs.getInt("codeE"), rs.getString("codeR"),);
                lesTravailler.add(trav);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesTravailler;
    }
    
    public void ModifierTemps(int codeEmploye, int CodeRayon, String uneDate,int nouveauTemps)
    {
        
    }
    
    public void InsererTemps(int codeEmploye, int CodeRayon,int nouveauTemps)
    {
        
    }
}
