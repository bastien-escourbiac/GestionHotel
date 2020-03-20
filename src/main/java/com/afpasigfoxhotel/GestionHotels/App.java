package com.afpasigfoxhotel.GestionHotels;


import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.DAOFactory;
import model.Categorie;
import model.Collection;
import model.Collectionable;
import model.TypeHotel;
import utils.ConnexionHProject;
import dao.DAOCategorie;


import java.util.*; 
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException  // On crée la connexion
    {
        
    	DAOFactory monUsineDAO = new DAOFactory();
        
        //insérer id plus params car script not in serial
        Categorie cat = new Categorie(6,"triple");
        Categorie cat1 = new Categorie(6,"Triple");
        Categorie cat2 = new Categorie(7,"quadruple");
        Categorie cat3 = new Categorie(8,"quintuple");
        Categorie cat4 = new Categorie(2,"coucou");
        Categorie cat5 = new Categorie(10,"cedric");
        
        TypeHotel t1 = new TypeHotel(16,"t1");
            
        /***********************GENERICITE *****************************/
        //INSERT
        //System.out.println(monUsineDAO.getDAO(DAOFactory.DAOCategorie).create(cat5));
        //System.out.println(monUsineDAO.getDAO(DAOFactory.DAOTypeHotel).create(t1));
        
        //bruno version
        //System.out.println(monUsineDAO.getDAO(DAOFactory.DAOCategorie).create(cat1));
        
        
        //DELETE
        //monUsineDAO.getDAO(DAOFactory.DAOCategorie).delete(1);
        
        //UPDATE
        //System.out.println(monUsineDAO.getDAO(DAOFactory.DAOCategorie).update(cat4));
        
        //FINDbyId      
        /*Optional<Categorie> optionalCategorie = monUsineDAO.getDAO(DAOFactory.DAOCategorie).findById(3);
        if (optionalCategorie.isPresent()) { 
        	System.out.println(optionalCategorie.get().getNomCat());
        }*/
        
        //FINDALL
        
        //Appel de ma fonction findAll
        Collection<Categorie> collectionCategorie = monUsineDAO.getDAO(DAOFactory.DAOCategorie).findAll();
        Collection<TypeHotel> collectionTypeHotel = monUsineDAO.getDAO(DAOFactory.DAOTypeHotel).findAll();
        
        
        //Je stock cette collection dans le HashMap
        /*
        Map<Integer, Categorie> MapCategorie = collectionCategorie.getCollection();
        Map<Integer, TypeHotel> MapTypeHotel = collectionTypeHotel.getCollection(); 
        
        Integer collectionId = 1;
        Map<Integer, Object> map = new HashMap<>();
        for (Map.Entry<Integer, Categorie> categorie : collectionCategorie.getCollection().entrySet())
        {
        	map.put(collectionId, categorie);
        	collectionId++;
        }    

        for (Map.Entry<Integer, TypeHotel> typeHotel : collectionTypeHotel.getCollection().entrySet())
        {
        	map.put(collectionId, typeHotel);
        	collectionId++;
        }
        
        map.forEach((id, object) -> System.out.println(id + " " + object.toString()));
		
        System.out.println("--------------------");
         */
        List<Collection<?>> collectionList = new ArrayList<Collection<?>>();
        collectionList.add(collectionCategorie);
        collectionList.add(collectionTypeHotel); 
        
        collectionList.stream().map(e -> e.getCollection()).forEach(System.out::println);

        System.out.println("--------------------");
        
        System.out.println(collectionList);
        
        //List<Categorie> CategorieList = new ArrayList<Categorie>(MapCategorie.values());
        
        //CategorieList.stream().map(e -> e.getNomCat()).forEach(System.out::println);
       
        
        
        
      
    }
}
