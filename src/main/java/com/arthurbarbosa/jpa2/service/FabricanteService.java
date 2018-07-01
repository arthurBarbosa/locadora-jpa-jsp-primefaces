package com.arthurbarbosa.jpa2.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.arthurbarbosa.jpa2.dao.FabricanteDAO;
import com.arthurbarbosa.jpa2.dao.NegocioException;
import com.arthurbarbosa.jpa2.modelo.Fabricante;
import com.arthurbarbosa.jpa2.util.jpa.Transactional;

public class FabricanteService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private FabricanteDAO fabricanteDAO;

	@Transactional
	public void salvar(Fabricante fabricante) throws NegocioException {
		if (fabricante.getNome() == null || fabricante.getNome().trim().equals("")) {
			throw new NegocioException("O nome do fabricante é obrigatorio");
		}
		this.fabricanteDAO.salvar(fabricante);

	}

}
