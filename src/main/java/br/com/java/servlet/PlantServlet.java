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

@WebServlet("/Plant/*")
public class PlantServlet extends HttpServlet{
	private static final long serialVersionUID = 1l;
	private PlantService pService = new PlantService();
	
	@Override 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		List<Plant> plants = pService.getPlants();
		PlantList list = new PlantList();
		list.setPlants(plants);
		
		String xml = JAXBUtil.toXML(list);
		ServletUtil.writeXML(resp, xml);
	}
	

}