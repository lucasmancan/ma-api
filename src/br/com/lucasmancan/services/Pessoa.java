package br.com.lucasmancan.services;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/pessoas")
public class Pessoa {

	@GET
	@Path("/message")
	public String getMessage() {
		return "Hello World, Lucas";
	}

}
