package com.videoaula.model.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.videoaula.model.dao.ICursoDAO;
import com.videoaula.model.model.Curso;

public class CursoService implements ICursoService{

	@Inject
	private ICursoDAO iCursoDAO;
	
	@Override
	public List<Curso> getCursos() {
		return this.iCursoDAO.getCursos();
	}
	
	@Override
	@Transactional
	public Curso salvarCurso(Curso curso) {
		return this.iCursoDAO.salvarCurso(curso);
	}

	@Override
	@Transactional
	public void alterarCurso(Curso curso) {
		this.iCursoDAO.alterarCurso(curso);
	}

	@Override
	@Transactional
	public void excluirCurso(Curso curso) {
		this.iCursoDAO.excluirCurso(curso);
	}

}
