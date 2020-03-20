package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.sql.Statement;
import model.Collectionable;

import model.Categorie;
import model.Collection;
import utils.ConnexionHProject;
import model.Categorie;;


public abstract class DAOPostgreSql<T extends Collectionable> {

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
	
	public abstract int		executeInsert			(PreparedStatement ps, T objACreer);
	public abstract void	executeDelete			(PreparedStatement ps, int idObj);
	public abstract int 	executeUpdate			(PreparedStatement ps, T objAUpdate);
	//fourniture d'un objet à partir des rs.getInt String qui sont spécifiques à chaque table de la bdd
	public abstract Optional<T> rsToObj				(ResultSet rs);
	public abstract void 		objToRs 			(PreparedStatement pStmt, T objBaseToRs);
	
	
	public  T create (T objAUpdate) {
		try {
			PreparedStatement stmt = getConnection().prepareStatement(reqInsert,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY,ResultSet.HOLD_CURSORS_OVER_COMMIT);
			executeInsert(stmt,objAUpdate);
		}catch (SQLException e1) {
				e1.printStackTrace();
			}
		return objAUpdate;
		}
	
	public void delete(int idObject) {
		try {
			PreparedStatement stmt = getConnection().prepareStatement(reqDelete,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY,ResultSet.HOLD_CURSORS_OVER_COMMIT);
			executeDelete(stmt, idObject);
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public  T update (T objAUpdate) {
		try {
			PreparedStatement stmt = getConnection().prepareStatement(reqUpdate,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY,ResultSet.HOLD_CURSORS_OVER_COMMIT);
			executeUpdate(stmt,objAUpdate);
		}catch (SQLException e1) {
				e1.printStackTrace();
			}
		return objAUpdate;
		}

	//METHODES CONCRETES
	//les méthodes findbyId et finAll sont les mêmes pour tous types de produits
	public Optional<T> findById(int pIdObjetRecherche) {
		//Initialisation
		PreparedStatement preparedStmt = null;
			
			try {
				//préparation de la requête
				preparedStmt = getConnection().prepareStatement(reqFindById,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY,ResultSet.HOLD_CURSORS_OVER_COMMIT);
				//je donne l'id de 'lobjet en question au statement
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
	
	public Collection<T> findAll(){
		Collection<T> maCollection = new Collection<T>();
		PreparedStatement stmt = null;
		try {
			//prepa du statement avec connexion et req
			stmt = getConnection().prepareStatement(reqFindAll);
			//rs objet pour manipuler la table
			ResultSet rs = stmt.executeQuery();//execution req
			//évite de lever null pointer exception
			Optional<T> optionalObjResultSet;
			//boucle tant qu'il y a des éléments
			while (rs.next()) {
				//appel à la méthode abstraite
				optionalObjResultSet = rsToObj(rs);
				if(optionalObjResultSet.isPresent()) {
					//ajout de l'élément à la collection
					maCollection.addItem(optionalObjResultSet.get());
				}
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
			return maCollection;
		}
}
