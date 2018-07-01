package com.arthurbarbosa.jpa2.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.arthurbarbosa.jpa2.modelo.Fabricante;
import com.arthurbarbosa.jpa2.util.jpa.Transactional;

public class FabricanteDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;

	public void salvar(Fabricante fabricante) {
		em.persist(fabricante);
	}

	@SuppressWarnings("unchecked")
	public List<Fabricante> buscarTodos() {
		return em.createQuery("from Fabricante").getResultList();
	}

	@Transactional
	public void excluir(Fabricante fabricanteSelecionado) throws NegocioException {
		Fabricante fabricante = em.find(Fabricante.class, fabricanteSelecionado.getCodigo());
		em.remove(fabricante);
	}
}
