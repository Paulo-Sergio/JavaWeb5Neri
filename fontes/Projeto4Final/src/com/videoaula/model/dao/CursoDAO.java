package com.videoaula.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.videoaula.model.model.Curso;

public class CursoDAO implements ICursoDAO {

	@PersistenceContext(unitName = "Projeto4FinalPersistenceUnit")
	
	private EntityManager entityManager;

	@Override
	public Curso salvarCurso(Curso curso) {
		this.entityManager.persist(curso);
		return curso;
	}

	@Override
	public void alterarCurso(Curso curso) {
		Curso cursoMerge = this.entityManager.merge(curso);
		this.entityManager.persist(cursoMerge);
	}

	@Override
	public void excluirCurso(Curso curso) {
		Curso cursoMerge = this.entityManager.merge(curso);
		this.entityManager.remove(cursoMerge);
	}

	@Override
	public List<Curso> getCursos() {
		Query query = this.entityManager.createQuery("from Curso");
		return query.getResultList();
	}

}
