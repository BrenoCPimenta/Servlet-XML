package br.com.java.domain;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="plants")
public class PlantList implements Serializable{
	private static final long serialVersionUID = 1L;
	private List<Plant> plants;
	
	@XmlElement(name="plant")
	public List<Plant> getPlants(){
		return plants;
	}
	
	public void setPlants(List<Plant> plants) {
		this.plants = plants;
	}
	
	@Override
	public String toString() {
		return "PlantList [plants=" + plants + "]";
	}
	

}
