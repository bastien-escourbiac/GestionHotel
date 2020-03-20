package dao;

import java.sql.PreparedStatement;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import model.Categorie;
import model.Collection;
import model.TypeHotel;
import utils.ConnexionHProject;



public class DAOTypeHotel extends DAOPostgreSql<TypeHotel> {
	
	public DAOTypeHotel(ConnexionHProject pConnexion) {
		super(pConnexion);
		reqInsert 	= "INSERT into type_hotel VALUES(?,?)";
		reqUpdate	= "UPDATE type_hotel SET nomcat=? WHERE nomtype = ?";
		reqDelete	= "DELETE FROM type_hotel WHERE nomtype = ?";
		reqFindById	= "SELECT * FROM type_hotel WHERE nomtype = ?";
		reqFindAll	= "SELECT * FROM type_hotel";
	}
	
	@Override
	public int executeInsert (PreparedStatement stmt, TypeHotel objACreer) {
		try {
			stmt.setInt(1, objACreer.getId());
			stmt.setString(2, objACreer.getNomType());
			stmt.executeUpdate();
			System.out.println("insert ok");
		}catch(SQLException e) {
			System.out.println("impossible de créer le type hotel");
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
	public int executeUpdate(PreparedStatement stmt, TypeHotel objAUpdate) {
		try {
			stmt.setInt(2, objAUpdate.getId());
			stmt.setString(1, objAUpdate.getNomType());
			stmt.executeUpdate();
			System.out.println("update ok");
		}catch(SQLException e) {
			System.out.println("impossible de faire l'update");
		}
	return objAUpdate.getId();
	}
	
	@Override
	public Optional<TypeHotel> rsToObj(ResultSet rs) {
		try {
			return Optional.ofNullable(	new TypeHotel(rs.getInt(1), rs.getString(2)) );
			} catch (SQLException e) 
				{
					e.printStackTrace();
				}
				return Optional.empty();
			}

	@Override
	public void objToRs(PreparedStatement pStmt, TypeHotel objBaseToRs) {
		try {
			pStmt.setString(1, objBaseToRs.getNomType());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	

	
	


}
