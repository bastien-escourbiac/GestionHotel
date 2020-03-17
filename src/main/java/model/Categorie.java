package model;

public class Categorie extends Collectionable {
	private String nomCat;
	

	public Categorie(String nomCat) {
		super();
		this.nomCat = nomCat;
	}

	public Categorie() {
		// TODO Auto-generated constructor stub
	}

	public Categorie(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	public String getNomCat() {
		return nomCat;
	}

	public void setNomCat(String nomCat) {
		this.nomCat = nomCat;
	}

}
