package com.arthurbarbosa.jpa2.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.arthurbarbosa.jpa2.dao.NegocioException;
import com.arthurbarbosa.jpa2.modelo.Fabricante;
import com.arthurbarbosa.jpa2.service.FabricanteService;
import com.arthurbarbosa.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
public class FabricanteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private FabricanteService fabricanteService;

	private Fabricante fabricante;

	public void salvar() {
		try {
			this.fabricanteService.salvar(fabricante);
			FacesUtil.addSuccessMessage("Fabricante salvo com sucesso");
			this.limpar();
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	@PostConstruct
	public void init() {
		this.limpar();
	}

	public void limpar() {
		this.fabricante = new Fabricante();
	}

	public FabricanteService getFabricanteService() {
		return fabricanteService;
	}

	public void setFabricanteService(FabricanteService fabricanteService) {
		this.fabricanteService = fabricanteService;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

}
