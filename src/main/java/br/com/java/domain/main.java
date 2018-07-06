package br.com.java.domain;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.java.util.JAXBUtil;

public class main {

	public static void main(String[] args) throws SQLException, IOException {

//FUNCIONA		
//		PlantDAO pdao = new PlantDAO();
//		System.out.println("O proximo id é " + pdao.getNextID());
//		List<Plant> pl = pdao.getPlants();
//		System.out.println(pl.get(0).toString());


//FUNCIONA		
/*		Connection conn = null;
		BaseDAO bdao = new BaseDAO(); 
		conn = bdao.getConnection();
		if(conn != null) {
			System.out.println("Funcionando a conexao com o banco de dados");
		}else {
			System.out.println("NAO ESTA Funcionando a conexao com o banco de dados");
		}
*/	
		
//FUNCIONA SOH SEM O ID
		/*
		PlantService pS = new PlantService();
		List<Plant> plantList = pS.getPlant("lo");
		System.out.println(plantList.get(0).toString());
		
		
		Plant p = new Plant();
		p.setId(6l);
		p.setPlants("Tree");
		p.setDate(2012, 5, 16);
		p.setSun((byte) 1);
		
		if(pS.save(p)) {
			System.out.println("funcionou");
		}else {
			System.out.println("NAO funcionou");
		}
		//System.out.println(pS.getPlant(2l).toString());
		 
		 */
		
		
		
//	FUNCIONA
		
		PlantService pS = new PlantService();
		List<Plant> pl = pS.getPlants();
		PlantList plUtil = new PlantList();
		plUtil.setPlants(pl);
		System.out.println(plUtil.toString());
/*
 		System.out.println(pl.get(0).toString());
		long id = 1l;
		System.out.println(pS.getPlant(id).toString());
*/
		JAXBUtil u = new JAXBUtil();
		System.out.println(u.toXML(plUtil));
		

		

		
	}
}
