package br.com.JavaCRUD.domain;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class _TestSave {
/*	
	public void testSavePlant() throws SQLException {
		BaseDAO db = new BaseDAO();
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			//first we make the connection, and then will check for the ID
			conn = db.getConnection();
			
			//If the id from our plant is null, we will add as the next on our table
			if(p.getId()==null){
				stmt=conn.prepareStatement("INSERTO INTO garden (plant, date, sun, WaterTimes, WaterUnity)"
						                 + "VALUES(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			}else {
			//if the id already is in use
				stmt = conn.prepareStatement("UPDATE garden SET plant=?, date=?, sun=?, WaterTimes=?, WaterUnity=? WHERE id=?");
			}
			stmt.setString(1, p.getPlants());
			stmt.setDate(2, p.getDate());
			stmt.setByte(3, p.getSun());
			stmt.setInt(4, p.getWaterTimes());
			stmt.setString(5, p.getWaterUnity());
			
			//If it is a update we need to add the already existent id
			if(p.getId()!=null) {
				stmt.setLong(6, p.getId());
			}
			//Lets check if the update was successful 
			int count = stmt.executeUpdate(); //if it returns nothing, count will be equals 0
			if(count==0) throw new SQLException("Error in inserting the plant");
			
			//if the insertion was fine, we can read the autoIncremented Id
			if(p.getId()==null) {
				//Now we will use the method we created before
				Long id = getGeneratedId(stmt);
				p.setId(id);
			}
		
			
		}finally {
			//If the Statement or the Connection, hasn't been closed, we close it 
			if(conn != null) {
				conn.close();
			}
			if(stmt != null) {
				stmt.close();
			}
		}
	
	}*/
	
	public void testSave() throws SQLException {
		System.out.println("comecando");
		Plant p = new Plant();
		BaseDAO db = new BaseDAO();
		Connection conn = null;
		PreparedStatement stmt = null;
		byte sun = 1;
		long id = 1;
		
		try {
			System.out.println("Manipulando QUERY");
			conn = db.getConnection();
			stmt = conn.prepareStatement("INSERT INTO garden (plant, date, sun, WaterTimes, WaterUnity) VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

		}catch(SQLException e){
			System.out.println("Deu erro na criação do query");
			System.out.println(e);
		}
		
		System.out.println("Começando a inserir no QUERY os valores");
		stmt.setString(1, "flower");
		System.out.println("flor passou");
		
		SimpleDate simpleDate = new SimpleDate(1998, 5, 6);
		Date date = simpleDate.getDate();

		//stmt.setString(2, "2010-08-09");
		stmt.setDate(2, date);
		System.out.println("data passou");
		stmt.setByte(3, sun);
		stmt.setInt(4, 2);
		stmt.setString(5, "a year");
		System.out.println("Terminando de Inserir no Query os vaolers");
		
		
		try {
			System.out.println("Implementando SQL");
			stmt.executeUpdate();
			System.out.println("Implementou");
		}catch(SQLException e){
			System.out.println("Deu erro na implementação");
			System.out.println(e);
			
		}	finally {
		
			if(conn != null) {
				conn.close();
			}
			if(stmt != null) {
				stmt.close();
			}
		}
		
		
	}
	

	
	public static void main(String[] args) throws SQLException {
		//_TestSave ts = new _TestSave();
		
		Plant p = new Plant();
		p.setPlants("flower");
		SimpleDate simpleDate = new SimpleDate(1998, 5, 6);
		Date date = simpleDate.getDate();
		p.setDate(date);
		byte sun = 1;
		p.setSun(sun);
		p.setWaterTimes(1);
		p.setWaterUnity("a day");
		long id = 1;
		p.setId(id);
	
		PlantDAO pDAO = new PlantDAO();
		pDAO.savePlant(p);
	}

}
