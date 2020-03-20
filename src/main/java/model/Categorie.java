package model;

public class Categorie extends Collectionable {
	
	private String nomCat;
	
	//Cstrcteur
	public Categorie(int nuCat, String nomCat) {
		super(nuCat);
		this.nomCat = nomCat;
	}


	public Categorie() {
		// TODO Auto-generated constructor stub
	}

	public String getNomCat() {
		return nomCat;
	}

	public void setNomCat(String nomCat) {
		this.nomCat = nomCat;
	}

	@Override
	public String toString() {
		return "Categorie [" + this.getId() + " nomCat=" + getNomCat() + "]";
	}
}
