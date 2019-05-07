package com.whitecollar.project.utilities;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No se ha encontrado")
public class NotFoundException extends Exception {
	public NotFoundException() {
		super();
	}
}
