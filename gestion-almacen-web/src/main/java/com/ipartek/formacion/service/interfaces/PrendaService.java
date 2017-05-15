package com.ipartek.formacion.service.interfaces;

import java.util.List;

import com.ipartek.formacion.persistence.Prenda;
import com.ipartek.formacion.prenda.PrendaServiceRemote;



public interface PrendaService {

	public void setPrendaServiceRemote(PrendaServiceRemote prendaService);

	public Prenda create(Prenda prenda);

	public List<Prenda> getAll();

	public Prenda update(Prenda prenda);

	public void delete(long codigo);

	public Prenda getById(long codigo);
}
