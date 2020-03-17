package model;

public class TypeHotel extends Collectionable {
	
	private int nuType;
	private String nomType;
	
	
	//Cstrcteur

	public TypeHotel(int nuType, String nomType) {
		super();
		this.nuType = nuType;
		this.nomType = nomType;
	}

	public TypeHotel() {
		// TODO Auto-generated constructor stub
	}

	public TypeHotel(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	
	//Accessseurs
	public int getNuType() {
		return nuType;
	}

	public void setNuType(int nuType) {
		this.nuType = nuType;
	}

	public String getNomType() {
		return nomType;
	}

	public void setNomType(String nomType) {
		this.nomType = nomType;
	}


}
	