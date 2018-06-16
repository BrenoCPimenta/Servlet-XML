package br.com.JavaCRUD.domain;

import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import junit.framework.TestCase;

public class _StepByStep extends TestCase {
	
	
	private Plant p = new Plant();
	
	
	public void testConnection() throws SQLException {
		Connection conn = null;
		BaseDAO db = new BaseDAO();
		
		try {
			conn = db.getConnection();			
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
		
		
		//1 We verify the getPlantById. Remember Id=1
		p = pDAO.getPlantById(id);
		assertEquals("flower", p.getPlants());

		//2 Now we verify the findByName
		List<Plant> pList = pDAO.findByName("lo");
		assertEquals(pList.get(0).getPlants(), "flower");
		
		//3 Now getPlants
		List<Plant> pList2 = pDAO.getPlants();
		assertEquals(pList2.get(0).getPlants(), "flower");
		
		//4 Create a Plant without ID
		long futureId = pDAO.getNextID() - 1;
		
		Plant plantTestNoID = new Plant();
		plantTestNoID.setPlants("TestID");		
		SimpleDate simDate = new SimpleDate(2012, 01, 26);
		Date testDate = simDate.getDate();
		plantTestNoID.setDate(testDate);
		byte sunTest = 0;
		plantTestNoID.setSun(sunTest);	
		plantTestNoID.setWaterTimes(9);
		plantTestNoID.setWaterUnity("a week");		
		pDAO.savePlant(plantTestNoID);
		
		p = pDAO.getPlantById(futureId);
		System.out.println(p.toString());
		System.out.println(futureId);
		assertEquals(plantTestNoID.getPlants(), p.getPlants());
		
		
		//6 Lets Update our first plant so she needs 2 times water a day
		plantToCompare.setWaterTimes(4);
		
		pDAO.savePlant(plantToCompare);
		long idTest = 1l;
		p = pDAO.getPlantById(idTest);
		int TimesReceived = p.getWaterTimes();
		assertEquals(4, TimesReceived);		
		
		//7 Delete Plant
		idTest = 3l;
		pDAO.deletePlant(idTest);
		
		p = pDAO.getPlantById(idTest);
		assertEquals(null, p);
		
			
		
		
		
		
		//Setting up a Plant
		/*p.setPlants("Pé de Café");
		@SuppressWarnings("deprecation")
		Date date = new Date(1986,31,5);
		p.setDate(date);
		byte b = 1;
		p.setSun(b);
		p.setWaterTimes(4);
		p.setWaterUnity("a week");
		
		
		//Add this Plant
		PlantDAO pd = new PlantDAO();
		pd.savePlant(p);
		
		
		//We going to get all plants and select the last one using size list
		List<Plant> plantL = pd.getPlants();	
		plantL.get(plantL.size()).toString();
		int inde;
		inde = plantL.size();
		Plant littlePlant = plantL.get(inde);
		System.out.println(littlePlant.toString()+"\n"+inde);*/		
	}
	
}
