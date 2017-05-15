package com.ipartek.formacion.service.interfaces;

import java.util.List;

import com.ipartek.formacion.fabricante.FabricanteServiceRemote;
import com.ipartek.formacion.persistence.Fabricante;

public interface FabricanteService {

	public void setFabricanteServiceRemote(FabricanteServiceRemote fabricanteService);

	public Fabricante create(Fabricante fabricante);

	public List<Fabricante> getAll();

	public Fabricante update(Fabricante fabricante);

	public void delete(long codigo);

	public Fabricante getById(long codigo);

}
