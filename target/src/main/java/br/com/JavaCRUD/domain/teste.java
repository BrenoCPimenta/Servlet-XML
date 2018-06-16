package br.com.JavaCRUD.domain;

import java.sql.Date;

public class teste {
	
	public static void main(String[] args) {
		PlantService plantService = new PlantService();
		
		Plant p = new Plant();
		p.setPlants("TestPlant");
		@SuppressWarnings("deprecation")
		Date date = new Date(1986,02,5);
		p.setDate(date);
		byte sun = 0b0;
		p.setSun(sun);
		p.setWaterTimes(3);
		p.setWaterUnity("a day");
		
		//saving the test plant
		plantService.save(p);
		
		
		
		//System.out.println(p.toString()); 
		
		System.out.println(plantService.getPlant(1L).toString());	

		}
		
		
	

}
