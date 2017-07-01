package com.videoaula.model.dao;

import java.util.List;

import com.videoaula.model.model.Professor;

public interface IProfessorDAO {

	Professor salvarProfessor(Professor professor);
	
	void alterarProfessor(Professor professor);
	
	void excluirProfessor(Professor professor);
	
	List<Professor> getProfessores();
}
