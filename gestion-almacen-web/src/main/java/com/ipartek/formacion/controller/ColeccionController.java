package com.ipartek.formacion.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ipartek.formacion.controller.validator.ColeccionValidator;
import com.ipartek.formacion.persistence.Coleccion;
import com.ipartek.formacion.persistence.Fabricante;
import com.ipartek.formacion.persistence.Prenda;
import com.ipartek.formacion.service.interfaces.ColeccionService;
import com.ipartek.formacion.service.interfaces.FabricanteService;
import com.ipartek.formacion.service.interfaces.PrendaService;

@Controller
@RequestMapping(value = "/colecciones")
public class ColeccionController {

	@Autowired
	private ColeccionService cs;
	@Autowired
	private FabricanteService fs;
	@Autowired
	private PrendaService ps;

	@Autowired
	private ServletContext servletContext;

	private static final Logger logger = LoggerFactory.getLogger(ColeccionController.class);
	private ModelAndView mav = null;
	@Autowired
	ColeccionValidator validator1;

	@InitBinder("coleccion")
	public void initBinder(WebDataBinder binder, Locale locale) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		binder.setValidator(validator1);

	}

	@InitBinder("fichero")
	public void initBinder(WebDataBinder binder) {

	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAll() {

		mav = new ModelAndView("colecciones/colecciones");

		List<Coleccion> colecciones = cs.getAll();

		mav.addObject("listadoColecciones", colecciones);

		logger.trace("View getAll()");

		return mav;

	}

	@RequestMapping("/{codigo}")
	public ModelAndView getById(@PathVariable("codigo") long codigo) {

		Coleccion coleccion = null;

		coleccion = cs.getById(codigo);

		logger.info(coleccion.toString());

		mav = new ModelAndView("colecciones/coleccion");

		mav.addObject("coleccion", coleccion);

		return mav;

	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid @RequestParam("fichero") MultipartFile file,
			@ModelAttribute("coleccion") @Validated Coleccion coleccion, ModelMap model, BindingResult bindingResult,
			RedirectAttributes redirectMap) throws IOException {

		String destino = "";
		Coleccion col = null;
		// Mensaje mensaje = null;
		String txt = "";
		if (bindingResult.hasErrors()) {

			logger.trace("Hay un error en el formulario");
			destino = "colecciones/coleccionform";
			model.addAttribute("listadoColecciones", cs.getAll());
			model.addAttribute("listadoFabricantes", fs.getAll());
			model.addAttribute("listadoPrendas", ps.getAll());

		} else {

			destino = "redirect:/colecciones";
			InputStream in = file.getInputStream();

			String root = File.separator + "resources" + File.separator + "docs" + File.separator;

			String ruta = servletContext.getRealPath(root);

			File destination = new File(ruta + file.getOriginalFilename());

			if (!destination.isDirectory()) {

				FileUtils.copyInputStreamToFile(in, destination);
			}

			logger.info(ruta);

			coleccion.setTematica(file.getOriginalFilename());

			if (coleccion.getCodigo() > -1) {

				logger.info(coleccion.toString());
				col = cs.update(coleccion);
			} else {

				logger.info(coleccion.toString());
				col = cs.create(coleccion);
			}
			model.addAttribute("coleccion", col);
		}

		return destino;
	}

	@RequestMapping("/addColeccion")
	public ModelAndView add() {

		mav = new ModelAndView("colecciones/coleccionform");

		mav.addObject("coleccion", new Coleccion());
		mav.addObject("listadoFabricantes", fs.getAll());
		mav.addObject("listadoPrendas", ps.getAll());
		logger.info("Creado nuevo registro de coleccion");

		return mav;
	}

	@RequestMapping("/editColeccion/{codigo}")
	public ModelAndView edit(@PathVariable("codigo") long codigo) {

		mav = new ModelAndView("colecciones/coleccionform");
		Coleccion col = null;
		Coleccion cole = null;
		col = cs.getById(codigo);
		cole = cs.update(col);
		logger.info(cole.toString() + " modificado");
		mav.addObject("coleccion", cole);
		mav.addObject("listadoFabricantes", fs.getAll());
		mav.addObject("listadoPrendas", ps.getAll());

		return mav;
	}

	@RequestMapping("/deleteColeccion/{codigo}")
	public String delete(@PathVariable("codigo") long codìgo) {

		logger.info("Borrado registro coleccion con codigo: " + cs.getById(codìgo).getCodigo());
		cs.delete(codìgo);

		return "redirect:/colecciones";

	}

	@RequestMapping("/{codigocoleccion}/prendas/{codigoprenda}")
	public ModelAndView getPrendaByColeccion(@PathVariable("codigocoleccion") long codigocoleccion,
			@PathVariable("codigoprenda") long codigoprenda) {

		Coleccion coleccion = null;
		Prenda prenda = null;

		coleccion = cs.getById(codigocoleccion);
		prenda = ps.getById(codigoprenda);

		logger.info(coleccion.toString());

		mav = new ModelAndView("colecciones/prendacoleccion");

		mav.addObject("coleccion", coleccion);
		mav.addObject("prenda", prenda);

		return mav;

	}

	@RequestMapping("/{codigocoleccion}/fabricantes/{codigofabricante}")
	public ModelAndView getFabricanteByColeccion(@PathVariable("codigocoleccion") long codigocoleccion,
			@PathVariable("codigofabricante") long codigofabricante) {

		Coleccion coleccion = null;
		Fabricante fabricante = null;

		coleccion = cs.getById(codigocoleccion);
		fabricante = fs.getById(codigofabricante);

		logger.info(coleccion.toString());

		mav = new ModelAndView("colecciones/fabricantecoleccion");

		mav.addObject("coleccion", coleccion);
		mav.addObject("fabricante", fabricante);

		return mav;

	}
}
