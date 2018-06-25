package br.com.java.util;

import java.io.IOException;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import br.com.java.domain.Plant;
import br.com.java.domain.PlantList;

public class JAXBUtil {
	private static JAXBUtil instance;
	private static JAXBContext context;
	
	public static JAXBUtil getInstance() {
		return instance;
	}
	
	//Executes when iniciates the runtime
	static {
		try {
			//Inform JAXB to use this classes
			context = JAXBContext.newInstance(PlantList.class, Plant.class);
			}catch (JAXBException e) {
				throw new RuntimeException(e);
			}
	}
	
	
	//Transform a object into a XML
	public static String toXML(Object object) throws IOException{
		try {
			/*This method is from a object to XML, so will be a Marshall process.
			 *So we creat a Marshaller with the context that is responsible to 
			 *reference the classes from our objects.*/
			Marshaller m = context.createMarshaller();
			
			/* JAXB_FORMATTED_OUTPUT
			 * This property controls whether or not the Marshaller will format the resulting XML data with line breaks
			 * and indentation. A true value for this property indicates human readable indented xml data, while a false
			 * value indicates unformatted xml data. The Marshaller will default to false (unformatted) if this property 
			 * is not specified.*/
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			/*We will pass the result to a buffer than to String, 
			 *so we can handle it inside our code.*/
			StringWriter writer = new StringWriter();
			m.marshal(object, writer);
			String xml = writer.toString();
			return xml;
			
		}catch (JAXBException e) {
			e.printStackTrace();
			return null;
		}
	}
}
