package com.ipartek.formacion.controller.formater;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.ipartek.formacion.persistence.Prenda;
import com.ipartek.formacion.service.interfaces.PrendaService;

public class PrendaConverter implements Converter<String, Prenda> {

	@Autowired
	PrendaService ps;
	private static final Logger logger = LoggerFactory.getLogger(PrendaConverter.class);

	@Override
	public Prenda convert(String arg0) {
		logger.info(arg0.toString());
		return ps.getById(Long.parseLong((String) arg0));
	}

}
