package br.com.java.domain;

import br.com.java.domain.Plant;
import junit.framework.TestCase;

public class PlantTest extends TestCase {
	
	private Plant p = new Plant();
	
	public void testPlantObject() {
		p.setPlants("Pé de Café");
		assertEquals(p.getPlants(), "Pé de Café");
	}
	
	

}
