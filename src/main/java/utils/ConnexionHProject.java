package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionHProject {

		private String address;
		private String name;
		private String password;
		private String driver;
		private Connection c;
		
		//Attributs SINGLETON
		private String url = "jdbc:postgresql://localhost:5432/db_hotel";
		private String user = "postgres";
		private String pwd = "afpa123";
		
		//Attribut de classe
		private static Connection connect;
		
		//Constructeur privé
		private ConnexionHProject() {
			try {
				connect= DriverManager.getConnection(url, user, pwd);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//Méthode qui va retourner l'instance et la crééer si elle n'existe pas
		public static Connection getInstance() {
			 try {
					if(connect == null || !connect.isValid(0)){
					  new ConnexionHProject();
					  //System.out.println("c ok");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					//Connexion perdue ou time out
					e.printStackTrace();
				}
			    return connect;   
		}   
		
		
		
		
		
		public ConnexionHProject(String address, String name, String password, String driver) {
			this.address = address;
			this.name = name;
			this.password = password;
			this.driver = driver;
			try {
				// On charge le driver
				Class.forName(driver);
				this.c = DriverManager
				        .getConnection(address, name, password);
				//System.out.println("Connexion ok");				
			} catch (SQLException e) {
				e.printStackTrace();
				// Si le driver n'a pas été chargé
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
		}

		public Connection getC() {
			//to do screen
			//cstructeur privatif if connexion not valid cf doc java connexion is valid
			return c;
		}

		public void closeConnection() {
			try {
				this.c.close();
				//System.out.println("Déconnexion ok");		
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	

}
