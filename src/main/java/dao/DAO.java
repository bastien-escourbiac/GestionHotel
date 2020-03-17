package dao;

import java.util.Collection;

import model.Collectionable;
import utils.ConnexionHProject;

public abstract class DAO<T extends Collectionable>  {
	
	private ConnexionHProject cxion = null;
	
	public DAO(ConnexionHProject cxion) {
		super();
		this.cxion = cxion;
	}
	
	public void setCxion(ConnexionHProject cxion) {
		this.cxion = cxion;
	}

	public ConnexionHProject getCxion() {
		return cxion;
	}

	//Méthodes à implémenter 
	public abstract T create (T objACReer);
	public abstract T update (T objACReer);
	public abstract void delete (int idADelete);
	public abstract T findById(int idATrouver);
	public abstract Collection<T> findAll();



}
