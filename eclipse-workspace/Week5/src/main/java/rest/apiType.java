package rest;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/type/")
public class apiType {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes("text/plain")
	public String plainText(){
		
		String text = "Hello Plain Text";
		return text;
	}
	
	@GET
	@Produces(MediaType.TEXT_XML)
	@Consumes("application/xml")
	public String plainXML(){
		
		String xml = "<?xml version=\"1.0\"?>" +
				"<value>Hello XML</value>";
		return xml;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes("application/json")
	public String plainJSON(){
		
		String json = "{\"value\":\"Hello JSON\"}";
		
		return json;
	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	@Consumes("text/html")
	public String plainHTML(){
		
		String html = "<p>Hello HTML</p>";
		
		return html; 
				
	}

}
