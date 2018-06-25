package br.com.java.util;


import java.io.IOException;
import br.com.java.domain.Plant;
import br.com.java.util.JAXBUtil;
import junit.framework.TestCase;

public class JAXBUtilTest extends TestCase {
	
	public void testPlantToXML() throws IOException {
		
	//Create a plant object
	Plant p = new Plant();
	p.setPlants("BigFlower");
	p.setId(1l);
	p.setSun((byte) 0);
	p.setDate(2008, 9, 16);
	p.setWaterTimes(2);
	p.setWaterUnity("a day");
	
	//transforme it into XML
	String plantXml = new String();
	plantXml = JAXBUtil.toXML(p);
	
	//test
	assertEquals(plantXml, "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" + 
							"<plant>\n" + 
							"    <date/>\n" + 
							"    <plants>BigFlower</plants>\n" + 
							"    <sun>0</sun>\n" + 
							"    <waterTimes>2</waterTimes>\n" + 
							"    <waterUnity>a day</waterUnity>\n" + 
							"</plant>\n");	
	}
	
	
}
