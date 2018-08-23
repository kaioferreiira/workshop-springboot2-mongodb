package com.kaioferreira.workshopmongo.resource.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.kaioferreira.workshopmongo.exception.ObjectNotFoundException;

@ControllerAdvice //indica que essa classe ira tratar possiveis erros de requisições 
public class ResourceExceptionHandler {

	//metodo para tratar a exception
	//quando der um erro der um erro no serviço essa exception ele gera um StandarError 
	//Colocar a anotação para dizer que esse metodo é uma exeption 20
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		/*Recebe
		 * 1: instante de ocorreu o erro
		 * 2: status do erro 404
		 * 3: erro não encontrado
		 * 4: pega a mensagem do ObjectNotFoundException
		 * 5: caminho: usa o request
		 * */
		HttpStatus status =  HttpStatus.NOT_FOUND;
		StandardError error =  new StandardError(System.currentTimeMillis(), status.value(), "Não encontrado!", e.getMessage(), request.getRequestURI());  
				
		//retorna o responseEntity
		return  ResponseEntity.status(status).body(error);
	}
}
