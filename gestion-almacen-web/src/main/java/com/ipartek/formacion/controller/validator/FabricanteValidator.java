package com.ipartek.formacion.controller.validator;

import javax.inject.Inject;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ipartek.formacion.persistence.Fabricante;
import com.ipartek.formacion.service.interfaces.FabricanteService;

public class FabricanteValidator implements Validator {

	@Inject
	private FabricanteService fs;

	@Override
	public boolean supports(Class<?> arg0) {

		return Fabricante.class.equals(arg0);
	}

	@Override
	public void validate(Object obj, Errors errors) {

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "form.nombreRequerido",
				"Tiene que introducirse un nombre de fabricante");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "telefono", "form.telefonoRequerido",
				"Tiene que introducirse un telefono de contacto");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "perconaContacto", "form.telefonoRequerido",
				"Tiene que introducirse una persona de contacto");

		Fabricante fabricante = (Fabricante) obj;
		if (fabricante.getCodigo() < 0) {
			errors.rejectValue("codigo", "valorNegativo", new Object[] { "'codigo'" }, "no puede ser menos que" + 0);

		}

		if (fabricante.getNombre().length() > 30 || fabricante.getNombre().length() < 2) {

			errors.rejectValue("nombre", "form.nombreValidado", new Object[] { 2, 30 },
					"El nombre de fabricante tiene la longitud incorrecta");
		}

		if (fabricante.getTelefono().length() > 10 || fabricante.getTelefono().length() < 7) {

			errors.rejectValue("telefono", "form.telefonoValidado", new Object[] { 7, 10 },
					"La longitud del telefono es incorrecta");
		}

	}

}
