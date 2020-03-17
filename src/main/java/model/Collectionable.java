package model;

public abstract class Collectionable {
	
	//Attributs
	private int id;
	//private String nom;
	//private int qte;
	
	//Constructeurs
	public Collectionable() {
	}
	
	public Collectionable(int id) {
		this.id = id;
	}

	
	
	//Accessseurs
	public int getId() {
		return id;
	}

	
}
