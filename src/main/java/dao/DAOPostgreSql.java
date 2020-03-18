package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import model.Categorie;
import utils.ConnexionHProject;


public abstract class DAOPostgreSql<T> {

	//Attributs
	private ConnexionHProject cxion = null;
	protected String reqInsert 		= "";
	protected String reqUpdate		= "";
	protected String reqDelete		= "";
	protected String reqFindById	= "";
	protected String reqFindAll		= "";
	
	//CONSTRUCTEUR
	public DAOPostgreSql(ConnexionHProject cxion) {
		this.cxion = cxion;
	}
	
	
	
	//METHODES
	//créée une instance de connexion si perdue ou si elle n existe pas
	protected Connection getConnection() {
		return ConnexionHProject.getInstance();
	}
	
	//METHODE ABSTRAITE DEFINI DANS LES DAO
	public abstract int executeInsert(PreparedStatement ps, T objACreer);
	
	
	
	//Méthodes à implémenter 
	public  T insert (T objACReer) {
		try {
			PreparedStatement stmt = getConnection().prepareStatement(reqInsert,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY,ResultSet.HOLD_CURSORS_OVER_COMMIT);
			executeInsert(stmt,objACReer);
		}catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		return objACReer;
		}
	
	
	
	
	
	//METHODE ABSTRAITE
	//implémentée par les dao filles
	//fourniture d'un objet à partir des rs.getInt String qui sont spécifiques à chaque table de la bdd
	public abstract Optional<T> rsToObj (ResultSet rs);
	
	//METHODES CONCRETES
	//les méthodes findbyId et finAll sont les mêmes pour tous types de produits
	public Optional<T> findById(int pIdObjetRecherche) {
		//Initialisation
		PreparedStatement preparedStmt = null;
			
			try {
				//préparation de la requête
				preparedStmt = getConnection().prepareStatement(reqFindById,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY,ResultSet.HOLD_CURSORS_OVER_COMMIT);
				
				preparedStmt.setInt(1,  pIdObjetRecherche);
				//exécution requete
				ResultSet results = preparedStmt.executeQuery();
				//si valeur présente retourne valeur, sinon retourne optionalObjBuildFromRs vide
				Optional<T> optionalObjBuildFromRs; 
				
				if (results.first()) {
					//si resultat sur premiere ligne
					optionalObjBuildFromRs = rsToObj(results); //resultat dans la variable
					//si resultat pour la requete
					if (optionalObjBuildFromRs.isPresent()) { 
						//
						return Optional.ofNullable(optionalObjBuildFromRs.get());
					}
				}
				results.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {
				try {
					preparedStmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
		
			return Optional.empty();
		}



	
}