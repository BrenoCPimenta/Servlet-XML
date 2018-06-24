package br.com.Java.domain;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlantService {
	private PlantDAO db = new PlantDAO();
	
	//Getting all plants
	public List<Plant> getPlants(){
		try {
			List<Plant> pl = db.getPlants();
			return pl;
		}catch(SQLException e) {
			e.printStackTrace();
			return new ArrayList<Plant>();
		}
	}
	
	//Getting plants by id
	public Plant getPlant(Long id) {
		try {
			return  db.getPlantById(id);
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//Getting plants by name
	public List<Plant> getPlant(String name){
		try {
			List<Plant> pl = db.findByName(name);
			return pl;
		}catch(SQLException e) {
			return null;
		}
	}
	
	//Adding and Update 
	public boolean save(Plant p) {
		try {
			db.savePlant(p);
			return true;
		}catch(SQLException e) {
			return false;
		}
	}
	
	//Getting the next Auto Incremented Id
	public long nextId() {
		try {
			return db.getNextID();
		}catch(SQLException e) {
			return 0;
		}
	}
	
	//Deleting
	public boolean delete(Long id) {
		try {
			return db.deletePlant(id);
		}catch(SQLException e){
			return false;
		}
	}
	
}
