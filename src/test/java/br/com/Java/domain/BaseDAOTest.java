package br.com.Java.domain;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.java.domain.BaseDAO;
import junit.framework.TestCase;

public class BaseDAOTest extends TestCase {

	public void testConnection() throws SQLException {
		Connection conn = null;
		BaseDAO db = new BaseDAO();
		
		try {
			conn = db.getConnection();	
		}catch(SQLException e) {
			System.out.println(e);
		}finally{
			if(conn != null) {
				conn.close();
			}
		}
	}
}
