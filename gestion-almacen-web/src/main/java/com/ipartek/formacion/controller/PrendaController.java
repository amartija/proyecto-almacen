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

import com.ipartek.formacion.controller.validator.PrendaValidator;
import com.ipartek.formacion.persistence.Prenda;
import com.ipartek.formacion.service.interfaces.PrendaService;

@Controller
@RequestMapping(value = "/prendas")
public class PrendaController {

	@Autowired
	private PrendaService ps;

	private static final Logger logger = LoggerFactory.getLogger(PrendaController.class);
	private ModelAndView mav = null;

	@Autowired
	PrendaValidator validator;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		binder.setValidator(validator);

	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAll() {

		mav = new ModelAndView("prendas/prendas");

		List<Prenda> prendas = ps.getAll();

		mav.addObject("listadoPrendas", prendas);

		logger.trace("View getAll()");

		return mav;

	}

	@RequestMapping("/{codigo}")
	public ModelAndView getById(@PathVariable("codigo") long codigo) {

		Prenda prenda = null;

		prenda = ps.getById(codigo);
		logger.info(prenda.toString());

		mav = new ModelAndView("prendas/prenda");

		mav.addObject("prenda", prenda);

		return mav;

	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(ModelMap model, @ModelAttribute("prenda") @Validated Prenda prenda,
			BindingResult bindingResult) {
		String destino = "";

		Prenda pre = null;
		if (bindingResult.hasErrors()) {

			logger.trace("Hay un error en el formulario");
			mav = new ModelAndView("prendas/prendaform");
			destino = "prendas/prendaform";

		} else {

			destino = "redirect:/prendas";
			if (prenda.getCodigo() > -1) {

				logger.info(prenda.toString());
				pre = ps.update(prenda);
			} else {

				logger.info(prenda.toString());
				pre = ps.create(prenda);
			}
			model.addAttribute("prenda", pre);
		}

		return destino;
	}

	@RequestMapping("/addPrenda")
	public ModelAndView add() {

		mav = new ModelAndView("prendas/prendaform");
		mav.addObject("prenda", new Prenda());
		logger.info("Creado nuevo regitro de prenda");

		return mav;
	}

	@RequestMapping("/editPrenda/{codigo}")
	public ModelAndView edit(@PathVariable("codigo") long codigo) {

		mav = new ModelAndView("prendas/prendaform");
		Prenda pre = null;
		Prenda pren = null;
		pre = ps.getById(codigo);
		pren = ps.update(pre);
		logger.info(pren.toString());

		mav.addObject("prenda", pren);

		return mav;
	}

	@RequestMapping("/deletePrenda/{codigo}")
	public String delete(@PathVariable("codigo") long codìgo) {

		logger.info("Borrado regitro prenda con codigo: " + ps.getById(codìgo).getCodigo());
		ps.delete(codìgo);

		return "redirect:/prendas";

	}

	@RequestMapping("/listadoPrendas")
	public ModelAndView getListado() {

		mav = new ModelAndView("prendas/listadoPrendas");

		return mav;

	}

}
