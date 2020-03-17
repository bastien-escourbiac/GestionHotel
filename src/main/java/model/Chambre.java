package model;

public class Chambre extends Collectionable {
	
	private int nuChambre;
	private Categorie categorie;
	//TODO retrouver le numero de l hotel sans avoir d'attribut dans cette classe
	//
		
	public Chambre() {

	}

	public Chambre(int id) {
		super(id);
		
	}
	
	public Chambre(int nuChambre, Categorie categorie , int nuHotel) {
		super();
		this.nuChambre = nuChambre;
		this.categorie = categorie;
	}
	
	//Méthode
	@Override
	public String toString() {
		return "Chambre [nuChambre=" + nuChambre + ", categorie=" + categorie + "]";
	}
	
	


}
