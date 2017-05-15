package com.ipartek.formacion.service.interfaces;

import java.util.List;

import com.ipartek.formacion.coleccion.ColeccionServiceRemote;
import com.ipartek.formacion.persistence.Coleccion;

public interface ColeccionService {

	public void setColeccionServiceRemote(ColeccionServiceRemote coleccionService);

	public Coleccion create(Coleccion coleccion);

	public List<Coleccion> getAll();

	public Coleccion update(Coleccion coleccion);

	public void delete(long codigo);

	public Coleccion getById(long codigo);

}
