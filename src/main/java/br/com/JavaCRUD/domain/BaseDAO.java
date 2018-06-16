package br.com.JavaCRUD.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDAO {
	
	//Activating the drivers
	public BaseDAO() {
		try {
			//IF YOU USE MYSQL NEED TO CHANGE HERE
			//Change org.mariadb for com.mysql
			Class.forName("org.mariadb.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();			
		}
	}
	
	//Creating a method that connects to our database
	protected Connection getConnection() throws SQLException {
		
		//The protocol to our IP and our DataBase. 
		//IF YOU USE MYSQL NEED TO CHANGE HERE
		//Change mariadb for mysql
		String url = "jdbc:mariadb://localhost/plants";
		//Connects using our url, user and password
		Connection conn = DriverManager.getConnection(url, "root", "maria");
		return conn;			
	}

}
