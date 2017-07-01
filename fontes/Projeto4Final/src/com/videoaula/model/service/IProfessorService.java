package com.videoaula.model.service;

import java.util.List;

import com.videoaula.model.model.Professor;

public interface IProfessorService {

	Professor salvarProfessor(Professor professor);

	void alterarProfessor(Professor professor);

	void excluirProfessor(Professor professor);

	List<Professor> getProfessores();
}
