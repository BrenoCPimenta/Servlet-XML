package br.com.Java.domain;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import br.com.java.domain.Plant;
import br.com.java.domain.PlantDAO;
import br.com.java.util.DateUtil;
import junit.framework.TestCase;

public class PlantDAOTest extends TestCase {
	
	private Plant p = new Plant();

	
	public void testCreateUpdateDeletePlantDAO() throws SQLException {
		//Iniciate a plant as it is on the Table
		Plant plantToCompare = new Plant();
		plantToCompare.setPlants("flower");
		
		DateUtil simpleDate = new DateUtil(1998, 5, 6);
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
		DateUtil simDate = new DateUtil(2012, 01, 26);
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
	

}
