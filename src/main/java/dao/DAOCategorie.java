package dao;

import java.sql.PreparedStatement;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import model.Categorie;
import utils.ConnexionHProject;



public class DAOCategorie extends DAO<Categorie> {
	//Csteur
	public DAOCategorie(ConnexionHProject pCxion) {
		super(pCxion);		
	}
	
	@Override
	//to do throws exception
	public Categorie create(Categorie c) {
		
			//Requête à exécuter
			String sql = "INSERT INTO categorie (nomcat) VALUES (?)";
			 try {
				 //Préparation de la requête
				 PreparedStatement stmt 	= getCxion().getC().prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
				 
				 //Modification à apporter aux attributs de l'objet dans les champs
				 stmt.setString(1, c.getNomCat());
				 //exécution de la requete
				 stmt.executeUpdate();
			 } catch  (SQLException e) {
					
				} 
			return c;
			}
	


	@Override
	public model.Categorie update(model.Categorie objACReer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int idADelete) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public model.Categorie findById(int idATrouver) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<model.Categorie> findAll() {
		// TODO Auto-generated method stub
		return null;
	}


}
