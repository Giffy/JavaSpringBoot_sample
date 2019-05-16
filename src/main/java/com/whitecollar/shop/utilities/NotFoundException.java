package com.whitecollar.shop.utilities;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason="Informacion no encontrado")
public class NotFoundException extends Exception{
	
	public NotFoundException() {};

}
