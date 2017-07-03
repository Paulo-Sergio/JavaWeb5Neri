package com.videoaula.model.service;

import java.util.List;

import com.videoaula.model.model.Curso;

public interface ICursoService {

	Curso salvarCurso(Curso Curso);
	
	void alterarCurso(Curso Curso);
	
	void excluirCurso(Curso Curso);
	
	List<Curso> getCursos();
}
