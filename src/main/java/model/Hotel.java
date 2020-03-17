package model;

public class Hotel extends Collectionable {

	//Attributs
	private TypeHotel typeHotel;
	private String nomHotel;
	private String adresseHotel;
	private String codePostal;
	private String villeHotel;
	
	
	//Constructeurs
	public Hotel(int numTypeHotel) {
		super();
		this.typeHotel = typeHotel;
	}
	
	public Hotel(TypeHotel typeHotel, String nomHotel) {
		super();
		this.typeHotel = typeHotel;
		this.nomHotel = nomHotel;
	}

	public Hotel(TypeHotel typeHotel, String nomHotel, String adresseHotel) {
		super();
		this.typeHotel = typeHotel;
		this.nomHotel = nomHotel;
		this.adresseHotel = adresseHotel;
	}

	public Hotel(TypeHotel typeHotel, String nomHotel, String adresseHotel, String codePostal, String villeHotel) {
		super();
		this.typeHotel = typeHotel;
		this.nomHotel = nomHotel;
		this.adresseHotel = adresseHotel;
		this.codePostal = codePostal;
		this.villeHotel = villeHotel;
	}


	public TypeHotel getTypeHotel() {
		return typeHotel;
	}

	public void setTypeHotel(TypeHotel typeHotel) {
		this.typeHotel = typeHotel;
	}

	public String getNomHotel() {
		return nomHotel;
	}

	public void setNomHotel(String nomHotel) {
		this.nomHotel = nomHotel;
	}

	public String getAdresseHotel() {
		return adresseHotel;
	}

	public void setAdresseHotel(String adresseHotel) {
		this.adresseHotel = adresseHotel;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVilleHotel() {
		return villeHotel;
	}

	public void setVilleHotel(String villeHotel) {
		this.villeHotel = villeHotel;
	}
	
	//Méthodes
	@Override
	public String toString() {
		return "Hotel [typeHotel=" + typeHotel + ", nomHotel=" + nomHotel + ", adresseHotel=" + adresseHotel
				+ ", codePostal=" + codePostal + ", villeHotel=" + villeHotel + "]";
	}
	
	

	
}
