package model;

import java.util.HashMap;
import java.util.*; 
import java.util.Map;

public class Collection<T extends Collectionable>  {
		//ATTRIBUTS
		//HaschMap collection clé valeur
		//HaschMap implémente Map
		//Type Integer et type T à définir lors de l'instanciation
		private Map<Integer, T> collection =  new HashMap<>();
		
		//METHODES
		// AJOUTER UN TYPE DE PRODUIT (hotel/chambre/type/catégorie)
		public void addItem(T pItem) {
			collection.put(pItem.getId(), pItem);
		}
		
		//Retourne l'objet par son id
		public T getItem(Integer itemId) {
			return collection.get(itemId);
		}
		
		//PAs besoin je pense
		public Map<Integer, T> getCollection(){
			return collection;
		}

		@Override
		public String toString() {
			return "Collection [collection=" + collection + "]";
		}
		
		/*
		public Map<Integer, T> getStockToHMIdName(){
			Map<Integer, T> mapIdName=new HashMap<Integer, T>();
			
			for(Map.Entry<Integer, T> entry: collection.entrySet())
			{
				mapIdName.put(entry.getKey(), entry.getValue().getId());
			}
			return mapIdName;
		}*/
		
		
		
		

		
		
}
