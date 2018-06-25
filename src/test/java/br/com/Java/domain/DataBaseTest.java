package br.com.Java.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.java.domain.BaseDAO;
import junit.framework.TestCase;

public class DataBaseTest extends TestCase {
	
	public void testDataBase() throws SQLException {	
		Connection conn = null;
		BaseDAO db = new BaseDAO();
		PreparedStatement stmt = null;
		
		try {
			//Using a query by index
			conn = db.getConnection();
			stmt = conn.prepareStatement("SELECT plant FROM garden WHERE id = ?");
			long id = 1l;
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			String st = rs.getString(1);
			assertEquals(st, "flower");
			
		}finally{
			if(stmt != null) {
				stmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		}
	}

}
