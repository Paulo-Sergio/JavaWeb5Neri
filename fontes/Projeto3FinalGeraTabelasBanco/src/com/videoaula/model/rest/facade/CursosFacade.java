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

import com.videoaula.model.Curso;
import com.videoaula.model.Professor;

@Path("/cursos")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Consumes(MediaType.APPLICATION_JSON)
public class CursosFacade {

	static List<Curso> listaCursos = new ArrayList<Curso>();

	static {
		listaCursos.add(new Curso(1, "JAVA WEB", "Segundas as 18 horas",
				new Professor(1, "Paulo Franca", "paulo@gmail.com", "(81)98882-4977")));
		listaCursos.add(new Curso(2, "PHP Basico", "Terça as 19 horas",
				new Professor(2, "NERI", "nericursos@informaticon.com.br", "(54)94469-1223")));
		listaCursos.add(new Curso(3, "DELPHI", "Sexta as 18:30 horas",
				new Professor(2, "NERI", "nericursos@informaticon.com.br", "(54)94469-1223")));
	}

	@GET
	public List<Curso> getcursos() {
		return listaCursos;
	}

	@POST
	public Curso salvar(Curso Curso) {
		System.out.println(Curso);
		listaCursos.add(Curso);
		return Curso;
	}

	@PUT
	public void atualizar(Curso Curso) {
		System.out.println(Curso);
		listaCursos.remove(Curso);
		listaCursos.add(Curso);
	}

	@DELETE
	@Path("/{idCurso}")
	public void excluir(@PathParam("idCurso") Integer idCurso) {
		Curso Curso = new Curso();
		Curso.setId(idCurso);
		System.out.println(Curso);

		listaCursos.remove(Curso);
	}
}