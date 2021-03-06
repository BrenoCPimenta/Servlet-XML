package test;

import java.sql.Date;
import java.util.List;

import br.com.JavaCRUD.domain.*;
import junit.framework.TestCase;

public class GardenTest extends TestCase {
	private PlantService plantService = new PlantService();
	

	
	public void testPlantList() {
		List<Plant> plants = plantService.getPlants();
		assertNotNull(plants);
		//Validates if found something
		assertTrue(plants.size()>0);
		
		//Validates if finds the Plant 1 added by hand - See ReadMe file
		/*Reminder: we need to add the get(index), 
		because the method will return a list*/
		Plant p = plantService.getPlant("Plant 1").get(0);
		assertEquals("Plant 1", p.getPlants());	
	}
	
	public void testSaveDeletePlant() {
		//Creating a test plant
		Plant p = new Plant();
		p.setPlants("TestPlant");
		@SuppressWarnings("deprecation")
		Date date = new Date(1986,31,5);
		p.setDate(date);
		byte sun = 0b0;
		p.setSun(sun);
		p.setWaterTimes(3);
		p.setWaterUnity("a day");
		
		//saving the test plant
		plantService.save(p);
		//Getting the id autogenerated of the saved plant
		Long id = p.getId();
		assertNotNull(id);
		
		//Search on the Table to see if the plant was saved
		p = plantService.getPlant(id);
		assertEquals("TestPlant", p.getPlants());
		assertEquals("30/05/2018", p.getDate());
		assertEquals(sun, p.getSun());
		assertEquals(3, p.getWaterTimes());
		assertEquals("a day", p.getWaterUnity());
		
		//Test the Update
		p.setPlants("Test Update");
		plantService.save(p);
		
		//Search the plant again, to verify the Update
		plantService.getPlant(id);
		assertEquals("Test Update", p.getPlants());
		
		//Now deleting the plant
		plantService.delete(id);
		//Search the plant again
		plantService.getPlant(id);
		assertNotNull(p);
	}
}
