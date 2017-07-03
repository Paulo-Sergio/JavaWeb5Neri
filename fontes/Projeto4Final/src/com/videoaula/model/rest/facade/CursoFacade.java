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

import com.videoaula.model.model.Curso;
import com.videoaula.model.model.Professor;
import com.videoaula.model.service.ICursoService;

@Path("/cursos")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Consumes(MediaType.APPLICATION_JSON)
public class CursoFacade {

	@Inject
	private ICursoService iCursoService;

	@GET
	public List<Curso> getCursos() {
		return this.iCursoService.getCursos();
	}

	@POST
	public Curso salvarCurso(Curso curso) {
		return this.iCursoService.salvarCurso(curso);
	}

	@PUT
	public void atualizarCurso(Curso curso) {
		this.iCursoService.alterarCurso(curso);
	}

	@DELETE
	@Path("/{id}")
	public void excluirCurso(@PathParam("id") Integer idCurso) {
		Curso curso = new Curso();
		curso.setId(idCurso);
		this.iCursoService.excluirCurso(curso);
	}
}