package model;

import java.util.HashMap;
import java.util.Map;

public class Collection<T extends Collectionable>  {
		//ATTRIBUTS
		//HaschMap collection clé valeur
		//HaschMap implémente Map
		//Type Integer et type T à définir lors de l'instanciation
		private Map<Integer, T> collection =  new HashMap<Integer, T>();
		
		//METHODES
		// AJOUTER UN TYPE DE PRODUIT (hotel/chambre/type/catégorie)
		public void addItem(T pItem) {
			collection.put(pItem.getId(), pItem);
		}
		
		//Retourne le type de produit
		public T getItem(Integer itemId) {
			return collection.get(itemId);
		}
		
		//PAs besoin je pense
		public Map<Integer, T> getCollectionToHM(){
			return null;
		}
		
}
