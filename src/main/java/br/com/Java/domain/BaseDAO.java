package br.com.Java.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDAO {
	
	//Activating the drivers
	public BaseDAO() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();			
		}
	}
	
	//Method that connects to our database
	protected Connection getConnection() throws SQLException {
		String url = "jdbc:mariadb://localhost/plants";
		Connection conn = DriverManager.getConnection(url, "root", "maria");
		return conn;			
	}

}
