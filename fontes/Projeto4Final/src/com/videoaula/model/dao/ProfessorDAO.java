package com.videoaula.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.videoaula.model.model.Professor;

public class ProfessorDAO implements IProfessorDAO {

	@PersistenceContext(unitName = "Projeto4FinalPersistenceUnit")
	
	private EntityManager entityManager;

	@Override
	public Professor salvarProfessor(Professor professor) {
		this.entityManager.persist(professor);
		return professor;
	}

	@Override
	public void alterarProfessor(Professor professor) {
		Professor professorMerge = this.entityManager.merge(professor);
		this.entityManager.persist(professorMerge);
	}

	@Override
	public void excluirProfessor(Professor professor) {
		Professor professorMerge = this.entityManager.merge(professor);
		this.entityManager.remove(professorMerge);
	}

	@Override
	public List<Professor> getProfessores() {
		Query query = this.entityManager.createQuery("from Professor");
		return query.getResultList();
	}

}
