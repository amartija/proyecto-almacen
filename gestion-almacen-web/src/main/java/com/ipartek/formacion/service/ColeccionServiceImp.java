package com.ipartek.formacion.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ipartek.formacion.coleccion.ColeccionServiceRemote;
import com.ipartek.formacion.persistence.Coleccion;
import com.ipartek.formacion.service.interfaces.ColeccionService;

@Service("coleccionServiceImp")
public class ColeccionServiceImp implements ColeccionService {

	@Resource(name = "coleccionServiceRemote")
	private ColeccionServiceRemote cs;

	@Override
	public void setColeccionServiceRemote(ColeccionServiceRemote coleccionService) {
		this.cs = coleccionService;

	}

	@Override
	public Coleccion create(Coleccion coleccion) {

		return cs.create(coleccion);
	}

	@Override
	public List<Coleccion> getAll() {

		return cs.getAll();
	}

	@Override
	public Coleccion update(Coleccion coleccion) {

		return cs.update(coleccion);
	}

	@Override
	public void delete(long codigo) {
		cs.delete(codigo);

	}

	@Override
	public Coleccion getById(long codigo) {

		return cs.getById(codigo);
	}

}
