package com.ipartek.formacion.controller.formater;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.ipartek.formacion.persistence.Fabricante;
import com.ipartek.formacion.service.interfaces.FabricanteService;

public class FabricanteConverter implements Converter<String, Fabricante> {

	@Autowired
	FabricanteService fs;
	private static final Logger logger = LoggerFactory.getLogger(FabricanteConverter.class);

	@Override
	public Fabricante convert(String arg0) {
		logger.info(arg0.toString());
		return fs.getById(Long.parseLong((String) arg0));
	}

}
