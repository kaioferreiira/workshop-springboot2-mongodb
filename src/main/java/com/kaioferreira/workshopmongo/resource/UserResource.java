package com.kaioferreira.workshopmongo.resource;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kaioferreira.workshopmongo.domain.User;
import com.kaioferreira.workshopmongo.dto.UserDTO;
import com.kaioferreira.workshopmongo.service.UserService;

@RestController
@RequestMapping(value = "/users") // mapeamento endpoint
public class UserResource {

	// injetando servico do User
	@Autowired
	private UserService userService;

	/*
	 * //definido qual o tipo do metodo
	 * 
	 * @RequestMapping(method = RequestMethod.GET) // ou @GetMapping //public
	 * List<User> findAll(){ //metodo pegando uma lista public
	 * ResponseEntity<List<User>> findAll() { List<User> list = new ArrayList<>();
	 * //instanciando interface User maria = new User("1001", "Maria Brown",
	 * "maria@gmail.com"); User alex = new User("1002", "Alex Green",
	 * "alex@gmail.com");
	 * 
	 * list.addAll(Arrays.asList(maria, alex)); //asList coleta os objetos
	 * 
	 * //return list; return ResponseEntity.ok().body(list); }
	 */

	/*
	 * metodos para encontrar todos com o ReponseEntity
	 * 
	 * @RequestMapping(method = RequestMethod.GET) // ou @GetMapping //public
	 * List<User> findAll(){ //metodo pegando uma lista public
	 * ResponseEntity<List<User>> findAll() { List<User> list =
	 * userService.findAll(); //return list com dados buscados; return
	 * ResponseEntity.ok().body(list); }
	 */

	/// metodos para encontrar todos com o ReponseEntity com o DTO
	@RequestMapping(method = RequestMethod.GET) // ou @GetMapping
	// public List<User> findAll(){ //metodo pegando uma lista
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> list = userService.findAll();
		// converto os elementos da lista para DTO. Lista orignal,Stream é uma coleção
		// do java8 e
		// o Map pega cada ob x e retorna um new dto e coleta toda lista.

		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		// return list com dados buscados;
		return ResponseEntity.ok().body(listDto);
	}

	/// metodos para encontrar o objeto pelo id
	@RequestMapping(value = "/{id}", method = RequestMethod.GET) // ou @GetMapping
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		User userObj = userService.findById(id);
		return ResponseEntity.ok().body(new UserDTO(userObj));
	}

}