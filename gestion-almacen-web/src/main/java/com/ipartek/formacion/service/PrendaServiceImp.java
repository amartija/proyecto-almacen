package com.ipartek.formacion.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


import com.ipartek.formacion.persistence.Prenda;
import com.ipartek.formacion.prenda.PrendaServiceRemote;
import com.ipartek.formacion.service.interfaces.PrendaService;

@Service("prendaServiceImp")
public class PrendaServiceImp implements PrendaService {

	@Resource(name = "prendaServiceRemote")
	private PrendaServiceRemote ps;
	
	@Override
	public void setPrendaServiceRemote(PrendaServiceRemote prendaService) {
		this.ps = prendaService;
		
	}

	@Override
	public Prenda create(Prenda prenda) {
		
		return ps.create(prenda);
	}

	@Override
	public List<Prenda> getAll() {
		
		return ps.getAll();
	}

	@Override
	public Prenda update(Prenda prenda) {
		
		return ps.update(prenda);
	}

	@Override
	public void delete(long codigo) {
		ps.delete(codigo);
		
	}

	@Override
	public Prenda getById(long codigo) {
		
		return ps.getById(codigo);
	}

}
