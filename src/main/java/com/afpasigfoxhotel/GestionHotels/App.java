package com.afpasigfoxhotel.GestionHotels;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;

import dao.DAOFactory;
import model.Categorie;
import utils.ConnexionHProject;
import dao.DAOCategorie;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException  // On crée la connexion
    {
        //ouverture de la connexion
        //ConnexionHProject connect = new ConnexionHProject("jdbc:postgresql://localhost:5432/db_hotel", "postgres", "afpa123", "org.postgresql.Driver");
        
    	
    	//ouverture connexion SINGLETON
    	//ConnexionHProject.getInstance();    	
    	
    	
    	
    	DAOFactory monUsineDAO = new DAOFactory();
        
        //insérer id plus params car script not in serial
        Categorie cat = new Categorie(6,"triple");
        Categorie cat1 = new Categorie(6,"Triple");
        Categorie cat2 = new Categorie(7,"quadruple");
        Categorie cat3 = new Categorie(8,"quintuple");
        Categorie cat4 = new Categorie(9,"sextuple");
       
        //CREATE
        //System.out.println(monUsineDAO.getDAO(DAOFactory.DAOCategorie).create(cat2));
        
        //DELETE
        //monUsineDAO.getDAO(DAOFactory.DAOCategorie).delete(6);
        
        //UPDATE
        //System.out.println(monUsineDAO.getDAO(DAOFactory.DAOCategorie).update(cat1));
        
        //FINDBYID
        //System.out.println(monUsineDAO.getDAO(DAOFactory.DAOCategorie).findById(6));
        
        //delete générique
        
        /***********************GENERICITE *****************************/
        //INSERT
        System.out.println(monUsineDAO.getDAO(DAOFactory.DAOCategorie).insert(cat4));
        
        
       
        //FINDbyId dao générique        
        /*
        DAOCategorie c = new DAOCategorie();
        Optional<Categorie> optionalCategorie = c.findById(1);
        if (optionalCategorie.isPresent()) { 
        	System.out.println(optionalCategorie.get().getNomCat());
        }*/
      
        
        
        
        
        
        // On ferme la connexion
        //connect.closeConnection();
    }
}
