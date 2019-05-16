package com.whitecollar.shop.utilities;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE, reason="Informacion invalida")
public class InvalidParamException extends Exception{
	
	public InvalidParamException() {};

}
