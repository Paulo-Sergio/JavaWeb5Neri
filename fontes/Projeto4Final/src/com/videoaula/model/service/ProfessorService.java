package com.videoaula.model.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.videoaula.model.dao.IProfessorDAO;
import com.videoaula.model.model.Professor;

public class ProfessorService implements IProfessorService{

	@Inject
	private IProfessorDAO iProfessorDAO;
	
	@Override
	public List<Professor> getProfessores() {
		return this.iProfessorDAO.getProfessores();
	}
	
	@Override
	@Transactional
	public Professor salvarProfessor(Professor professor) {
		return this.iProfessorDAO.salvarProfessor(professor);
	}

	@Override
	@Transactional
	public void alterarProfessor(Professor professor) {
		this.iProfessorDAO.alterarProfessor(professor);
	}

	@Override
	@Transactional
	public void excluirProfessor(Professor professor) {
		this.iProfessorDAO.excluirProfessor(professor);
	}

}
