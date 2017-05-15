package com.ipartek.formacion.api.webserver.prenda;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.persistence.Prenda;
import com.ipartek.formacion.service.interfaces.PrendaService;

@RestController
@RequestMapping("/api/prendas")
public class PrendaRestController {

	@Autowired
	PrendaService ps;

	@RequestMapping(method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Prenda>> getAll() {

		List<Prenda> prendas = ps.getAll();
		ResponseEntity<List<Prenda>> response = null;

		if (prendas == null || prendas.isEmpty()) {

			response = new ResponseEntity<List<Prenda>>(HttpStatus.NO_CONTENT);

		} else {

			response = new ResponseEntity<List<Prenda>>(prendas, HttpStatus.OK);

		}

		return response;
	}
}
