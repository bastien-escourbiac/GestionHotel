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
			stmt.setInt(1, objACreer.getId());
			stmt.setString(2, objACreer.getNomCat());
			stmt.executeUpdate();
			System.out.println("insert ok");
		}catch(SQLException e) {
			System.out.println("impossible de créer la catégorie");
		}
	return objACreer.getId();
	}
	
	@Override
	public void executeDelete(PreparedStatement stmt,int id) {
		try {
			//je donne l'id de l'objet a delete au statement
			stmt.setInt(1,  id);
			stmt.executeUpdate();
			System.out.println("obj delete");
		} catch (SQLException e) {
			System.out.println("not delete");
		}
	}
	
	@Override
	public int executeUpdate(PreparedStatement stmt, Categorie objAUpdate) {
		try {
			stmt.setInt(2, objAUpdate.getId());
			stmt.setString(1, objAUpdate.getNomCat());
			stmt.executeUpdate();
			System.out.println("update ok");
		}catch(SQLException e) {
			System.out.println("impossible de faire l'update");
		}
	return objAUpdate.getId();
	}
	
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

	@Override
	public void objToRs(PreparedStatement pStmt, Categorie objBaseToRs) {
		try {
			pStmt.setString(1, objBaseToRs.getNomCat());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	

	
	


}
