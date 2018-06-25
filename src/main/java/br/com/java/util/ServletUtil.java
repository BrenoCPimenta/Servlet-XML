package br.com.java.util;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;



public class ServletUtil {
	
	public static void writeXML (HttpServletResponse response, String xml) throws IOException {
		if(xml != null) {
			//First we get the response object and transform it into a text-output stream
			PrintWriter writer = response.getWriter();
			
			//Now we set the mime-type, so when the client receives the response his browser will handle as XML
			response.setContentType("application/xml;charset=UTF-8");
			
			//And at last we pass the xml string to the response
			writer.write(xml);
			writer.close();			
		}
	}

}
