package com.kaioferreira.workshopmongo.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kaioferreira.workshopmongo.domain.User;

@RestController
@RequestMapping(value = "/users") //mapeamento endpoint
public class UserResource {

	//definido qual o tipo do metodo
	@RequestMapping(method = RequestMethod.GET) // ou @GetMapping
	//public List<User> findAll(){ //metodo pegando uma lista
	public ResponseEntity<List<User>> findAll() {
		List<User> list = new ArrayList<>(); //instanciando interface
		User maria = new User("1001", "Maria Brown", "maria@gmail.com");
		User alex = new User("1002", "Alex Green", "alex@gmail.com");
		
		list.addAll(Arrays.asList(maria, alex)); //asList coleta os objetos
		
		//return list;
		return ResponseEntity.ok().body(list);
	}
}