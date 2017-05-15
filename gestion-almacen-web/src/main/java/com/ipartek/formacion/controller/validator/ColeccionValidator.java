package com.ipartek.formacion.controller.validator;

import javax.inject.Inject;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ipartek.formacion.persistence.Coleccion;
import com.ipartek.formacion.service.interfaces.ColeccionService;

public class ColeccionValidator implements Validator {

	@Inject
	private ColeccionService cs;

	@Override
	public boolean supports(Class<?> paramClass) {

		return Coleccion.class.equals(paramClass);
	}

	@Override
	public void validate(Object obj, Errors errors) {

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "year", "form.yearRequerido",
				"Tiene que introducirse un año coleccion");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fEntrada", "form.fEntradaRequerido",
				"Tiene que introducirse la fecha de entrada");

		Coleccion coleccion = (Coleccion) obj;
		if (coleccion.getCodigo() < 0) {
			errors.rejectValue("codigo", "valorNegativo", new Object[] { "'codigo'" }, "no puede ser menos que" + 0);

		}

		if (coleccion.getYear().length() > 5 || coleccion.getYear().length() < 2) {

			errors.rejectValue("year", "form.yearValidado", new Object[] { 2, 5 },
					"El año de coleccion tiene la longitud incorrecta");
		}

		if (coleccion.getTematica().length() > 10 || coleccion.getTematica().length() < 2) {

			errors.rejectValue("tematica", "form.tematicaValidado", new Object[] { 2, 10 },
					"El tamaño de tematica es incorrecto");
		}

		if (coleccion.getGama().length() > 10 || coleccion.getGama().length() < 2) {

			errors.rejectValue("gama", "form.gamaValidado", new Object[] { 2, 10 },
					"El tamaño de la gama es incorrecto");
		}

	}

}
