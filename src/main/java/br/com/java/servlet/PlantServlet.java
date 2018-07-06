package br.com.java.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.java.domain.Plant;
import br.com.java.domain.PlantList;
import br.com.java.domain.PlantService;
import br.com.java.util.JAXBUtil;
import br.com.java.util.ServletUtil;

@WebServlet("/AllPlants/*")
public class PlantServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1l;
	private PlantService plantService = new PlantService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//First we access the data base and get a list of all plants
		List<Plant> plants =  plantService.getPlants();
		
		//Now we use our class PlantList to help us to get a format we can pass to XML
		PlantList list = new PlantList();
		list.setPlants(plants);
		
		//Now we use the JAXBUtil method to create our xml with the lis formated
		String xml = JAXBUtil.toXML(list);
		
		//At last, we use the ServletUtilClass method to pass the xml as the response
		ServletUtil.writeXML(resp, xml);
				
	}

}
