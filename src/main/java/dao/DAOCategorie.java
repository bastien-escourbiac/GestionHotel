package dao;

import java.sql.PreparedStatement;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import model.Categorie;
import model.Collection;
import utils.ConnexionHProject;



public class DAOCategorie extends DAOPostgreSql<Categorie> {
	
	public DAOCategorie(ConnexionHProject pConnexion) {
		super(pConnexion);
		reqInsert 	= "INSERT into categorie VALUES(?,?)";
		reqUpdate	= "UPDATE categorie SET nomcat=? WHERE nucat = ?";
		reqDelete	= "DELETE FROM categorie WHERE nucat = ?";
		reqFindById	= "SELECT * FROM categorie WHERE nucat = ?";
		reqFindAll	= "SELECT * FROM categorie";
		
	}
	
	@Override
	public int executeInsert (PreparedStatement stmt, Categorie objACreer) {
		try {
			stmt.setInt(1, objACreer.getNuCat());
			stmt.setString(2, objACreer.getNomCat());
			stmt.executeUpdate();
			System.out.println("insert ok");
		}catch(SQLException e) {
			System.out.println("impossible de créer la catégorie");
		}
	return objACreer.getNuCat();
	}
	
	@Override
	public void executeDelete(PreparedStatement stmt,int id) {
		try {
			System.out.println("id = "+ id);
			stmt.executeUpdate();
			System.out.println("obj delete");
		} catch (SQLException e) {
			System.out.println("not delete");
		}
	}
	
	@Override
	public int executeUpdate(PreparedStatement stmt, Categorie objAUpdate) {
		try {
			stmt.setInt(1, objAUpdate.getNuCat());
			stmt.setString(2, objAUpdate.getNomCat());
			stmt.executeUpdate();
			System.out.println("update ok");
		}catch(SQLException e) {
			System.out.println("impossible de faire l'update");
		}
	return objAUpdate.getNuCat();
	}

	
	
	
	
	
	/*public void delete(int idADelete) throws SQLException {
		String sql = "DELETE FROM categorie WHERE nuCat= "+idADelete;
		try {
			 PreparedStatement stmt 	= getConnection().prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			 //exécution de la requete
			 stmt.executeUpdate();
			 System.out.println("L'objet avec l'id "+idADelete+" a été effacé.");
			} catch  (SQLException e) {
				e.printStackTrace();
			 System.out.println("not delete");
			}		
		
	}*/
	


	@Override
	public Optional<Categorie> rsToObj(ResultSet rs) {
		try {
			return Optional.ofNullable(	new Categorie(rs.getInt(1), rs.getString(2)) );
			} catch (SQLException e) 
				{
					e.printStackTrace();
				}
				return Optional.empty();
			}

	
	
			


	


	

	
}
