package model;

public class Categorie extends Collectionable {
	private int nuCat;
	private String nomCat;
	

	public Categorie(String nomCat) {
		super();
		this.nomCat = nomCat;
	}
	
	public Categorie(int nuCat, String nomCat) {
		super();
		this.nuCat = nuCat;
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

	public int getNuCat() {
		return nuCat;
	}

	public void setNuCat(int nuCat) {
		this.nuCat = nuCat;
	}

	@Override
	public String toString() {
		return "Categorie [nuCat=" + getNuCat() + ", nomCat=" + getNomCat() + "]";
	}
	
	
	
	

}
