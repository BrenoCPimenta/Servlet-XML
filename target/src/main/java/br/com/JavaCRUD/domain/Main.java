package br.com.JavaCRUD.domain;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Main {

	public static void main(String[] args) throws SQLException {
		PlantDAO pDAO = new PlantDAO();
		/*
		Plant  SweetHeart = new Plant();
		String name = "SweetHeart";
		SweetHeart.setPlants(name);
		
		pDAO.savePlant(SweetHeart);
		*/
		System.out.println(pDAO.getNextID());
		
		
	}
	
}
