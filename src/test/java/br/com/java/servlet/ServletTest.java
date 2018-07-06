package br.com.java.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class ServletTest extends HttpServlet{
	private static final long serialVersionUID = 1l;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)  
									throws ServletException, IOException {
		resp.getWriter().print("Servlet with no parameters working");
	
	}
	
	//Passing the url with parameters
	//URL sintaxe:  http://localhost:8080/ServletXML/test?name=YourName&age=YourAge
	/*@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
										throws ServletException, IOException {
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		resp.getWriter().print("Hello " + name + " you are getting old buddy, "
								+ age + " isn't for everybody." 
								+"\n Servlet with parameters working.");
	}*/
	
	/*
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String nome = req.getParameter("nome");
		String sobrenome = req.getParameter("sobrenome");
		resp.getWriter().print("Olá mundo POST " + nome + " " + sobrenome);


	}*/

}
