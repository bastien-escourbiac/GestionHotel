package dao;


import model.Collectionable;
import utils.ConnexionHProject;

public class DAOFactory {
	//Attributs
	public static final int DAOHotel 		= 0;
	public static final int DAOChambre		= 1;
	public static final int DAOTypeHotel	= 2;
	public static final int DAOCategorie	= 3;
	
	private ConnexionHProject cxion = null;
	
	//Constructeur
	public DAOFactory () {
		
	}
	
	public DAOFactory(ConnexionHProject c) {
		this.cxion = c;
	}
	
	//Méthode qui va instancier les différentes DAO
	public DAOPostgreSql getDAO (int i) {
		switch (i) {
			case DAOCategorie : 
				return new DAOCategorie(cxion);
			case DAOChambre : 
				//return new DAOChambre(cxion);
			case DAOTypeHotel : 
				return new DAOTypeHotel(cxion);
			case DAOHotel : 
				//return new DAOHotel(cxion);
			default :
				return null;
		}
	}
	
	

}
