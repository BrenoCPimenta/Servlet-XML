package br.com.java.domain;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import br.com.java.domain.Plant;
import br.com.java.domain.PlantService;
import br.com.java.util.DateUtil;
import junit.framework.TestCase;

public class PlantServiceTest extends TestCase {

	
	public void testService() throws SQLException{
		//Creating a Test Plant
		PlantService pSrc = new PlantService();
		Plant plantTest = new Plant();
		plantTest.setPlants("TestService");		
		DateUtil simDate = new DateUtil(2018, 11, 17);
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
