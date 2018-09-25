package br.com.lucasmancan.services;


import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.hibernate.property.access.spi.GetterMethodImpl;

import br.com.lucasmancan.models.Pessoa;

@Path("/pessoas")
public class PessoaWebService {

	@GET
	@Path("/message")
	public String getMessage() {
		return "Hello World, Lucas";
	}

	

	@GET
	@Path("/list")
	public Response getPessoas() {
		
		List<Pessoa> pessoas = 
				.getResultlist();
		return Response.ok(pessoas).build();
	}
}
