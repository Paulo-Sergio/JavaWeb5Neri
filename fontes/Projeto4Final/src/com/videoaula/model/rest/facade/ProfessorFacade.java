package com.videoaula.model.rest.facade;

import java.util.List;

import javax.inject.Inject;
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
import com.videoaula.model.service.IProfessorService;

@Path("/professores")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Consumes(MediaType.APPLICATION_JSON)
public class ProfessorFacade {

	@Inject
	private IProfessorService iProfessorService;

	@GET
	public List<Professor> getProfessores() {
		return this.iProfessorService.getProfessores();
	}

	@POST
	public Professor salvarProfessor(Professor professor) {
		return this.iProfessorService.salvarProfessor(professor);
	}

	@PUT
	public void atualizarProfessor(Professor professor) {
		this.iProfessorService.alterarProfessor(professor);
	}

	@DELETE
	@PathParam("/{id}")
	public void excluirProfessor(@PathParam("id") Integer idProfessor) {
		Professor professor = new Professor();
		professor.setId(idProfessor);
		this.iProfessorService.excluirProfessor(professor);
	}
}