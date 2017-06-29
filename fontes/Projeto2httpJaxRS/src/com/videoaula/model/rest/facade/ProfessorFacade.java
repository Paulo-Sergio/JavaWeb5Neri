package com.videoaula.model.rest.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.videoaula.model.Professor;

@Path("/professores")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Consumes(MediaType.APPLICATION_JSON)
public class ProfessorFacade {

	static List<Professor> listaProfessores = new ArrayList<Professor>();

	static {
		listaProfessores.add(new Professor(1, "Paulo Franca", "paulo@gmail.com", "(81)98882-4977"));
		listaProfessores.add(new Professor(2, "NERI", "nericursos@informaticon.com.br", "(54)94469-1223"));
	}

	@GET
	public List<Professor> getProfessores() {
		return listaProfessores;
	}
}
