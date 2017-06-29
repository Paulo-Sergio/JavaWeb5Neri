package com.videoaula.jaxrs;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("exemplowsrest")
public class Exemplo1 {

	@GET
	public String executaGet() {
		return "Executou GET";
	}
	
	@POST
	public String executaPost() {
		return "Executou POST";
	}
}
