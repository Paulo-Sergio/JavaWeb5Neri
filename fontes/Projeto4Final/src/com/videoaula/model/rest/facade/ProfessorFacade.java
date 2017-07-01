package com.videoaula.model.rest.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.videoaula.model.model.Professor;

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

	@POST
	public Professor salvar(Professor professor) {
		System.out.println(professor);
		listaProfessores.add(professor);
		return professor;
	}

	@PUT
	public void atualizar(Professor professor) {
		System.out.println(professor);
		listaProfessores.remove(professor);
		listaProfessores.add(professor);
	}

	@DELETE
	@Path("/{idProfessor}")
	public void excluir(@PathParam("idProfessor") Integer idProfessor) {
		Professor professor = new Professor();
		professor.setId(idProfessor);
		System.out.println(professor);
		
		listaProfessores.remove(professor);
	}
}