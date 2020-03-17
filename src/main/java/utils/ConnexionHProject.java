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
				System.out.println("Connexion ok");				
			} catch (SQLException e) {
				e.printStackTrace();
				// Si le driver n'a pas été chargé
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
		}

		public Connection getC() {
			return c;
		}

		public void closeConnection() {
			try {
				this.c.close();
				System.out.println("Déconnexion ok");		
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	

}
