package model;

public class TypeHotel extends Collectionable {
	
	private String nomType;
		
	//Cstrcteur
	public TypeHotel(int nuType, String nomType) {
		super(nuType);
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
	public String getNomType() {
		return nomType;
	}

	public void setNomType(String nomType) {
		this.nomType = nomType;
	}

	@Override
	public String toString() {
		return "TypeHotel [" + this.getId() + " nomCat=" + getNomType() + "]";
	}

	
}
	