package com.videoaula.model.dao;

import java.util.List;

import com.videoaula.model.model.Curso;

public interface ICursoDAO {

	Curso salvarCurso(Curso Curso);
	
	void alterarCurso(Curso Curso);
	
	void excluirCurso(Curso Curso);
	
	List<Curso> getCursos();
}
