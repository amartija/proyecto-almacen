package com.ipartek.formacion.api.webserver.coleccion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.persistence.Coleccion;
import com.ipartek.formacion.service.interfaces.ColeccionService;

@RestController
@RequestMapping("/api/colecciones")
public class ColeccionRestController {

	@Autowired
	ColeccionService cs;

	@RequestMapping(method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Coleccion>> getAll() {

		List<Coleccion> colecciones = cs.getAll();
		ResponseEntity<List<Coleccion>> response = null;

		if (colecciones == null || colecciones.isEmpty()) {

			response = new ResponseEntity<List<Coleccion>>(HttpStatus.NO_CONTENT);

		} else {

			response = new ResponseEntity<List<Coleccion>>(colecciones, HttpStatus.OK);

		}

		return response;

	}

	@RequestMapping(value = "/{codigo}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Coleccion> getById(@PathVariable("codigo") long codigo) {

		Coleccion coleccion = cs.getById(codigo);

		ResponseEntity<Coleccion> response = null;

		if (coleccion == null) {

			response = new ResponseEntity<Coleccion>(HttpStatus.NOT_FOUND);

		} else {

			response = new ResponseEntity<Coleccion>(coleccion, HttpStatus.OK);

		}

		return response;

	}

	/*
	 * @RequestMapping(value = "/{codigo}", method = RequestMethod.GET, produces
	 * = { MediaType.APPLICATION_JSON_VALUE }) public ResponseEntity<Coleccion>
	 * update(@PathVariable("codigo") long codigo) { Coleccion col =
	 * cs.getById(codigo); Coleccion coleccion = cs.update(col);
	 * ResponseEntity<Coleccion> response = null;
	 * 
	 * if (coleccion == null) {
	 * 
	 * response = new ResponseEntity<Coleccion>(HttpStatus.NOT_FOUND);
	 * 
	 * } else {
	 * 
	 * response = new ResponseEntity<Coleccion>(coleccion, HttpStatus.OK);
	 * 
	 * }
	 * 
	 * return response; }
	 */

}
