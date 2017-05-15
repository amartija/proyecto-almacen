package com.ipartek.formacion.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ipartek.formacion.fabricante.FabricanteServiceRemote;
import com.ipartek.formacion.persistence.Fabricante;
import com.ipartek.formacion.service.interfaces.FabricanteService;

@Service("fabricanteServiceImp")
public class FabricanteServiceImp implements FabricanteService {

	@Resource(name = "fabricanteServiceRemote")
	private FabricanteServiceRemote fs;

	@Override
	public void setFabricanteServiceRemote(FabricanteServiceRemote fabricanteService) {

		this.fs = fabricanteService;
	}

	@Override
	public Fabricante create(Fabricante fabricante) {

		return fs.create(fabricante);
	}

	@Override
	public List<Fabricante> getAll() {

		return fs.getAll();
	}

	@Override
	public Fabricante update(Fabricante fabricante) {

		return fs.update(fabricante);
	}

	@Override
	public void delete(long codigo) {
		fs.delete(codigo);

	}

	@Override
	public Fabricante getById(long codigo) {

		return fs.getById(codigo);
	}

}
