package com.ipartek.formacion.api.webserver.fabricante;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.persistence.Fabricante;
import com.ipartek.formacion.service.interfaces.FabricanteService;

@RestController
@RequestMapping("/api/fabricantes")
public class FabricanteRestController {

	@Autowired
	FabricanteService fs;

	@RequestMapping(value = "/{codigo}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Fabricante> getById(@PathVariable("codigo") long codigo) {

		Fabricante fabricante = fs.getById(codigo);

		ResponseEntity<Fabricante> response = null;

		if (fabricante == null) {

			response = new ResponseEntity<Fabricante>(HttpStatus.NOT_FOUND);

		} else {

			response = new ResponseEntity<Fabricante>(fabricante, HttpStatus.OK);

		}

		return response;

	}

	@RequestMapping(method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Fabricante>> getAll() {

		List<Fabricante> fabricantes = fs.getAll();
		ResponseEntity<List<Fabricante>> response = null;

		if (fabricantes == null || fabricantes.isEmpty()) {

			response = new ResponseEntity<List<Fabricante>>(HttpStatus.NO_CONTENT);

		} else {

			response = new ResponseEntity<List<Fabricante>>(fabricantes, HttpStatus.OK);

		}

		return response;
	}
}
