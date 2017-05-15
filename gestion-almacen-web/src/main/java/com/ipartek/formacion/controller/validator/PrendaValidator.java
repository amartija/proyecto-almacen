package com.ipartek.formacion.controller.validator;

import javax.inject.Inject;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ipartek.formacion.persistence.Prenda;
import com.ipartek.formacion.service.interfaces.PrendaService;

public class PrendaValidator implements Validator {

	@Inject
	private PrendaService ps;

	@Override
	public boolean supports(Class<?> arg0) {

		return Prenda.class.equals(arg0);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "form.nombreRequerido",
				"Tiene que introducirse un nombre de prenda");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "talla", "form.tallaRequerido",
				"Tiene que introducirse una talla");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "color", "form.colorRequerido",
				"Tiene que introducirse un color");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tipoTela", "form.tipoTelaRequerido",
				"Tiene que introducirse el tipo de tela");

		Prenda prenda = (Prenda) obj;
		if (prenda.getCodigo() < 0) {
			errors.rejectValue("codigo", "valorNegativo", new Object[] { "'codigo'" }, "no puede ser menos que" + 0);

		}

		if (prenda.getNombre().length() > 30 || prenda.getNombre().length() < 2) {

			errors.rejectValue("nombre", "form.nombreValidado", new Object[] { 2, 30 },
					"El nombre de la prenda tiene la longitud incorrecta");
		}

		if (prenda.getTalla().length() > 10 || prenda.getTalla().length() < 2) {

			errors.rejectValue("talla", "form.tallaValidado", new Object[] { 2, 10 },
					"La longitud de la talla es incorrecta");
		}

	}

}
