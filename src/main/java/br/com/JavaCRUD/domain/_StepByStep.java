package br.com.JavaCRUD.domain;

import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import junit.framework.TestCase;

public class _StepByStep extends TestCase {
	
	
	private Plant p = new Plant();
	
	
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

	
	public void testPlantObject() {
		p.setPlants("Pé de Café");
		assertEquals(p.getPlants(), "Pé de Café");
	}
	
	
	
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
			
		//Using by Column name
			/* conn = db.getConnection();
			 * stmt = conn.prepareStatement("SELECT * FROM garden");
			 * ResultSet rs = stmt.executeQuery();
			 * rs.next();
			 * String st = rs.getString("plant");
			 * assertEquals(st, "flower");
			*/		
			
		}finally{
			if(stmt != null) {
				stmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		}
	}
	
	
	public void testCreateUpdateDeletePlantDAO() throws SQLException {
		//Iniciate a plant as it is on the Table
		Plant plantToCompare = new Plant();
		plantToCompare.setPlants("flower");
		
		SimpleDate simpleDate = new SimpleDate(1998, 5, 6);
		Date date = simpleDate.getDate();
		plantToCompare.setDate(date);
		
		byte sun = 1;
		plantToCompare.setSun(sun);
		plantToCompare.setWaterTimes(1);
		plantToCompare.setWaterUnity("a day");
		long id = 1;
		plantToCompare.setId(id);
		
		
		
		//Lets try the methods on PlantDAO
		PlantDAO pDAO = new PlantDAO();
		
		
		//1 We verify the getPlantById. Remember id=1
		p = pDAO.getPlantById(id);
		assertEquals("flower", p.getPlants());

		//2 Now we verify the findByName
		List<Plant> pList = pDAO.findByName("lo");
		assertEquals(pList.get(0).getPlants(), "flower");
		
		//3 Now getPlants
		List<Plant> pList2 = pDAO.getPlants();
		assertEquals(pList2.get(0).getPlants(), "flower");
		
		//4 Create a Plant without ID and save it
		Plant plantTest = new Plant();
		plantTest.setPlants("TestID");		
		SimpleDate simDate = new SimpleDate(2012, 01, 26);
		Date testDate = simDate.getDate();
		plantTest.setDate(testDate);
		byte sunTest = 0;
		plantTest.setSun(sunTest);	
		plantTest.setWaterTimes(9);
		plantTest.setWaterUnity("a week");		
		pDAO.savePlant(plantTest);
		
		long autoIncrementedId = pDAO.getNextID() - 1;
		p = pDAO.getPlantById(autoIncrementedId);
		assertEquals(plantTest.getPlants(), p.getPlants());
		
		
		//5 Lets Update our first plant so she needs 4 times water a week instead of 9
		plantToCompare.setWaterTimes(4);
		plantToCompare.setId(autoIncrementedId);
		pDAO.savePlant(plantToCompare);
		
		p = pDAO.getPlantById(autoIncrementedId);
		int TimesReceived = p.getWaterTimes();
		assertEquals(4, TimesReceived);		
		
		//7 Delete Plant
		pDAO.deletePlant(autoIncrementedId);
		
		p = pDAO.getPlantById(autoIncrementedId);
		assertEquals(null, p);
			
	}
	
	public void testService() throws SQLException{
		//Creating a Test Plant
		PlantService pSrc = new PlantService();
		Plant plantTest = new Plant();
		plantTest.setPlants("TestService");		
		SimpleDate simDate = new SimpleDate(2018, 11, 17);
		Date testDate = simDate.getDate();
		plantTest.setDate(testDate);
		byte sunTest = 1;
		plantTest.setSun(sunTest);	
		plantTest.setWaterTimes(2);
		plantTest.setWaterUnity("a day");		
		
		//Saving plant
		assertEquals( pSrc.save(plantTest), true);
		
		//Get id from saved plant
		long autoIncrementedId = pSrc.nextId() - 1;

		//Get plant by id
		Plant p = pSrc.getPlant(autoIncrementedId);
		assertEquals(p.getPlants(), "TestService");
		
		//Getting plant by name
		List<Plant> pList = pSrc.getPlant("%Service%");
		assertEquals("TestService", pList.get(0).getPlants());
		
		//Getting all plants
		List<Plant> pList2 = pSrc.getPlants();
		assertEquals("TestService", pList2.get(1).getPlants());
		
		//Updating
		plantTest.setPlants("NameTest");
		plantTest.setId(autoIncrementedId);
		assertEquals(pSrc.save(plantTest), true);
		p = pSrc.getPlant(autoIncrementedId);
		assertEquals("NameTest", p.getPlants());
		
		//Delete
		pSrc.delete(autoIncrementedId);
		
		
	}
	
}
