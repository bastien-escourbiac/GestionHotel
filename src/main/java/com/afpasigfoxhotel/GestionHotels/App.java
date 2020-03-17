package com.afpasigfoxhotel.GestionHotels;


import utils.ConnexionHProject;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )  // On crée la connexion
    {
        //ouverture de la connexion
        ConnexionHProject connect = new ConnexionHProject("jdbc:postgresql://localhost:5432/db_hotel", "postgres", "afpa123", "org.postgresql.Driver");
        
        
        
        
        
        
        
        // On ferme la connexion
        connect.closeConnection();
    }
}
