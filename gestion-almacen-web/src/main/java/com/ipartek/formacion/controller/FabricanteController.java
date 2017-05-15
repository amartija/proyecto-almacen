package com.ipartek.formacion.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
import org.springframework.web.servlet.ModelAndView;

import com.ipartek.formacion.controller.validator.FabricanteValidator;
import com.ipartek.formacion.persistence.Fabricante;
import com.ipartek.formacion.service.interfaces.FabricanteService;

@Controller
@RequestMapping(value = "/fabricantes")
public class FabricanteController {

	@Autowired
	private FabricanteService fs;

	private static final Logger logger = LoggerFactory.getLogger(FabricanteController.class);
	private ModelAndView mav = null;
	@Autowired
	FabricanteValidator validator;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		binder.setValidator(validator);

	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAll() {

		mav = new ModelAndView("fabricantes/fabricantes");

		List<Fabricante> fabricantes = fs.getAll();

		mav.addObject("listadoFabricantes", fabricantes);

		logger.trace("View getAll()");

		return mav;

	}

	@RequestMapping("/listadoFabricantes")
	public ModelAndView getListado() {

		mav = new ModelAndView("fabricantes/listadoFabricantes");

		return mav;

	}

	@RequestMapping("/{codigo}")
	public ModelAndView getById(@PathVariable("codigo") long codigo) {

		Fabricante fabricante = null;

		fabricante = fs.getById(codigo);
		logger.info(fabricante.toString());

		mav = new ModelAndView("fabricantes/fabricante");

		mav.addObject("fabricante", fabricante);

		return mav;

	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(ModelMap model, @ModelAttribute("fabricante") @Validated Fabricante fabricante,
			BindingResult bindingResult) {

		Fabricante fab = null;
		String destino = "";
		if (bindingResult.hasErrors()) {

			logger.trace("Hay un error en el formulario");
			destino = "fabricantes/fabricanteform";

		} else {

			destino = "redirect:/fabricantes";
			if (fabricante.getCodigo() > -1) {

				logger.info(fabricante.toString());
				fab = fs.update(fabricante);
			} else {

				logger.info(fabricante.toString());
				fab = fs.create(fabricante);
			}
			model.addAttribute("fabricante", fab);
		}

		return destino;
	}

	@RequestMapping("/addFabricante")
	public ModelAndView add() {

		mav = new ModelAndView("fabricantes/fabricanteform");
		mav.addObject("fabricante", new Fabricante());
		logger.info("Creado nuevo registro de fabricante");

		return mav;
	}

	@RequestMapping("/editFabricante/{codigo}")
	public ModelAndView edit(@PathVariable("codigo") long codigo) {

		mav = new ModelAndView("fabricantes/fabricanteform");
		Fabricante fab = null;
		Fabricante fabr = null;
		fab = fs.getById(codigo);
		fabr = fs.update(fab);
		logger.info(fabr.toString());

		mav.addObject("fabricante", fabr);

		return mav;
	}

	@RequestMapping("/deleteFabricante/{codigo}")
	public String delete(@PathVariable("codigo") long codìgo) {

		// mav = new ModelAndView("fabricantes");
		logger.info("Borrado regitro fabricante con codigo: " + fs.getById(codìgo).getCodigo());
		fs.delete(codìgo);

		return "redirect:/fabricantes";

	}

}
