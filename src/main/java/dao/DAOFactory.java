package dao;


import utils.ConnexionHProject;

public class DAOFactory {
	//Attributs
	public static final int DAOHotel 		= 0;
	public static final int DAOChambre		= 1;
	public static final int DAOCType		= 2;
	public static final int DAOCategorie	= 3;
	
	private ConnexionHProject cxion = null;
	
	//Constructeur
	public DAOFactory(ConnexionHProject c) {
		this.cxion = c;
	}
	
	//Méthode
	@SuppressWarnings("rawtypes")
	public DAO getDAO (int i) {
		switch (i) {
			case DAOCategorie : 
				return new DAOCategorie(cxion);
			case DAOChambre : 
				return new DAOChambre(cxion);
			case DAOCType : 
				return new DAOCType(cxion);
			case DAOHotel : 
				return new DAOHotel(cxion);
			default :
				return null;
		}
	}
	
	

}
