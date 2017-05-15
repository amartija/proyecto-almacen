package com.ipartek.formacion.fabricante;

import java.util.List;

import javax.ejb.Remote;

import com.ipartek.formacion.persistence.Fabricante;

@Remote
public interface FabricanteServiceRemote {

	public List<Fabricante> getAll();

	public Fabricante getById(Long codigo);

	public Fabricante update(Fabricante fabricante);

	public Fabricante create(Fabricante fabricante);

	public void delete(long codigo);
}
