package com.whitecollar.project.utilities;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE, reason = "Informaci�n inv�lida")
public class InvalidParamException extends Exception {

	public InvalidParamException() {
		super("Invalid param error");
	}
}
