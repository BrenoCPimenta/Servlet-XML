package br.com.Java.domain;

import java.io.Serializable;
import java.sql.Date;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
/*The data you are going to set or get using getter or setter method some times 
may need to pass through network from one remote to another remote system.
Serializable is property that allows you to write the data or the object state into
an output stream and fetch it back from there */

public class Plant implements Serializable {
	private static final long serialVersionUID = 1L;	
	
	private long id;
	private String plants;
	private Date date;
	private byte sun; //The tinyint reference in java is byte
	private int WaterTimes;
	private String WaterUnity;
	
	public Long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPlants() {
		return plants;
	}
	public void setPlants(String plants) {
		this.plants = plants;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(int year, int month, int day) {
		SimpleDate simpleDate = new SimpleDate(1998, 5, 6);
		Date date = simpleDate.getDate();
		this.date = date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public byte getSun() {
		return sun;
	}
	public void setSun(byte sun) {
		this.sun = sun;
	}
	public int getWaterTimes() {
		return WaterTimes;
	}
	public void setWaterTimes(int waterTimes) {
		WaterTimes = waterTimes;
	}
	public String getWaterUnity() {
		return WaterUnity;
	}
	public void setWaterUnity(String waterUnity) {
		WaterUnity = waterUnity;
	}
	
	//Method to return us all the information as String
	@Override 
	public String toString() {
		return "Plant [id="+id+", plant="+plants+", date="+date+", sun="+sun+", WaterTimes="+ WaterTimes+", WaterUnity="+WaterUnity+"]";
	}
	
	

}
