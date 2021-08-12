package it.epicode.be.exception.handlers;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class DataAccesExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(DataAccessException.class)
	protected ResponseEntity<Object> handlerDataAccessException(DataAccessException e){
		return new ResponseEntity<>("Errore nella connessione con il DataBase",HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
