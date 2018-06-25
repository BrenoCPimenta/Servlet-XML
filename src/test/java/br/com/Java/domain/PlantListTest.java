package br.com.Java.domain;

import java.util.ArrayList;
import java.util.List;

import br.com.java.domain.Plant;
import br.com.java.domain.PlantList;
import junit.framework.TestCase;

public class PlantListTest extends TestCase {

	public void testPlantList() {
		//Create a Plant List and set into it some plants		
		List<Plant> pl = new ArrayList<>();
		Plant p1 = new Plant();
		p1.setPlants("Tree");
		pl.add(p1);
		Plant p2 = new Plant();
		p2.setPlants("BiggerTree");
		pl.add(p2);
		
		//Create the object and set into it the list
		PlantList objectPL = new PlantList();
		objectPL.setPlants(pl);
		
		//Test get plant method
		assertEquals(objectPL.getPlants().get(0), p1);
		
		//Test toString Overrided method
		assertEquals(objectPL.toString(), "PlantList [plants=[Plant [id=0, plant=Tree, date=null, sun=0,"
										+ " WaterTimes=0, WaterUnity=null], Plant [id=0, plant=BiggerTree,"
										+ " date=null, sun=0, WaterTimes=0, WaterUnity=null]]]");
		
		
		
	}
}
