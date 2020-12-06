package com.compartilhar.escrita.resources.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.compartilhar.escrita.services.exceptions.ValidationError;


@ControllerAdvice
public class ResourceExceotionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> validation(MethodArgumentNotValidException e,
			                                                            HttpServletRequest request){
	
		ValidationError erro = new ValidationError();
		
	   for(FieldError x : e.getBindingResult().getFieldErrors()) {
		   erro.addError(x.getField(), x.getDefaultMessage());
	   }
	    erro.setTimestamp(System.currentTimeMillis());
			erro.setStatus(422);
			erro.setError("Erro de Validação");
			erro.setMessage(e.getMessage());
			erro.setPath(request.getRequestURI());
			erro.setMensagemDesenvolvedor("http://erros.sistemapedidos.com/422");
			
			
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(erro);
		}
}
