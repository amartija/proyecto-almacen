package com.ipartek.formacion.coleccion;

import java.util.List;

import javax.ejb.Remote;

import com.ipartek.formacion.persistence.Coleccion;

@Remote
public interface ColeccionServiceRemote {

	public List<Coleccion> getAll();

	public Coleccion getById(Long codigo);

	public Coleccion update(Coleccion coleccion);

	public Coleccion create(Coleccion coleccion);

	public void delete(long codigo);


}
