package com.ipartek.formacion.prenda;

import java.util.List;

import javax.ejb.Remote;

import com.ipartek.formacion.persistence.Prenda;

@Remote
public interface PrendaServiceRemote {

	public List<Prenda> getAll();

	public Prenda getById(Long codigo);

	public Prenda update(Prenda prenda);

	public Prenda create(Prenda prenda);

	public void delete(long codigo);
}
